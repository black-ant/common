package com.gang.common.cache.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Classname RedisConfig
 * @Description TODO
 * @Date 2020/2/7 22:38
 * @Created by zengzg
 */
@Configuration
public class RedisConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    @Lazy
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {

        logger.info("------> this is in StringRedisTemplate <-------");
        try {
            redisConnectionFactory.getConnection();
            StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
            template.afterPropertiesSet();
            return template;
        } catch (Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass(), e.getMessage());
        }
        logger.info("------> this is in Connection ok<-------");


        return new StringRedisTemplate(null);
    }

    @Bean(value = "selfRedisTemplate")
    @Lazy
    public RedisTemplate<String, Object> setRedisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate redisTemplate = new RedisTemplate();
        try {
            redisConnectionFactory.getConnection();
        } catch (Exception e) {
            logger.error("E----> setRedisTemplate Error ");
            return redisTemplate;
        }
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();


        return redisTemplate;
    }

}
