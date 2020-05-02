package com.gang.common.entity;


import com.gang.common.msg.IMsgSetting;
import com.gang.common.msg.type.MsgType;

/**
 * @Classname RYSmsSetting
 * @Description TODO
 * @Date 2020/5/2 19:38
 * @Created by zengzg
 */
public class RYSmsSetting implements IMsgSetting {

    private String serverIP;

    private String serverPort;

    private String sid;

    private String authToken;

    private String appId;

    private String templateKey;

    private int time;

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTemplateKey() {
        return templateKey;
    }

    public void setTemplateKey(String templateKey) {
        this.templateKey = templateKey;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.RYSMS;
    }
}
