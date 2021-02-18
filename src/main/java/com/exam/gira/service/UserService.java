package com.exam.gira.service;

import com.exam.gira.model.service.UserServiceModel;

public interface UserService {

    boolean register(UserServiceModel userServiceModel);

    public UserServiceModel findByEmailAndPassword(String username, String password);
}
