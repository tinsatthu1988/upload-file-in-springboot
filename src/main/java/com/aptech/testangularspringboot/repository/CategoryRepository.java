package com.aptech.testangularspringboot.repository;

import com.aptech.testangularspringboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
