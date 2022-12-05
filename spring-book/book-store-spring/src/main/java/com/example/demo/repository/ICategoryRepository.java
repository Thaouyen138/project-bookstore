package com.example.demo.repository;

import com.example.demo.model.category.Category;
import com.example.demo.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT * FROM category WHERE is_deleted = 0", nativeQuery = true)
    List<Category> findAllCategory();
}
