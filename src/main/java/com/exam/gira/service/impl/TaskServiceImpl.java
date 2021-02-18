package com.exam.gira.service.impl;

import com.exam.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }
}
