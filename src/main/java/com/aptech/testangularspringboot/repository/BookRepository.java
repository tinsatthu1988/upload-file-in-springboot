package com.aptech.testangularspringboot.repository;

import com.aptech.testangularspringboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE CONCAT(b.id , ' ', b.title, ' ', b.author) LIKE %?1%")
    public Page<Book> findAll(@RequestParam("keyword") String keyword, Pageable pageable);
}
