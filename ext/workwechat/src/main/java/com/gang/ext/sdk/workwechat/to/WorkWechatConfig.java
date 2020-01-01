package com.gang.ext.sdk.workwechat.to;

import com.gang.sdk.api.to.SyncConfig;
import lombok.Data;

/**
 * @Classname WorkWechatConfig
 * @Description TODO
 * @Date 2019/12/26 22:24
 * @Created by zengzg
 */
@Data
public class WorkWechatConfig extends SyncConfig {

    private String accessToken;

}
