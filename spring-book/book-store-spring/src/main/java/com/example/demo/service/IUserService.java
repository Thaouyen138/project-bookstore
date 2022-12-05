package com.example.demo.service;

import com.example.demo.model.user.AppUser;

import java.util.Optional;

public interface IUserService {
    Optional<AppUser> findByUsername(String name);
}
