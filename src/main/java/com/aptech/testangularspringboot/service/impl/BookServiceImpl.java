package com.aptech.testangularspringboot.service.impl;

import com.aptech.testangularspringboot.FileUploadUtil;
import com.aptech.testangularspringboot.entity.Book;
import com.aptech.testangularspringboot.repository.BookRepository;
import com.aptech.testangularspringboot.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> getAllBooks(int pageNum, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        if(keyword != null) {
            return bookRepository.findAll(keyword, pageable);
        }

        return bookRepository.findAll(pageable);
    }

    @Override
    public Book save(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
