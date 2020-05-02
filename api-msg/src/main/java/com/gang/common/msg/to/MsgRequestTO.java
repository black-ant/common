package com.gang.common.msg.to;

import com.gang.common.msg.IMsgSetting;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @Classname MsgRequestTO
 * @Description TODO
 * @Date 2020/5/2 20:39
 * @Created by zengzg
 */
public class MsgRequestTO<T extends IMsgContent, S extends IMsgSetting> {

    private T contentTO;

    private String msgSetting;

    private S settingTO;

    public static MsgRequestTO getInstance(IMsgContent msgContent) {
        MsgRequestTO requestTO = new MsgRequestTO();
        requestTO.setContentTO(msgContent);
        return requestTO;
    }

    public T getContentTO() {
        return contentTO;
    }

    public void setContentTO(T contentTO) {
        this.contentTO = contentTO;
    }

    public String getMsgSetting() {
        return msgSetting;
    }

    public void setMsgSetting(String msgSetting) {
        this.msgSetting = msgSetting;
    }

    public S getSettingTO() {
        return settingTO;
    }

    public void setSettingTO(S settingTO) {
        this.settingTO = settingTO;
    }
}
