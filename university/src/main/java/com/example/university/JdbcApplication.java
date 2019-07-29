package com.example.university;

import com.example.university.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Class for the University Application.
 * On Startup Initialize Database with Chair and Departments.
 * <p>
 * Created by maryellenbowman
 */
@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception { }
}
