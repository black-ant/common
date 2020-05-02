package com.gang.common.msg.config;

import com.gang.common.msg.IMsgSetting;
import com.gang.common.msg.to.BaseMsgConfigTO;
import com.gang.common.msg.type.MsgType;

/**
 * @Classname IBaseMsgConfig
 * @Description TODO
 * @Date 2020/2/29 17:12
 * @Created by zengzg
 */
public abstract class BaseMsgConfig<T> implements IMsgSetting {

    protected MsgType msgType;

    protected String routing;

    protected String exchange;

    public abstract void setMsgConfig(BaseMsgConfigTO baseMsgConfigTO);

    public abstract T getMsgConfig();

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
