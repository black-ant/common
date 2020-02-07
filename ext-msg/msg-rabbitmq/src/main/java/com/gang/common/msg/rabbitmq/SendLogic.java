package com.gang.common.msg.rabbitmq;

import com.gang.common.msg.config.MsgStrategy;
import com.gang.common.msg.rabbitmq.logic.ProduceService;
import com.gang.common.msgapi.to.MsgBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Classname SendLogic
 * @Description TODO
 * @Date 2020/2/5 15:30
 * @Created by zengzg
 */
@Component
public class SendLogic {


    @Autowired
    private ProduceService produceService;

    @Autowired
    private MsgStrategy msgStrategy;

    public void sendLogic() {
        MsgBody msgBody = new MsgBody();
        msgBody.setStatus(Boolean.TRUE);
        msgBody.setData("this is ok");

        produceService.sendMsg(msgStrategy.getStrategy(), msgBody);
    }
}
