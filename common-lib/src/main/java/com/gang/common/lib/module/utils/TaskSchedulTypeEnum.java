package com.gang.common.lib.module.utils;

/**
 * @Classname TaskSchedulTypeEnum
 * @Description TODO
 * @Date 2020/2/16 21:14
 * @Created by zengzg
 */
public enum TaskSchedulTypeEnum {

    // Common
    MOUTH(0), WEEK(1), DAY(2), HOUR(3),

    // 间隔秒
    INTERVAL_SECONDS(501),

    INTERVAL_MINUTE(502),

    // 间隔小时
    INTERVAL_HOUR(503),

    // 间隔天
    INTERVAL_DAY(504),

    INTERVAL_WEWK(504);

    private Integer type;

    TaskSchedulTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
