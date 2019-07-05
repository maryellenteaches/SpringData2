package com.example.university;

import com.example.university.domain.Department;
import com.example.university.domain.Person;
import com.example.university.domain.Staff;
import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Class for the University Application.
 * On Startup Initialize Database with Staff and Departments.
 * <p>
 * Created by maryellenbowman
 */
@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //Staff
        Staff deanJones = staffRepository.save(new Staff(1, new Person("John", "Jones")));
        Staff deanMartin = staffRepository.save(new Staff(2, new Person("Matthew", "Martin")));
        Staff profBrown = staffRepository.save(new Staff(3, new Person("James", "Brown")));
        Staff profMiller = staffRepository.save(new Staff(4, new Person("Judy", "Miller")));
        Staff profDavis = staffRepository.save(new Staff(5, new Person("James", "Davis")));
        Staff profMoore = staffRepository.save(new Staff(6, new Person("Allison", "Moore")));
        Staff profThomas = staffRepository.save(new Staff(7, new Person("Tom", "Thomas")));
        Staff profGreen = staffRepository.save(new Staff(8, new Person("Graham", "Green")));
        Staff profWhite = staffRepository.save(new Staff(9, new Person("Whitney", "White")));
        Staff profBlack = staffRepository.save(new Staff(10, new Person("Jack", "Black")));
        Staff profKing = staffRepository.save(new Staff(11, new Person("Queen", "King")));

        //Departments
        Department humanities = departmentRepository.save(new Department(100, "Humanities", deanJones));
        Department naturalSciences = departmentRepository.save(new Department(200, "Natural Sciences", deanMartin));
        Department socialSciences = departmentRepository.save(new Department(300, "Social Sciences", deanJones));

    }
}
