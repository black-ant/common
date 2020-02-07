package com.gang.common.msg.rabbitmq.logic;

import com.gang.common.lib.to.ResponseModel;
import com.gang.common.msgapi.to.MsgBody;
import com.gang.common.msgapi.to.MsgOverTO;
import com.gang.common.msgapi.to.MsgQueueInfo;
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
public class ProduceService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProduceService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public ResponseModel<MsgOverTO> sendMsg(MsgQueueInfo msgQueueInfo, MsgBody msgBody) {
        this.rabbitTemplate.convertAndSend(msgQueueInfo.getQueueId(), msgBody);
        return ResponseModel.commonResponse(new MsgOverTO(null, "send over"));
    }


}
