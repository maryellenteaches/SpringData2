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

import java.util.Arrays;

/**
 * Demonstrate Various Querying Techniques with Spring Data MongoDb
 *
 * Created by maryellenbowman
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveMongoDbDemos {

	@Autowired
    StaffRepository staffRepository;

	@Autowired
    DepartmentRepository departmentRepository;

    /**
     * Queries to Mongo DB.
     */
	@Test
	public void mongoQueryMethods() {
        //Create 2 Mono Staff publishers, data not persisted yet!
        Mono<Staff> deanJonesMono = staffRepository.save(new Staff(1, new Person("John", "Jones")));
        Mono<Staff> deanMartinMono = staffRepository.save(new Staff(2, new Person("John", "Martin")));

        Flux<Staff> staffFlux = staffRepository.findAll();

        System.out.println("Staff count found in DB BEFORE subscription: " + staffFlux.count().block());

        //Subscribe with block(), returns entity
        Staff deanJones = deanJonesMono.block();

        //Subscribe with subscribe(), does not return entity
        deanMartinMono.subscribe();

        System.out.println("Staff count found in DB AFTER subscription:" + staffFlux.count().block());

        //Query returns a Flux publisher
        Flux<Staff> deanMartinFindByFlux = staffRepository.findByMemberLastName("Martin");
        Staff deanMartin = deanMartinFindByFlux.blockFirst();

        //Departments

        //Create an asynchronous publisher that gets the total number of Departments
        Mono<Long> departmentCountMono = departmentRepository.findAll().count();

        //Create a asynchronouse Flux publisher that persists 3 new Departments
        Flux<Department> departmentFlux = departmentRepository.saveAll(
                Arrays.asList(new Department(100, "Humanities", deanJones),
                            new Department(200, "Natural Sciences", deanMartin),
                            new Department(300, "Social Sciences", deanJones)));

        System.out.println("Departments found in DB BEFORE subscription: "
                + departmentCountMono.block());

        //Persist the 3 departments, and block until complete
        departmentFlux.blockLast();

        System.out.println(("Departments found in DB AFTEr subscription: "
                + departmentCountMono.block()));
	}

    @Before
    @After
    public void printBanner() {
        System.out.println("*************************************************************************************");
    }

}
