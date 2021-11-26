package com.aptech.testangularspringboot.repository;

import com.aptech.testangularspringboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
