package com.gang.common.flowable.config;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;

/**
 * @Classname FlowableConfig
 * @Description TODO
 * @Date 2020/4/28 23:01
 * @Created by zengzg
 */
@Configuration
@Component
public class FlowableConfig {

    @Autowired
    private ProcessEngineConfig config;


    @Bean
    public ProcessEngine getProcessEngine() {
        // 流程引擎配置
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl(config.getUrl())
                .setJdbcUsername(config.getUsername())
                .setJdbcPassword(config.getPassword())
                .setJdbcDriver(config.getDriverClassName())
                // 初始化基础表，不需要的可以改为 DB_SCHEMA_UPDATE_FALSE
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 初始化流程引擎对象
        return cfg.buildProcessEngine();
    }
}
