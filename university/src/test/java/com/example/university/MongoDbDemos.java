package com.example.university;

import com.example.university.domain.Department;
import com.example.university.domain.Person;
import com.example.university.domain.Staff;
import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.StaffRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrate Various Querying Techniques with Spring Data MongoDb
 *
 * Created by maryellenbowman
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbDemos {

	@Autowired
    StaffRepository staffRepository;

	@Autowired
    DepartmentRepository departmentRepository;

  //  static ;;
    static List<Staff> allStaff = new ArrayList();
     /**
     * Queries to Mongo DB.
     *
     * Staff and Departments persisted to Fongo in-Memory database at startup.
     * @see MongoDbApplication
     */
	@Test
	public void mongoQueryMethods() {
        //Staff
        Flux<Staff> staffFlux = staffRepository.findAll();
        System.out.println(staffFlux.blockLast());

        Mono<Staff> deanJonesMono = staffRepository.save(new Staff(1, new Person("John", "Jones")));
        Mono<Staff> deanMartinMono = staffRepository.save(new Staff(2, new Person("John", "Martin")));

        System.out.println("Before Staff has subscribed " + staffFlux.count().block());

        Staff deanJones = deanJonesMono.block();
        deanMartinMono.subscribe();
        Staff deanMartin = staffRepository.findByMemberLastName("Martin").blockFirst();

        System.out.println(("After Staff has subscribed " + staffFlux.count().block()));

        //Departments
        departmentRepository.saveAll(
                Arrays.asList(new Department(100, "Humanities", deanJones),
                            new Department(200, "Natural Sciences", deanMartin),
                            new Department(300, "Social Sciences", deanJones)))
                .blockLast();

        System.out.println(("Total Departments " + departmentRepository.findAll().count().block()));
	}

	private void print(String message, Flux<?> flux) {

	    System.out.println(message + ":\t " + flux.count().block());
    }

    @Before
    @After
    public void printBanner() {
        System.out.println("*************************************************************************************");
    }

}
