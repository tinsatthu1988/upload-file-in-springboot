package com.aptech.testangularspringboot.service;

import com.aptech.testangularspringboot.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book save(Book book);

}
