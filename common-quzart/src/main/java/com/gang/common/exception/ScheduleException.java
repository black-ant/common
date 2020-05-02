package com.gang.common.exception;

import com.gang.common.lib.exception.CommonException;

/**
 * @Classname ScheduleException
 * @Description TODO
 * @Date 2020/4/28 21:25
 * @Created by zengzg
 */
public class ScheduleException extends CommonException {

    public ScheduleException() {
    }

    public ScheduleException(String message) {
        super(message);
    }

    public ScheduleException(String message, String code) {
        super(message, code);
    }
}
