package com.aptech.testangularspringboot.controller;

import com.aptech.testangularspringboot.entity.Book;
import com.aptech.testangularspringboot.entity.Category;
import com.aptech.testangularspringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories(){
        List<Category> listCategories = categoryService.listCategories();

        return ResponseEntity.status(HttpStatus.OK).body(listCategories);
    }
}
