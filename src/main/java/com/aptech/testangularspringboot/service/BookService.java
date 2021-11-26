package com.aptech.testangularspringboot.service;

import com.aptech.testangularspringboot.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book save(Book book);

    Book getJson(String book, MultipartFile file) throws IOException;

}
