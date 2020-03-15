package com.gang.common.msg.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname AcceptLogic
 * @Description TODO
 * @Date 2020/2/5 15:35
 * @Created by zengzg
 */
@Component
@RabbitListener(queues = "hello")
public class AcceptLogic {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

}
