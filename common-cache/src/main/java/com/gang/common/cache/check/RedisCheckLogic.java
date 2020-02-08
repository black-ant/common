package com.gang.common.cache.check;

import com.gang.common.cache.common.ICheckLogic;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * @Classname RedisCheckLogic
 * @Description TODO
 * @Date 2020/2/8 18:02
 * @Created by zengzg
 */
@Component
public class RedisCheckLogic implements ICheckLogic {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Lazy
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public Boolean check() {
        try {
            redisConnectionFactory.getConnection();
        } catch (Exception e) {
            logger.error("E----> Redis Connection error :{} -- content :{}", e.getClass() + e.getMessage(), e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
