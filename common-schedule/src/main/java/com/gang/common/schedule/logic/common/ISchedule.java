package com.gang.common.schedule.logic.common;

/**
 * @Classname ISchedule
 * @Description TODO
 * @Date 2020/2/15 19:24
 * @Created by zengzg
 */
public interface ISchedule<T> {

    Boolean init(T t);

    Boolean registry(String cron);
}
