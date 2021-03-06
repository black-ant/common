package com.gang.common.lib.utils;

import cn.hutool.cron.pattern.matcher.DayOfMonthValueMatcher;
import cn.hutool.cron.pattern.matcher.ValueMatcher;
import com.gang.common.lib.module.utils.TaskSchedulTypeEnum;
import com.gang.common.lib.module.utils.TaskScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname CronUtils
 * @Description TODO
 * @Date 2020/2/16 20:17
 * @Created by zengzg
 */
public class CronUtils {

    private static Logger logger = LoggerFactory.getLogger(CronUtils.class);

//    public static void main(String[] args) {
    //        TaskScheduleModel taskScheduleModel = new TaskScheduleModel();
    //        taskScheduleModel.addTimeNum(TaskSchedulTypeEnum.DAY, "3").addTimeNum(TaskSchedulTypeEnum.MINUTE, "5")
    //        .addTimeNum(TaskSchedulTypeEnum.SECONDS, "5");
    //        logger.info("------> {}  <-------", createCronExpression(taskScheduleModel));
    //    }

    /**
     * 是否匹配日（指定月份的第几天）
     *
     * @param matcher    {@link ValueMatcher}
     * @param dayOfMonth 日
     * @param month      月
     * @param isLeapYear 是否闰年
     * @return 是否匹配
     */
    private static boolean isMatchDayOfMonth(ValueMatcher matcher, int dayOfMonth, int month, boolean isLeapYear) {
        return ((matcher instanceof DayOfMonthValueMatcher) //
                ? ((DayOfMonthValueMatcher) matcher).match(dayOfMonth, month, isLeapYear) //
                : matcher.match(dayOfMonth));
    }

    /**
     * 是否匹配指定的日期时间位置
     *
     * @param matchers 匹配器列表
     * @param index    位置
     * @param value    被匹配的值
     * @return 是否匹配
     * @since 4.0.2
     */
    private static boolean isMatch(List<ValueMatcher> matchers, int index, int value) {
        return (matchers.size() <= index) || matchers.get(index).match(value);
    }


    public static String createCronExpression(TaskScheduleModel taskScheduleModel) {
        StringBuffer cronExp = new StringBuffer("");
        List<String> getList = Arrays.asList(new String[]{"SECONDS", "MINUTE", "HOUR", "DAY", "MOUTH", "WEEK"});
        getList.forEach(item -> {
            editCronExpression(item, taskScheduleModel, cronExp);
        });
        return cronExp.toString();
    }

    public static void editCronExpression(String type, TaskScheduleModel taskScheduleModel, StringBuffer cronExp) {
        String str;
        if (null != taskScheduleModel.getTimeNum().get(type)) {
            str = taskScheduleModel.getTimeNum().get(type);
        } else if (null != taskScheduleModel.getTimeIntervalNum().get(type)) {
            str = taskScheduleModel.getTimeIntervalNum().get(type);
        } else {
            if (type.equals("WEEK")) {
                str = TaskSchedulTypeEnum.DEFAULT_WEEK.getCode();
            } else {
                str = taskScheduleModel.getTaskSchedulTypeEnum().getCode();
            }

        }
        cronExp.append(str);

        if (!type.equals("WEEK")) {
            cronExp.append(" ");
        }

    }

    /**
     * 方法摘要：构建Cron表达式
     *
     * @param taskScheduleModel
     * @return String
     */
    //    public static String createCronExpression1(TaskScheduleModel taskScheduleModel) {
    //        StringBuffer cronExp = new StringBuffer("");
    ////
    ////        if (null == taskScheduleModel.getJobType()) {
    ////            System.out.println("执行周期未配置");//执行周期未配置
    ////        }
    ////
    ////        if (null != taskScheduleModel.getSecond()
    ////                && null != taskScheduleModel.getMinute()
    ////                && null != taskScheduleModel.getHour()) {
    ////            //秒
    ////            cronExp.append(taskScheduleModel.getSecond()).append(" ");
    ////            //分
    ////            cronExp.append(taskScheduleModel.getMinute()).append(" ");
    ////            //小时
    ////            cronExp.append(taskScheduleModel.getHour()).append(" ");
    ////
    ////            //每天
    ////            if (taskScheduleModel.getJobType().intValue() == 1) {
    ////                cronExp.append("* ");//日
    ////                cronExp.append("* ");//月
    ////                cronExp.append("?");//周
    ////            }
    ////
    ////            //按每周
    ////            else if (taskScheduleModel.getJobType().intValue() == 3) {
    ////                //一个月中第几天
    ////                cronExp.append("? ");
    ////                //月份
    ////                cronExp.append("* ");
    ////                //周
    ////                Integer[] weeks = taskScheduleModel.getDayOfWeeks();
    ////                for (int i = 0; i < weeks.length; i++) {
    ////                    if (i == 0) {
    ////                        cronExp.append(weeks[i]);
    ////                    } else {
    ////                        cronExp.append(",").append(weeks[i]);
    ////                    }
    ////                }
    ////
    ////            }
    ////            //按每月
    ////            else if (taskScheduleModel.getJobType().intValue() == 2) {
    ////                //一个月中的哪几天
    ////                Integer[] days = taskScheduleModel.getDayOfMonths();
    ////                for (int i = 0; i < days.length; i++) {
    ////                    if (i == 0) {
    ////                        cronExp.append(days[i]);
    ////                    } else {
    ////                        cronExp.append(",").append(days[i]);
    ////                    }
    ////                }
    ////                //月份
    ////                cronExp.append(" * ");
    ////                //周
    ////                cronExp.append("?");
    ////            } else if (taskScheduleModel.getJobType().intValue() == 2) {
    ////                //一个月中的哪几天
    ////                Integer[] days = taskScheduleModel.getDayOfMonths();
    ////                for (int i = 0; i < days.length; i++) {
    ////                    if (i == 0) {
    ////                        cronExp.append(days[i]);
    ////                    } else {
    ////                        cronExp.append(",").append(days[i]);
    ////                    }
    ////                }
    ////                //月份
    ////                cronExp.append(" * ");
    ////                //周
    ////                cronExp.append("?");
    ////            }
    ////
    ////        } else {
    ////            System.out.println("时或分或秒参数未配置");//时或分或秒参数未配置
    ////        }
    ////        return cronExp.toString();
    //    }


