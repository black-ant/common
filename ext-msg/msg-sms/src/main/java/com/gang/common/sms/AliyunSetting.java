package com.gang.common.sms;

import com.gang.common.lib.annotation.GFiled;
import com.gang.common.msgapi.IMsgSetting;
import com.gang.common.msgapi.type.MsgType;

/**
 * @Classname AliyunSetting
 * @Description TODO
 * @Date 2020/3/14 16:28
 * @Created by zengzg
 */
public class AliyunSetting implements IMsgSetting {

    @GFiled(alias = "RegionId")
    private String regionId;

    @GFiled(alias = "PhoneNumbers")
    private String phoneNumbers;

    @GFiled(alias = "accessToken")
    private String accessToken;

    @GFiled(alias = "accessSecret")
    private String accessSecret;

    @GFiled(alias = "TemplateCode")
    private String templateCode;

    @GFiled(alias = "SignName")
    private String signName;

    private String domain = "dysmsapi.aliyuncs.com";

    private String action = "SendSms";

    private String version = "2017-05-25";


    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.ALIYUN;
    }
}
