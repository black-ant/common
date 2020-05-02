package com.gang.common.msg.email.to;

import com.gang.common.msg.IMsgSetting;
import com.gang.common.msg.type.MsgType;
import lombok.Data;

/**
 * @Classname EmailSendSetting
 * @Description TODO
 * @Date 2020/2/22 21:11
 * @Created by zengzg
 */
@Data
public class EmailSendSetting implements IMsgSetting {

    private String account;

    private String password;

    private String protocol;

    private String host;

    private String port;

    private String auth;

    private boolean enable;

    private int time;

    @Override
    public MsgType getMsgType() {
        return MsgType.EMAIL;
    }
}

