package com.gang.common.schedule.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Classname ScTypeEntity
 * @Description TODO
 * @Date 2020/2/14 20:41
 * @Created by zengzg
 */
@Entity
@Table(name = "sc_type", schema = "schedule", catalog = "")
public class ScTypeEntity {
    private String id;
    private String typeName;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScTypeEntity that = (ScTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName);
    }
}
