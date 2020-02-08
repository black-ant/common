package com.gang.common.cache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Classname CacheConfigTO
 * @Description TODO
 * @Date 2020/2/8 16:45
 * @Created by zengzg
 */
@ConfigurationProperties(prefix = "gang.cache")
@Data
public class CacheConfigInfo {

    // memory / redis
    private String type = "MEMORY";

}
