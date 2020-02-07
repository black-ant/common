package com.gang.ext.sdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname SDKParentApplication
 * @Description TODO
 * @Date 2019/12/28 18:38
 * @Created by zengzg
 */
@SpringBootApplication
public class SDKParentApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SDKParentApplication.class, args).getBeanFactory();
    }
}
