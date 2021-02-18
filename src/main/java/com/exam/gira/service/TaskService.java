package com.exam.gira.service;

import com.exam.gira.model.service.TaskServiceModel;

public interface TaskService {

    boolean add(TaskServiceModel taskServiceModel, Long user);
}
