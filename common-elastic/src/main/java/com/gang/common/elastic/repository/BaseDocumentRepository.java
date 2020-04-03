package com.gang.common.elastic.repository;

import com.gang.common.elastic.model.BaseExampleDocument;
import org.springframework.stereotype.Repository;

/**
 * @Classname BaseDocumentRepository
 * @Description TODO
 * @Date 2020/4/1 21:47
 * @Created by zengzg
 */
@Repository
public interface BaseDocumentRepository extends AbstractRepository<BaseExampleDocument, String> {
}
