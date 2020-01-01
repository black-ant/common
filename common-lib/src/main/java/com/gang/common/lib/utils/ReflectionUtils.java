package com.gang.common.lib.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Classname ReflectionUtils
 * @Description TODO
 * @Date 2019/11/6 22:35
 * @Created by ant-black 1016930479@qq.com
 */
public class ReflectionUtils {

    /**
     * 获取所有field字段，包含父类继承的
     *
     * @param clazz 字段所属类型
     * @return
     */
    public static Field[] getFields(Class<?> clazz) {
        return getFields(clazz, null);
    }

    /**
     * 获取指定类的所有的field,包括父类
     *
     * @param clazz       字段所属类型
     * @param fieldFilter 字段过滤器
     * @return 符合过滤器条件的字段数组
     */
    public static Field[] getFields(Class<?> clazz, Predicate<Field> fieldFilter) {
        List<Field> fields = new ArrayList<>(32);
        while (Object.class != clazz && clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                if (fieldFilter != null && !fieldFilter.test(field)) {
                    continue;
                }
                fields.add(field);
            }
            clazz = clazz.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }

    /**
     * 对指定类的所有字段执行consumer操作
     *
     * @param clazz    目标对象
     * @param consumer 对字段进行操作
     */
    public static void doWithFields(Class<?> clazz, Consumer<Field> consumer) {
        Arrays.stream(getFields(clazz)).forEach(consumer);
    }

    /**
     * 获取指定类的指定field,包括父类
     *
     * @param clazz 字段所属类型
     * @param name  字段名
     * @return
     */
    public static Field getField(Class<?> clazz, String name) {
        return getField(clazz, name, null);
    }

    /**
     * 获取指定类的指定field,包括父类
     *
     * @param clazz 字段所属类型
     * @param name  字段名
     * @param type  field类型
     * @return
     */
    public static Field getField(Class<?> clazz, String name, Class<?> type) {
        while (clazz != Object.class && clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                if ((name == null || name.equals(field.getName())) &&
                        (type == null || type.equals(field.getType()))) {
                    return field;
                }
            }
            clazz = clazz.getSuperclass();
        }
        throw new IllegalStateException(clazz.getName() + "." + name + "字段不存在！");
    }

    /**
     * 获取字段值
     *
     * @param field  字段
     * @param target 字段所属实例对象
     * @return
     */
    public static Object getFieldValue(Field field, Object target) {
        makeAccessible(field);
        try {
            return field.get(target);
        } catch (Exception e) {
            throw new IllegalStateException("获取field值错误！");
        }
    }

    /**
     * 获取对象中指定field值
     *
     * @param obj       对象
     * @param fieldName 字段名
     * @return
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        if (ObjectUtils.isWrapperOrPrimitive(obj)) {
            return obj;
        }
        return getFieldValue(getField(obj.getClass(), fieldName), obj);
    }

    /**
     * 获取指定对象中指定字段路径的值(类似js访问对象属性) <br/>
     * 如：Product p = new Product(new User())  <br/>
     * 可使用ReflectionUtils.getValueByFieldPath(p, "user.name")获取到用户的name属性
     *
     * @param obj       取值对象
     * @param fieldPath 字段路径(形如 user.name)
     * @return 字段value
     */
    public static Object getValueByFieldPath(Object obj, String fieldPath) {
        String[] fieldNames = fieldPath.split("\\.");
        Object result = null;
        for (String fieldName : fieldNames) {
            result = getFieldValue(obj, fieldName);
            if (result == null) {
                return null;
            }
            obj = result;
        }
        return result;
    }

    /**
     * 设置字段值
     *
     * @param field  字段
     * @param target 字段所属对象实例
     * @param value  需要设置的值
     */
    public static void setFieldValue(Field field, Object target, Object value) {
        makeAccessible(field);
        try {
            field.set(target, value);
        } catch (Exception e) {
            throw new IllegalStateException("设置field值错误！");
        }
    }

    /**
     * 设置字段为可见
     *
     * @param field
     */
    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) ||
                !Modifier.isPublic(field.getDeclaringClass().getModifiers()) ||
                Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    /**
     * 调用无参数方法
     *
     * @param method 方法对象
     * @param target 调用对象
     * @return 执行结果
     */
    public static Object invokeMethod(Method method, Object target) {
        return invokeMethod(method, target, new Object[0]);
    }

    /**
     * 调用指定对象的方法
     *
     * @param method 方法对象
     * @param target 调用对象
     * @param args   方法参数
     * @return 执行结果
     */
    public static Object invokeMethod(Method method, Object target, Object... args) {
        try {
            makeAccessible(method);
            return method.invoke(target, args);
        } catch (Exception ex) {
            throw new IllegalStateException("执行方法失败！", ex);
        }
    }

    /**
     * 设置方法可见性
     *
     * @param method
     */
    public static void makeAccessible(Method method) {
        if ((!Modifier.isPublic(method.getModifiers()) ||
                !Modifier.isPublic(method.getDeclaringClass().getModifiers())) && !method.isAccessible()) {
            method.setAccessible(true);
        }
    }

    /**
     * 是否为equals方法
     *
     * @see Object#equals(Object)
     */
    public static boolean isEqualsMethod(Method method) {
        if (method == null || !method.getName().equals("equals")) {
            return false;
        }
        Class<?>[] paramTypes = method.getParameterTypes();
        return (paramTypes.length == 1 && paramTypes[0] == Object.class);
    }

    /**
     * 是否为hashCode方法
     *
     * @see Object#hashCode()
     */
    public static boolean isHashCodeMethod(Method method) {
        return (method != null && method.getName().equals("hashCode") && method.getParameterCount() == 0);
    }

    /**
     * 是否为Object的toString方法
     *
     * @see Object#toString()
     */
    public static boolean isToStringMethod(Method method) {
        return (method != null && method.getName().equals("toString") && method.getParameterCount() == 0);
    }
}
