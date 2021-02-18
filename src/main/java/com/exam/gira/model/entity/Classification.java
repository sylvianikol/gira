package com.exam.gira.model.entity;

import com.exam.gira.model.enums.ClassificaionName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity {

    private ClassificaionName name;
    private String description;

    public Classification() {
    }

    @Enumerated(value = EnumType.STRING)
    public ClassificaionName getName() {
        return name;
    }

    public void setName(ClassificaionName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
