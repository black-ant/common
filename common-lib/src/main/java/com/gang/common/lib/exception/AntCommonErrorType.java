package com.gang.common.lib.exception;

/**
 * @Classname AntCommonErrorType
 * @Description TODO
 * @Date 2019/12/7 20:00
 * @Created by zengzg
 */
public enum AntCommonErrorType {

    SERVER_ERROR("ERROR001", "Server Running Error");

    private String code;
    private String errorInfo;
    private String solution;
    private String remarks;

    AntCommonErrorType(String code, String errorInfo) {
        this.code = code;
        this.errorInfo = errorInfo;
        this.solution = "Please ";
        this.remarks = "";
    }

    AntCommonErrorType(String code, String errorInfo, String solution, String remarks) {
        this.code = code;
        this.errorInfo = errorInfo;
        this.solution = solution;
        this.remarks = remarks;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
