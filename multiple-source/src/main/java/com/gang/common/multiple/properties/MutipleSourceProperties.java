package com.gang.common.multiple.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname JpaProperties
 * @Description TODO
 * @Date 2020/1/29 20:54
 * @Created by zengzg
 */
@Configuration
@PropertySource(value = {"classpath:application-mutipleSource.yml", "classpath:application.yml"})
@ConfigurationProperties(prefix = "com.gang.datasouce")
public class MutipleSourceProperties {
}
