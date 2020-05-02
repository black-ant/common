package com.gang.common.msg.rabbitmq.logic;

import com.gang.common.msg.logic.IMsgConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @Classname RabbitConsumerService
 * @Description TODO
 * @Date 2020/3/1 18:47
 * @Created by zengzg
 */
@Component
public class RabbitConsumerService implements IMsgConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Consumer<String> consumer;

    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void processByDeclare(String message) {
        logger.info("------> 自动创建 queue 发送接收成功   :{}<-------", message);
        consumer.accept(message);
    }

    @Override
    public void setConsumer(Consumer<String> consumer) {
        this.consumer = consumer;
    }
}
