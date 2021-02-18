package com.exam.gira.model.entity;

import com.exam.gira.model.enums.ClassificationName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity {

    private ClassificationName name;
    private String description;

    public Classification() {
    }

    @Enumerated(value = EnumType.STRING)
    public ClassificationName getName() {
        return name;
    }

    public void setName(ClassificationName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
