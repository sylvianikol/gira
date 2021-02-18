package com.exam.gira.model.view;

import com.exam.gira.model.enums.ClassificaionName;
import com.exam.gira.model.enums.Progress;

import java.time.LocalDate;

public class TaskViewModel {

    private String name;
    private String userName;
    private ClassificaionName classificaion;
    private LocalDate dueDate;
    private Progress progress;

    public TaskViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ClassificaionName getClassificaion() {
        return classificaion;
    }

    public void setClassificaion(ClassificaionName classificaion) {
        this.classificaion = classificaion;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
