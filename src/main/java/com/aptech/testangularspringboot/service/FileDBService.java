package com.aptech.testangularspringboot.service;

import com.aptech.testangularspringboot.entity.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileDBService {
    FileDB store(MultipartFile file) throws IOException;

    Stream<FileDB> getAllFiles();
}
