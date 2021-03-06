package com.exam.gira.web;

import com.exam.gira.model.service.TaskServiceModel;
import com.exam.gira.model.view.TaskViewModel;
import com.exam.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession,
                        Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        List<TaskViewModel> tasks = this.taskService.getAllTasks().stream()
                .map(t -> this.modelMapper.map(t, TaskViewModel.class))
                .collect(Collectors.toUnmodifiableList());

        model.addAttribute("tasks", tasks);

        return "home";
    }
}
