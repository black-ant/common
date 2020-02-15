package com.gang.common.schedule.dao;

import com.gang.common.schedule.entity.ScPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname ScPlanRepository
 * @Description TODO
 * @Date 2020/2/14 21:13
 * @Created by zengzg
 */
@Repository
public interface ScPlanRepository extends JpaRepository<ScPlanEntity, String> {
}
