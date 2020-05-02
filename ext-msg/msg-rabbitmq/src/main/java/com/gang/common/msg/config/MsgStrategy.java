package com.gang.common.msg.config;

import com.gang.common.msg.to.MsgQueueInfo;
import org.springframework.stereotype.Component;

/**
 * @Classname MsgStrategy
 * @Description TODO
 * @Date 2020/2/5 15:41
 * @Created by zengzg
 */
@Component
public class MsgStrategy {


    public MsgQueueInfo getStrategy() {
        MsgQueueInfo msgQueueInfo = new MsgQueueInfo();
        msgQueueInfo.setQueueId("1");
        msgQueueInfo.setExchange("1");
        msgQueueInfo.setRouting("1");
        return msgQueueInfo;
    }


}
