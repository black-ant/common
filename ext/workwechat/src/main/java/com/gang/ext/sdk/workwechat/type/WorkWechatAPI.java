package com.gang.ext.sdk.workwechat.type;

/**
 * @Classname WorkWechatAPI
 * @Description TODO
 * @Date 2019/12/25 21:29
 * @Created by zengzg
 */
public enum WorkWechatAPI {

    SUITE_ACCESS_TOKEN_CODE("SUITE_ACCESS_TOKEN"),
    TOKEN_CODE("ACCESS_TOKEN"),
    TOKEN_ID("ID"),

    API_TOKEN("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=${appId}&corpsecret=${appSecret}"),
    API_ORG_CREATE("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN"),
    API_ORG_UPDATE("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN"),
    API_ORG_DELETE("https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID"),
    API_ORG_SEARCH("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID");

    private String restAPI;

    WorkWechatAPI(String restAPI) {
        this.restAPI = restAPI;
    }

    public String getRestAPI() {
        return restAPI;
    }
}
