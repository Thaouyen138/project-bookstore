package com.example.demo.repository;

import com.example.demo.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<AppUser, String> {
    @Query(value = "SELECT user_name, user_password FROM user WHERE user_name = :name", nativeQuery = true)
    Optional<AppUser> findByUsername(String name);
}
