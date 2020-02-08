package com.gang.common.cache.logic;

import com.gang.common.cache.common.AbstractCache;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Classname MemoryCache
 * @Description TODO
 * @Date 2020/2/8 16:30
 * @Created by zengzg
 */
@Component
public class MemoryCache extends AbstractCache<Object> {

    private Map<String, Object> map = new ConcurrentHashMap<>();

    @Override
    public Object get(String key) {
        return map.get(key);
    }

    @Override
    public Boolean set(String key, Object o) {
        map.put(key, o);
        return Boolean.TRUE;
    }

    @Override
    public Boolean refush(String key, Object o) {
        return null;
    }
}
