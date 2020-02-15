package com.gang.common.schedule.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Classname ScLogEntity
 * @Description TODO
 * @Date 2020/2/14 20:55
 * @Created by zengzg
 */
@Entity
@Table(name = "sc_log", schema = "schedule", catalog = "")
public class ScLogEntity {
    private String id;
    private Timestamp scTime;
    private String scStatus;
    private String scInfo;

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
    @Column(name = "sc_status")
    public String getScStatus() {
        return scStatus;
    }

    public void setScStatus(String scStatus) {
        this.scStatus = scStatus;
    }

    @Basic
    @Column(name = "sc_info")
    public String getScInfo() {
        return scInfo;
    }

    public void setScInfo(String scInfo) {
        this.scInfo = scInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScLogEntity that = (ScLogEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(scTime, that.scTime) &&
                Objects.equals(scStatus, that.scStatus) &&
                Objects.equals(scInfo, that.scInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scTime, scStatus, scInfo);
    }
}
