package com.gang.common.lib.exception;

import java.util.HashMap;

/**
 * @Classname CommonException
 * @Description TODO
 * @Date 2020/2/17 20:05
 * @Created by zengzg
 */
public class CommonException extends RuntimeException {

    private String code;
    private HashMap<String, String> var;
    private String exceptionInfo;


    public CommonException() {
    }

    public CommonException(String s) {
        super(s);
        this.exceptionInfo = s;
    }

    public CommonException(String message, String code) {
        super(message);
        this.code = code;
        this.exceptionInfo = message;
    }
}
