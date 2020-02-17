package com.gang.common.lib.module.utils;

import com.gang.common.lib.utils.CommonStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname TaskScheduleModel
 * @Description TODO
 * @Date 2020/2/16 21:13
 * @Created by zengzg
 */
public class TaskScheduleModel {

    private TaskSchedulTypeEnum taskSchedulTypeEnum = TaskSchedulTypeEnum.DEFAULT_ZERO;

    /**
     * 定时或间隔
     * 所选作业类型:
     * 1  -> 每天
     * 2  -> 每月
     * 3  -> 每周
     * 4  -> 间隔
     */
    private HashMap<String, String> timeNum = new HashMap<>();

    /**
     * 范围
     */
    private HashMap<String, String> timeIntervalNum = new HashMap<>();

    public HashMap<String, String> getTimeNum() {
        return timeNum;
    }

    public HashMap<String, String> getTimeIntervalNum() {
        return timeIntervalNum;
    }

    public TaskScheduleModel addTimeNum(TaskSchedulTypeEnum taskSchedulTypeEnum, String numTime) {
        timeNum.put(taskSchedulTypeEnum.getCode(), numTime);
        this.taskSchedulTypeEnum = TaskSchedulTypeEnum.DEFAULT_ANY;
        return this;
    }

    /**
     * 设置时间间隔
     *
     * @param taskSchedulTypeEnum
     * @param numTime
     * @return
     */
    public TaskScheduleModel addTimeInterval(TaskSchedulTypeEnum taskSchedulTypeEnum, String numTime) {
        timeNum.put(taskSchedulTypeEnum.getCode(), "0/" + numTime);
        this.taskSchedulTypeEnum = TaskSchedulTypeEnum.DEFAULT_ANY;
        return this;
    }

    /**
     * 设置时间范围
     *
     * @param taskSchedulTypeEnum
     * @param start
     * @param end
     */
    public TaskScheduleModel addTimeRange(TaskSchedulTypeEnum taskSchedulTypeEnum, String start, String end) {
        if ("WEEK".equals(taskSchedulTypeEnum.getCode())) {
            timeNum.put(taskSchedulTypeEnum.getCode(), start + "/" + end);
        } else {
            timeNum.put(taskSchedulTypeEnum.getCode(), start + "-" + end);
        }
        return this;
    }

    /**
     * 设置多个时间
     *
     * @param taskSchedulTypeEnum
     * @param times
     */
    public TaskScheduleModel addTimeManyNum(TaskSchedulTypeEnum taskSchedulTypeEnum, List<String> times) {
        timeNum.put(taskSchedulTypeEnum.getCode(), StringUtils.join(times.toArray(), ","));
        return this;
    }

    public TaskSchedulTypeEnum getTaskSchedulTypeEnum() {
        return taskSchedulTypeEnum;
    }
}

