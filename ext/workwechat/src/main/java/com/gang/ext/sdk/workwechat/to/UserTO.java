package com.gang.ext.sdk.workwechat.to;

import com.gang.sdk.api.annotation.SyncField;
import com.gang.sdk.api.annotation.SyncTO;
import com.gang.sdk.api.to.SyncBaseBean;
import lombok.Data;

/**
 * @Classname UserTO
 * @Description TODO
 * @Date 2019/12/26 22:07
 * @Created by zengzg
 */
@Data
@SyncTO(type = "USER", app = "WORK_WECHAT", name = "企业微信")
public class UserTO extends SyncBaseBean {

    private String userid;

    private String name;

    @SyncField(defaultValue = "wechatalias")
    private String alias;

    private String mobile;

    private String[] department;

    private String[] order;

    @SyncField(defaultValue = "gang")
    private String aaa;

    private String position;

    private String gender;

    private String email;

    private String[] is_leader_in_dept;

    private Integer enable;

    private String avatar_mediaid;

    private String telephone;

    private String address;

}
