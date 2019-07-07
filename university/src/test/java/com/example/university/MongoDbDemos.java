package com.example.university;

import com.example.university.domain.Staff;
import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.StaffRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

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
     /**
     * Queries to Mongo DB.
     *
     * Staff and Departments persisted to Fongo in-Memory database at startup.
     * @see MongoDbApplication
     */
	@Test
	public void mongoQueryMethods() {

        //***************Staff query methods***************

        //Paging and Sorting Queries
        System.out.println("\nFind all staff members, sort alphabetically by last name");
        Sort sortByLastName = new Sort(Sort.Direction.ASC, "member.lastName");
        staffRepository.findAll(sortByLastName).forEach(System.out::println);

        System.out.println("\nFind first 5 Staff members, sort alphabetically by last name");
        Page<Staff> members = staffRepository.findAll(PageRequest.of(0, 5, sortByLastName));
        members.forEach(System.out::println);


        //Property Expression
        System.out.println("\nFind all staff members with last name King");
        staffRepository.findByMemberLastName("King").forEach(System.out::println);

        //@Query with JSON query string
        //"{ 'member.firstName' : ?0 }"
        System.out.println("\nFind all staff members with first name John");
        staffRepository.findByFirstName("John").forEach(System.out::println);


        //***************Department query methods***************

        //Sorting example, MongoRepository extends PagingAndSortingRepository
        System.out.println("\nFind all Departments, sort alphabetically by  name");
        departmentRepository.findAll(new Sort(Sort.Direction.ASC, "name")).forEach(System.out::println);

        //Property Expression
        System.out.println("\nFind Department with the exact name 'Humanities' \n" +
                departmentRepository.findByName("Humanities"));

        //@Query with JSON query string that accepts regular expression as a parameter
        //{ 'name' : { $regex: ?0 } }
        //Any department name that ends in sciences where 's' is case insensitive
        System.out.println("\nFind all Departments with name ending in Sciences");
        departmentRepository.findNameByPattern(".[Ss]ciences").forEach(System.out::println);


        //Invalid Method, will fail at runtime
        System.out.println("\nInvalid Method, cannot cross DBRef's in queries");
        departmentRepository.findByChairMemberLastName("Jones");
    }
    @Before
    @After
    public void printBanner() {
        System.out.println("*************************************************************************************");
    }

}
