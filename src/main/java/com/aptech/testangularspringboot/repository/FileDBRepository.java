package com.aptech.testangularspringboot.repository;

import com.aptech.testangularspringboot.entity.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
