package com.example.university;

import com.example.university.domain.Chair;
import com.example.university.domain.Department;
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
    public void run(String... strings) throws Exception {
        //Chair
        Chair deanJones = new Chair("John Jones");
        Chair deanMartin = new Chair("Matthew Martin");

        //Departments
        Department humanities = departmentRepository.save(new Department("Humanities", deanJones));
        Department naturalSciences = departmentRepository.save(new Department("Natural Sciences", deanMartin));
        Department socialSciences = departmentRepository.save(new Department("Social Sciences", deanJones));

        departmentRepository.save(socialSciences.updateChair(deanMartin));
    }
}
