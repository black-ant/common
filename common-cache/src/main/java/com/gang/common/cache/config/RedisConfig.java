package com.gang.common.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Classname RedisConfig
 * @Description TODO
 * @Date 2020/2/7 22:38
 * @Created by zengzg
 */
public class RedisConfig {

    @Bean
    public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        logger.info("------> this is in StringRedisTemplate <-------");
        try {
            redisConnectionFactory.getConnection();
        } catch (Exception e) {
            logger.info("------> this is in Connection <-------");
        }
        logger.info("------> this is in Connection ok<-------");
        return new StringRedisTemplate(redisConnectionFactory);
    }

}
