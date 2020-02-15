package com.gang.common.schedule.logic;

import com.alibaba.fastjson.JSONObject;
import com.gang.common.schedule.common.ITimeLogic;
import com.gang.common.schedule.dao.ScPlanRepository;
import com.gang.common.schedule.entity.ScPlanEntity;
import com.gang.common.schedule.logic.common.ScheduleThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname TimingLogic
 * @Description TODO
 * @Date 2020/2/8 21:45
 * @Created by zengzg
 */
@Component
public class TimingLogic implements ITimeLogic {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScPlanRepository repository;

    @Override
    public void start() {
        List<ScPlanEntity> list = repository.findAll();
        list.forEach(item -> {
            run(item);
        });

    }

    public Boolean run(ScPlanEntity scPlanEntity) {
        logger.info("------> run  :{}<-------", JSONObject.toJSONString(scPlanEntity));
        ScheduleThread thread = new ScheduleThread();
        thread.init("test");
        thread.start();

        return Boolean.TRUE;
    }
}
