package com.gang.sdk.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname SyncClass
 * @Description TODO
 * @Date 2020/1/22 17:40
 * @Created by zengzg
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface SyncClass {

    String type() default "";

    String value() default "";

}
