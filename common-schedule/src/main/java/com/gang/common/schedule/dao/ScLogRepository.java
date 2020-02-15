package com.gang.common.schedule.dao;

import com.gang.common.schedule.entity.ScPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname ScLogRepository
 * @Description TODO
 * @Date 2020/2/14 21:13
 * @Created by zengzg
 */
@Repository
public interface ScLogRepository extends JpaRepository<ScPlanEntity, String> {
}
