package com.gang.common.msgapi.type;

/**
 * @Classname MsgType
 * @Description TODO
 * @Date 2020/3/1 13:14
 * @Created by zengzg
 */
public enum MsgType {

    RABITMQ("com.gang.common.msg.rabbitmq.logic.RabbitProduceService"),
    EMAIL("com.gang.common.msg.email.logic.EmailSendService"),
    KAFKA(""),
    ALIYUN("com.gang.common.sms.AliyunSmsLogic"),
    ACTIVE("");

    private String loadClass;

    MsgType(String loadClass) {
        this.loadClass = loadClass;
    }

    public String getLoadClass() {
        return loadClass;
    }

    public void setLoadClass(String loadClass) {
        this.loadClass = loadClass;
    }
}