    /**
     * 方法摘要：生成计划的详细描述
     *
     * @param taskScheduleModel
     * @return String
     */
    //    public static String createDescription(TaskScheduleModel taskScheduleModel) {
    //        StringBuffer description = new StringBuffer("");
    //        //计划执行开始时间
    //        //      Date startTime = taskScheduleModel.getScheduleStartTime();
    //
    //        if (null != taskScheduleModel.getSecond()
    //                && null != taskScheduleModel.getMinute()
    //                && null != taskScheduleModel.getHour()) {
    //            //按每天
    //            if (taskScheduleModel.getJobType().intValue() == 1) {
    //                description.append("每天");
    //                description.append(taskScheduleModel.getHour()).append("时");
    //                description.append(taskScheduleModel.getMinute()).append("分");
    //                description.append(taskScheduleModel.getSecond()).append("秒");
    //                description.append("执行");
    //            }
    //
    //            //按每周
    //            else if (taskScheduleModel.getJobType().intValue() == 3) {
    //                if (taskScheduleModel.getDayOfWeeks() != null && taskScheduleModel.getDayOfWeeks().length >
    //                0) {
    //                    String days = "";
    //                    for (int i : taskScheduleModel.getDayOfWeeks()) {
    //                        days += "周" + i;
    //                    }
    //                    description.append("每周的").append(days).append(" ");
    //                }
    //                if (null != taskScheduleModel.getSecond()
    //                        && null != taskScheduleModel.getMinute()
    //                        && null != taskScheduleModel.getHour()) {
    //                    description.append(",");
    //                    description.append(taskScheduleModel.getHour()).append("时");
    //                    description.append(taskScheduleModel.getMinute()).append("分");
    //                    description.append(taskScheduleModel.getSecond()).append("秒");
    //                }
    //                description.append("执行");
    //            }
    //
    //            //按每月
    //            else if (taskScheduleModel.getJobType().intValue() == 2) {
    //                //选择月份
    //                if (taskScheduleModel.getDayOfMonths() != null && taskScheduleModel.getDayOfMonths().length
    //                > 0) {
    //                    String days = "";
    //                    for (int i : taskScheduleModel.getDayOfMonths()) {
    //                        days += i + "号";
    //                    }
    //                    description.append("每月的").append(days).append(" ");
    //                }
    //                description.append(taskScheduleModel.getHour()).append("时");
    //                description.append(taskScheduleModel.getMinute()).append("分");
    //                description.append(taskScheduleModel.getSecond()).append("秒");
    //                description.append("执行");
    //            }
    //
    //        }
    //        return description.toString();
    //    }

    //    //参考例子
    //    public static void main(String[] args) {
    //        //执行时间：每天的12时12分12秒 start
    //        TaskScheduleModel taskScheduleModel = new TaskScheduleModel();
    //        taskScheduleModel.setJobType(1);//按每天
    //        Integer hour = 12; //时
    //        Integer minute = 12; //分
    //        Integer second = 12; //秒
    //        taskScheduleModel.setHour(hour);
    //        taskScheduleModel.setMinute(minute);
    //        taskScheduleModel.setSecond(second);
    //        String cropExp = createCronExpression(taskScheduleModel);
    //        System.out.println(cropExp + ":" + createDescription(taskScheduleModel));
    //        //执行时间：每天的12时12分12秒 end
    //
    //        taskScheduleModel.setJobType(3);//每周的哪几天执行
    //        Integer[] dayOfWeeks = new Integer[3];
    //        dayOfWeeks[0] = 1;
    //        dayOfWeeks[1] = 2;
    //        dayOfWeeks[2] = 3;
    //        taskScheduleModel.setDayOfWeeks(dayOfWeeks);
    //        cropExp = createCronExpression(taskScheduleModel);
    //        System.out.println(cropExp + ":" + createDescription(taskScheduleModel));
    //
    //        taskScheduleModel.setJobType(2);//每月的哪几天执行
    //        Integer[] dayOfMonths = new Integer[3];
    //        dayOfMonths[0] = 1;
    //        dayOfMonths[1] = 21;
    //        dayOfMonths[2] = 13;
    //        taskScheduleModel.setDayOfMonths(dayOfMonths);
    //        cropExp = createCronExpression(taskScheduleModel);
    //        System.out.println(cropExp + ":" + createDescription(taskScheduleModel));
    //
    //    }


}

