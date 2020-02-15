package com.gang.common.schedule.logic.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname ScheduleThread
 * @Description TODO
 * @Date 2020/2/15 19:30
 * @Created by zengzg
 */
public class ScheduleThread extends Thread implements ISchedule<String> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Boolean init(String info) {
        logger.info("------> this is info :{} <-------", info);
        return null;
    }

    @Override
    public void run() {
        logger.info("------> this run run <-------");
    }


}
