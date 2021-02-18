package com.exam.gira.service.impl;

import com.exam.gira.model.entity.User;
import com.exam.gira.model.service.UserServiceModel;
import com.exam.gira.repository.UserRepository;
import com.exam.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        try {
            this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String username, String password) {
        return this.userRepository.findByEmailAndPassword(username, password)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
