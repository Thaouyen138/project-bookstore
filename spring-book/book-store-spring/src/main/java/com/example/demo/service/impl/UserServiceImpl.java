package com.example.demo.service.impl;

import com.example.demo.model.user.AppUser;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<AppUser> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
