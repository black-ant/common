package com.gang.common.schedule.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Classname ScPlanEntity
 * @Description TODO
 * @Date 2020/2/14 20:55
 * @Created by zengzg
 */
@Entity
@Table(name = "sc_plan", schema = "schedule", catalog = "")
public class ScPlanEntity {
    private String id;
    private Timestamp scTime;
    private Timestamp createTime;
    private String scFrequency;
    private String scStrategy;
    private String scInfo;
    private String scType;
    private String scStatus;

    @Basic
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sc_time")
    public Timestamp getScTime() {
        return scTime;
    }

    public void setScTime(Timestamp scTime) {
        this.scTime = scTime;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "sc_frequency")
    public String getScFrequency() {
        return scFrequency;
    }

    public void setScFrequency(String scFrequency) {
        this.scFrequency = scFrequency;
    }

    @Basic
    @Column(name = "sc_strategy")
    public String getScStrategy() {
        return scStrategy;
    }

    public void setScStrategy(String scStrategy) {
        this.scStrategy = scStrategy;
    }

    @Basic
    @Column(name = "sc_info")
    public String getScInfo() {
        return scInfo;
    }

    public void setScInfo(String scInfo) {
        this.scInfo = scInfo;
    }

    @Basic
    @Column(name = "sc_type")
    public String getScType() {
        return scType;
    }

    public void setScType(String scType) {
        this.scType = scType;
    }

    @Basic
    @Column(name = "sc_status")
    public String getScStatus() {
        return scStatus;
    }

    public void setScStatus(String scStatus) {
        this.scStatus = scStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScPlanEntity that = (ScPlanEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(scTime, that.scTime) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(scFrequency, that.scFrequency) &&
                Objects.equals(scStrategy, that.scStrategy) &&
                Objects.equals(scInfo, that.scInfo) &&
                Objects.equals(scType, that.scType) &&
                Objects.equals(scStatus, that.scStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scTime, createTime, scFrequency, scStrategy, scInfo, scType, scStatus);
    }
}
