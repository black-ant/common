package com.gang.common.msgapi.error;

import com.gang.common.lib.exception.CommonException;

/**
 * @Classname MsgException
 * @Description TODO
 * @Date 2020/3/1 18:59
 * @Created by zengzg
 */
public class MsgException extends CommonException {

    public MsgException(String s) {
        super(s);
    }

    public MsgException(String msg, String code) {
        super(msg, code);
    }
}
