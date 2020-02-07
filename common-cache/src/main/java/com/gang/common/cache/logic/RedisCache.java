package com.gang.common.cache.logic;

import com.gang.common.cache.common.ICacheOperation;
import com.gang.common.cache.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Classname RedisCache
 * @Description TODO
 * @Date 2020/2/4 21:28
 * @Created by zengzg
 */
@Component
public class RedisCache extends AbstractCache<Object> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RedisUtils redisUtils;

    public RedisCache() {
        init();
    }

    @Override
    public Object get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public Boolean set(String key, Object o) {
        return redisUtils.set(key, o);
    }

    @Override
    public Boolean refush(String key, Object o) {
        return null;
    }


    public void init() {
        this.redisUtils = new RedisUtils();
    }


}
