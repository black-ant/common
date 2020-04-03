package com.gang.common.elastic.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

/**
 * @Classname ElasticConnect
 * @Description TODO
 * @Date 2020/4/1 21:42
 * @Created by zengzg
 */
@Component
public class ElasticConnect {

    @Autowired
    private ElasticsearchTemplate template;


}
