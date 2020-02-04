package com.gang.common.cache.common;

/**
 * @Classname ICacheService
 * @Description TODO
 * @Date 2020/2/4 21:32
 * @Created by zengzg
 */
public interface ICacheOperation<T> {

    T get(String key);

    Boolean set(String key, T t);

    Boolean refush(String key, T t);

}
