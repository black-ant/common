package com.gang.common.lib.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname CommonException
 * @Description TODO
 * @Date 2020/2/17 20:05
 * @Created by zengzg
 */
public class CommonException extends RuntimeException {

    private static final String ERROR_KEY = "ERROR_KEY";
    private static final String ERROR_VALUE = "ERROR_VALUE";

    private String code;
    private Map<String, String> var;
    private String message;


    public CommonException() {
    }

    public CommonException(String message) {
        super(message);
        this.message = message;
    }

    public CommonException(String message, String code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public static CommonException build(String message) {
        return new CommonException(message);
    }

    public static CommonException build(String message, String code) {
        return new CommonException(message, code);
    }

    public static CommonException build(String message, String code, String key, String value) {
        CommonException commonException = new CommonException(message, code);
        Map<String, String> var = new HashMap<>();
        var.put(ERROR_KEY, key);
        var.put(ERROR_VALUE, value);
        return commonException;
    }

    public CommonException addVar(String key, String value) {
        if (var == null) {
            var = new HashMap<>();
        }
        var.put(key, value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getVar() {
        return var;
    }

    public void setVar(Map<String, String> var) {
        this.var = var;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
