package com.gang.common.lib.annotation;

/**
 * @Classname GFiled
 * @Description TODO
 * @Date 2020/2/22 21:18
 * @Created by zengzg
 */
public @interface GFiled {

    String name() default "";

    String alias() default "";

    String type() default "";

    String exteriorName() default "";

    String defaultValue() default "";
}
