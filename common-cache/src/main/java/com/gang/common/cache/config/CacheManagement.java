package com.gang.common.cache.config;

import com.gang.common.cache.check.RedisCheckLogic;
import com.gang.common.cache.common.ICacheOperation;
import com.gang.common.cache.common.AbstractCache;
import com.gang.common.cache.common.ICheckLogic;
import com.gang.common.cache.logic.MemoryCache;
import com.gang.common.cache.logic.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Classname CacheManagement
 * @Description TODO
 * @Date 2020/2/8 16:27
 * @Created by zengzg
 */
@Component
@EnableConfigurationProperties(CacheConfigInfo.class)
@Configuration
public class CacheManagement {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheConfigInfo cacheConfigInfo;

    @Autowired
    private RedisCheckLogic redisCheckLogic;

    @Value("${ant.common.config.cache.type:memory}")
    private String cacheType;

    @Resource
    private MemoryCache memoryCache;

    @Resource
    private RedisCache redisCache;

    @Bean(name = "selfCache")
    public ICacheOperation getCache() {
        logger.info("------>  加载Bean  <-------");
        if ("memory".equals(cacheType)) {
            return memoryCache;
        } else {
            if (redisCheckLogic.check()) {
                return redisCache;
            }
        }
        logger.info("------> this is cache memory <-------");
        return new MemoryCache();
    }


}
