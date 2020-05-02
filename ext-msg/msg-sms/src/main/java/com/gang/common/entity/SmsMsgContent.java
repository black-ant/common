package com.gang.common.entity;

import com.alibaba.fastjson.JSONObject;
import com.gang.common.msg.to.BaseMsgContentTO;

/**
 * @Classname MsgContent
 * @Description TODO
 * @Date 2020/3/14 16:27
 * @Created by zengzg
 */
public class SmsMsgContent extends BaseMsgContentTO {

    private JSONObject jsonObject;

    private String templateCode;

    public SmsMsgContent buidlAttr(String key, String value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        this.setJsonObject(jsonObject);
        return this;
    }

    public SmsMsgContent addAttr(String key, String value) {
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
