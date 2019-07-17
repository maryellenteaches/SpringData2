package com.example.university;

import com.example.university.repo.DepartmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Autowired
    DepartmentRepository departmentRepository;
     /**
     * Queries to Relational Database with Spring Data JDBC.
     *
     * Chair and Departments persisted to H2 in-Memory database at startup.
     * @see JdbcApplication
     */
	@Test
	public void queryMethods() {

        //***************Chair query methods***************
        departmentRepository.findAll().forEach(System.out::println);
        departmentRepository.findByName("John Jones").forEach(System.out::println);
    }
    @Before
    @After
    public void printBanner() {
        System.out.println("*************************************************************************************");
    }

}
