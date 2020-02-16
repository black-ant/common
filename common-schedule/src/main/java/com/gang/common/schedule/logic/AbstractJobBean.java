package com.gang.common.schedule.logic;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Classname AbstractJobBean
 * @Description TODO
 * @Date 2020/2/16 17:34
 * @Created by zengzg
 */
public abstract class AbstractJobBean extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("------> this is in  CronQuartzJobBean<-------");
    }
}
