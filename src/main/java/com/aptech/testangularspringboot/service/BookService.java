package com.aptech.testangularspringboot.service;

import com.aptech.testangularspringboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {
    Page<Book> getAllBooks(int pageNum, int pageSize, String keyword);

    Book save(Book book);

    void delete(Long id);

}
