package com.gang.common.msg.to;

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
public class BaseMsgContentTO implements IMsgContent {

    private String title;

    private String content;

    // 批量发送逗号分隔
    private String receiverList;

}
