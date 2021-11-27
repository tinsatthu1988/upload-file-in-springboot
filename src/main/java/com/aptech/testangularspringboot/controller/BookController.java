package com.aptech.testangularspringboot.controller;

import com.aptech.testangularspringboot.FileUploadUtil;
import com.aptech.testangularspringboot.entity.Book;
import com.aptech.testangularspringboot.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks(){
        List<Book> listBooks = bookService.getAllBooks();

        return ResponseEntity.status(HttpStatus.OK).body(listBooks);
    }

    @PostMapping(value = "/books", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> saveBooks(@RequestPart("book") String book, @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        Book bookJson = new Book();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            bookJson = objectMapper.readValue(book, Book.class);
        } catch (IOException ex){
            System.out.println(ex.toString());
        }

        if (file != null) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            bookJson.setImageName(fileName);
            Book savedBook = bookService.save(bookJson);
            String uploadDir = "book-images/" + savedBook.getId();

            FileUploadUtil.cleanDir(uploadDir);
            FileUploadUtil.saveFile(uploadDir, fileName, file);
        }

        Book savedBook = bookService.save(bookJson);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @DeleteMapping("books/{bookId}") //api/auth/book/{bookId}
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId)
    {
        bookService.delete(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
