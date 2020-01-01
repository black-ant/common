package com.gang.sdk.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname SyncParam
 * @Description TODO
 * @Date 2019/12/29 23:21
 * @Created by zengzg
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface SyncParam {

    String name() default "";
}
