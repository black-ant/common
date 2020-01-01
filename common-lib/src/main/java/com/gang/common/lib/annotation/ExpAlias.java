package com.gang.common.lib.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname ExpAlias
 * @Description TODO
 * @Date 2019/12/7 21:40
 * @Created by zengzg
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@Documented
public @interface ExpAlias {

    String alias() default "";

    String type() default "";

}
