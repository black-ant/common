package com.gang.common.lib.exception;

/**
 * @Classname ExpError
 * @Description TODO
 * @Date 2019/12/7 20:00
 * @Created by zengzg
 */
public enum ExpError {

    SERVER_ERROR("ERROR001", "Server Running Error");

    private String code;
    private String errorInfo;
    private String solution;
    private String remarks;

    ExpError(String code, String errorInfo) {
        this.code = code;
        this.errorInfo = errorInfo;
        this.solution = "Please ";
        this.remarks = "";
    }

    ExpError(String code, String errorInfo, String solution, String remarks) {
        this.code = code;
        this.errorInfo = errorInfo;
        this.solution = solution;
        this.remarks = remarks;
    }
}
