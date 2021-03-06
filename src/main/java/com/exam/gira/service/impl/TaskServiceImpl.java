package com.exam.gira.service.impl;

import com.exam.gira.model.entity.Task;
import com.exam.gira.model.enums.Progress;
import com.exam.gira.model.service.TaskServiceModel;
import com.exam.gira.repository.TaskRepository;
import com.exam.gira.service.ClassificationService;
import com.exam.gira.service.TaskService;
import com.exam.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ClassificationService classificationService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ClassificationService classificationService, UserService userService, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.classificationService = classificationService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean add(TaskServiceModel taskServiceModel, Long userId) {
        Task task = this.modelMapper.map(taskServiceModel, Task.class);
        task.setClassification(this.classificationService.findByName(taskServiceModel.getClassification()));
        task.setUser(this.userService.getById(userId));
        task.setProgress(Progress.OPEN);

        try {
            taskRepository.save(task);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<TaskServiceModel> getAllTasks() {

        return this.taskRepository.findAll().stream()
                .map(t -> {
                    TaskServiceModel taskServiceModel = this.modelMapper.map(t, TaskServiceModel.class);
                    taskServiceModel.setClassification(t.getClassification().getName());
                    return taskServiceModel;
                })
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void updateTask(Long id) {
        Task task = this.taskRepository.findById(id).orElse(null);
        if (task != null) {
            String progress = task.getProgress().name();

            switch (progress) {
                case "OPEN":
                    task.setProgress(Progress.IN_PROGRESS);
                    break;
                case "IN_PROGRESS":
                    task.setProgress(Progress.COMPLETED);
                    break;
                case "COMPLETED":
                    this.taskRepository.delete(task);
                    return;
            }

            this.taskRepository.save(task);
        }


    }
}
