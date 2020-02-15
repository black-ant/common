package com.gang.common.schedule.dao;

import com.gang.common.schedule.entity.ScTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname ScTypeRepository
 * @Description TODO
 * @Date 2020/2/14 20:41
 * @Created by zengzg
 */
@Repository
public interface ScTypeRepository extends JpaRepository<ScTypeEntity, String> {
}
