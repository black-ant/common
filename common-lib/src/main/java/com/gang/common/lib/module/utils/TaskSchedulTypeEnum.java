package com.gang.common.lib.module.utils;

/**
 * @Classname TaskSchedulTypeEnum
 * @Description TODO
 * @Date 2020/2/16 21:14
 * @Created by zengzg
 */
public enum TaskSchedulTypeEnum {

    // Common
    YEAR("101", "YEAR"),
    MOUTH("102", "MOUTH"),
    WEEK("103", "WEEK"),
    DAY("104", "DAY"),
    HOUR("105", "HOUR"),
    MINUTE("106", "MINUTE"),
    SECONDS("107", "SECONDS"),

    // Type
    CODE_PREFIX_CONTINUOUS("301", "0/"),
    CODE_MIDLE_INTERVAL("302", "-"),
    CODE_INTERVAL("303", " "),
    CODE_REGULAR_FULL("304", "*"),

    // 间隔秒
    INTERVAL("20"),

    INTERVAL_SECONDS("201"),

    INTERVAL_MINUTE("202"),

    INTERVAL_HOUR("203"),

    INTERVAL_DAY("204"),

    INTERVAL_WEWK("205"),

    DEFAULT_ZERO("501", "0"),
    DEFAULT_ANY("502", "*"),

    DEFAULT_WEEK("503", "?");

    private String type;
    private String code;

    TaskSchedulTypeEnum(String type) {
        this.type = type;
    }

    TaskSchedulTypeEnum(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
}
