package com.gang.common.cache.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Classname TestClass
 * @Description TODO
 * @Date 2020/2/4 22:52
 * @Created by zengzg
 */
@Component
public class TestClass implements ApplicationRunner {

    @Autowired
    private CacheInvoke cacheInvoke;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        cacheInvoke.get("test");
    }
}
