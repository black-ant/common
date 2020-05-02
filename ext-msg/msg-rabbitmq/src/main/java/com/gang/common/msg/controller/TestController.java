package com.gang.common.msg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/2/29 17:38
 * @Created by zengzg
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //    @GetMapping("/send")
    //    public String send() {
    //        logger.info("------> this is in test <-------");
    //
    //        MsgBody msgBody = new MsgBody();
    //        msgBody.setStatus(Boolean.TRUE);
    //        msgBody.setData("this is ok");
    //
    //        sendMsg(getStrategy(), msgBody);
    //        return "";
    //    }
    //
    //    public MsgQueueInfo getStrategy() {
    //        MsgQueueInfo msgQueueInfo = new MsgQueueInfo();
    //        msgQueueInfo.setQueueId("hello");
    //        msgQueueInfo.setExchange("1");
    //        msgQueueInfo.setRouting("1");
    //        return msgQueueInfo;
    //    }
    //
    //    public ResponseModel<MsgOverTO> sendMsg(MsgQueueInfo msgQueueInfo, MsgBody
    //    msgBody) {
    //        this.rabbitTemplate.convertAndSend(msgQueueInfo.getQueueId(), msgBody);
    //        return ResponseModel.commonResponse(new MsgOverTO(null, "send over"));
    //    }

}
