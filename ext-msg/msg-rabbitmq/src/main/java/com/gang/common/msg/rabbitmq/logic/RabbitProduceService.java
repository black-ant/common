package com.gang.common.msg.rabbitmq.logic;

import com.gang.common.lib.to.ResponseModel;
import com.gang.common.msg.config.RabbitConfig;
import com.gang.common.msgapi.logic.IMsgProduce;
import com.gang.common.msgapi.to.MsgBaseBody;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname ProduceService
 * @Description TODO
 * @Date 2020/2/5 15:37
 * @Created by zengzg
 */
@Component
public class RabbitProduceService implements IMsgProduce<RabbitConfig, MsgBaseBody> {

    @Autowired
    private RabbitTemplate template;
    private RabbitConfig config;

    @Override
    public Boolean init(RabbitConfig config) {
        this.config = config;
        return Boolean.TRUE;
    }

    @Override
    public ResponseModel sendMsg(MsgBaseBody msgBody) {
        template.convertAndSend("myExchange", config.getRouting(), msgBody.getData());
        return ResponseModel.commonResponse("success");
    }
}
