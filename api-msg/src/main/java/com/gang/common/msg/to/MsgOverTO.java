package com.gang.common.msg.to;

import lombok.Data;

import java.util.Date;

/**
 * @Classname MsgOverTO
 * @Description TODO
 * @Date 2020/2/5 15:53
 * @Created by zengzg
 */
@Data
public class MsgOverTO {

    private String id;

    private String info;

    private Integer version;

    private Date operationDate;

    public MsgOverTO(String id, String info) {
        this.id = id;
        this.info = info;
        this.version = 0;
        this.operationDate = new Date();
    }
}
