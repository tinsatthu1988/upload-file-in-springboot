package com.aptech.testangularspringboot.service.impl;

import com.aptech.testangularspringboot.entity.Category;
import com.aptech.testangularspringboot.repository.CategoryRepository;
import com.aptech.testangularspringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
}
