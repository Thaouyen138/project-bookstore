package com.example.demo.service.impl;

import com.example.demo.model.category.Category;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return iCategoryRepository.findAllCategory();
    }
}
