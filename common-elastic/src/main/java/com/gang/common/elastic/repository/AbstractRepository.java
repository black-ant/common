package com.gang.common.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.io.Serializable;

/**
 * @Classname AbstractRepository
 * @Description TODO
 * @Date 2020/2/6 14:17
 * @Created by zengzg
 */
public interface AbstractRepository<T, D extends Serializable> extends ElasticsearchRepository<T, D> {

    // TODO : 基于 Spring 提供的 Repository 实际上已经提供了多种查询方式
}
