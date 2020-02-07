package com.gang.common.cache.logic;

import com.gang.common.cache.common.ICacheOperation;
import com.gang.common.lib.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Classname CacheInvole
 * @Description TODO
 * @Date 2020/2/4 21:17
 * @Created by zengzg
 */
@Component
public class CacheInvoke implements ICacheOperation<Object> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Object get(String key) {
        logger.info("------> :{} <-------", cacheManage().get(key));
        return null;
    }

    @Override
    public Boolean set(String key, Object o) {
        return null;
    }

    @Override
    public Boolean refush(String key, Object o) {
        return null;
    }

    /**
     * @return
     */
    public ICacheOperation cacheManage() {
        if (Boolean.TRUE) {
            return new RedisCache();
        }
        return new RedisCache();
    }

}
