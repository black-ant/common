package com.gang.common.lib.annotation;

/**
 * @Classname GMethod
 * @Description TODO
 * @Date 2020/2/22 21:33
 * @Created by zengzg
 */
public @interface GMethod {

    String name() default "";

    String type() default "";

    String back() default "";

    String info() default "";
}
