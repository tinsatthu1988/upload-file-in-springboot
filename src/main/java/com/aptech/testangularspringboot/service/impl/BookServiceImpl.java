package com.aptech.testangularspringboot.service.impl;

import com.aptech.testangularspringboot.FileUploadUtil;
import com.aptech.testangularspringboot.entity.Book;
import com.aptech.testangularspringboot.repository.BookRepository;
import com.aptech.testangularspringboot.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {

        return bookRepository.save(book);
    }

    public Book getJson(String book, MultipartFile file) throws IOException{
        Book bookJson = new Book();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            bookJson = objectMapper.readValue(book, Book.class);
        } catch (IOException ex){
            System.out.println(ex.toString());
        }

        return bookJson;
    }
}
