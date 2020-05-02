package com.gang.ext.sdk.workwechat.to;

import com.gang.sdk.api.annotation.SyncConfig;
import lombok.Data;

/**
 * @Classname WorkWechatConfig
 * @Description TODO
 * @Date 2019/12/26 22:24
 * @Created by zengzg
 */
@Data
@SyncConfig(type = "CFG", app = "WORK_WECHAT", name = "企业微信配置")
public class WorkWechatConfig {

    private String appId;

    private String appSecret;

}
