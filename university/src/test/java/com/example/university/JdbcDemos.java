package com.example.university;

import com.example.university.domain.Chair;
import com.example.university.domain.Department;
import com.example.university.repo.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Demonstrate Various Querying Techniques with Spring Data MongoDb
 *
 * Created by maryellenbowman
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcDemos {
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDemos.class);


    @Autowired
    private DepartmentRepository departmentRepository;
     /**
     * Queries to Relational Database with Spring Data JDBC.
     *
     * Chair and Departments persisted to H2 in-Memory database at startup.
     * @see JdbcApplication
     */
	@Test
	public void queryMethods() {
        //Chairs
        Chair deanJones = new Chair("Dean Jones");
        Chair deanMartin = new Chair("Dean Martin");
        Chair deanCain = new Chair("Dean Cain");

        //Departments
        printBanner("SQL to Create Humanities");
        departmentRepository.save(new Department("Humanities", deanJones));

        printBanner("SQL to Create Natural Sciences");
        departmentRepository.save(new Department("Natural Sciences", deanMartin));

        printBanner("SQL to Create Social Sciences");
        departmentRepository.save(new Department("Social Sciences", deanJones));

        printBanner("SQL to Fetch all Departments");
        departmentRepository.findAll().forEach(System.out::println);

        printBanner("SQL to Lookup Department by Name");
        departmentRepository.findByName("Humanities").ifPresent(department -> {
            //Modify Department, change chair from Dean Jones to Dean Cain
            department.setChair(deanCain);
            printBanner("SQL to Update a Department, Deparment id = " + department.getId());
            departmentRepository.save(department);
        });
    }

    public void printBanner(String message) {
        System.out.println("\n****************************************************************************************************************************  " + message + "\n");
    }

}
