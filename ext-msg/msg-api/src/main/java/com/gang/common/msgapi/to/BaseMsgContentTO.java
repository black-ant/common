package com.gang.common.msgapi.to;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Classname MsgBaseContent
 * @Description TODO
 * @Date 2020/2/22 21:38
 * @Created by zengzg
 */
@Component
@Data
public class BaseMsgContentTO {

    private String title;

    private String content;

    private String receiverList;
}
