package com.exam.gira.service;

import com.exam.gira.model.service.TaskServiceModel;

import java.util.List;

public interface TaskService {

    boolean add(TaskServiceModel taskServiceModel, Long user);

    List<TaskServiceModel> getAllTasks();

    void updateTask(Long id);
}
