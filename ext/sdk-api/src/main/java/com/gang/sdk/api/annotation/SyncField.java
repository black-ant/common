package com.gang.sdk.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname SyncField
 * @Description TODO
 * @Date 2020/2/2 11:25
 * @Created by zengzg
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface SyncField {

    String defaultValue() default "";

    String name() default "";

    String alias() default "";

}
