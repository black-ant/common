package com.gang.common.cache.common;

import com.gang.common.cache.common.ICacheOperation;
import com.gang.common.cache.logic.RedisCache;
import com.gang.common.lib.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Classname CacheInvole
 * @Description TODO
 * @Date 2020/2/4 21:17
 * @Created by zengzg
 */
@Component
public class CacheInvoke implements ICacheOperation<Object> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "selfCache")
    private ICacheOperation iCacheOperation;

    @Override
    public Object get(String key) {
        logger.info("------> :{} <-------", iCacheOperation.get(key));
        return iCacheOperation.get(key);
    }

    @Override
    public Boolean set(String key, Object o) {
        logger.info("------> :{} <-------", iCacheOperation.get(key));
        return iCacheOperation.set(key, o);
    }

    @Override
    public Boolean refush(String key, Object o) {
        return null;
    }

}
