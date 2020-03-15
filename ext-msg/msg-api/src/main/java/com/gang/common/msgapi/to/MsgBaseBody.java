package com.gang.common.msgapi.to;

import lombok.Data;

/**
 * @Classname MsgBody
 * @Description TODO
 * @Date 2020/2/5 17:06
 * @Created by zengzg
 */
@Data
public class MsgBaseBody implements IMsgContent {

    private String data;

    private Boolean status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
