package com.gang.common.msgapi.to;

import lombok.Data;

/**
 * @Classname MsgQueueInfo
 * @Description TODO
 * @Date 2020/2/5 16:22
 * @Created by zengzg
 */
@Data
public class MsgQueueInfo {

    private String queueId;

    private String routing;

    private String exchange;
}
