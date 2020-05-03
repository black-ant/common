package com.gang.common.cache.logic;

import com.gang.common.cache.common.AbstractCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Classname RedisCache
 * @Description TODO
 * @Date 2020/2/4 21:28
 * @Created by zengzg
 */
@Component
@Lazy
public class RedisCache extends AbstractCache<Object> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "selfRedisTemplate")
    @Lazy
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean refush(String key, Object o) {
        return null;
    }


}
