package com.gang.common.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname RabbitApplication
 * @Description TODO
 * @Date 2020/2/5 21:18
 * @Created by zengzg
 */
@SpringBootApplication(scanBasePackages = {"com.gang.common"})
public class RabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class, args);
    }
}
