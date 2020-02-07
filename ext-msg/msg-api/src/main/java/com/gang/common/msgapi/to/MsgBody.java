package com.gang.common.msgapi.to;

import lombok.Data;

/**
 * @Classname MsgBody
 * @Description TODO
 * @Date 2020/2/5 17:06
 * @Created by zengzg
 */
@Data
public class MsgBody<T> {

    private T data;

    private Boolean status;
}
