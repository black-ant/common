package com.gang.common.lib.type;

/**
 * @Classname CommonCode
 * @Description TODO
 * @Date 2020/3/1 19:07
 * @Created by zengzg
 */
public enum CommonCode {

    SUCCESS("200");

    private String code;

    CommonCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
