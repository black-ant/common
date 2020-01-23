package com.gang.ext.sdk.workwechat.to;

import com.gang.sdk.api.annotation.SyncTO;
import com.gang.sdk.api.to.SyncBaseBean;
import lombok.Data;

/**
 * @Classname OrgTO
 * @Description TODO
 * @Date 2019/12/25 21:15
 * @Created by zengzg
 */
@Data
@SyncTO(type = "ORG")
public class OrgTO extends SyncBaseBean {

    private String name;

    private String name_en;

    private Integer parentid;

    private Integer order;

    private String id;
}
