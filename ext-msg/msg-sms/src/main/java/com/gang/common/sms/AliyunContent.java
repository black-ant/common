package com.gang.common.sms;

import com.alibaba.fastjson.JSONObject;
import com.gang.common.msgapi.to.BaseMsgContentTO;
import com.gang.common.msgapi.to.IMsgContent;
import com.gang.common.msgapi.to.MsgBaseBody;

/**
 * @Classname AliyunContent
 * @Description TODO
 * @Date 2020/3/14 16:27
 * @Created by zengzg
 */
public class AliyunContent extends BaseMsgContentTO {

    private JSONObject jsonObject;

    private String templateCode;

    public AliyunContent buidlAttr(String key, String value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        this.setJsonObject(jsonObject);
        return this;
    }

    public AliyunContent addAttr(String key, String value) {
        JSONObject jsonObject = this.getJsonObject() == null ? new JSONObject() : this.getJsonObject();
        jsonObject.put(key, value);
        this.setJsonObject(jsonObject);
        return this;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }
}
