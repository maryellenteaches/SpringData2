package com.example.university.repo;

import com.example.university.domain.Department;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * DataSource Management for the Departments at the University.
 * <p>
 * Created by maryellenbowman.
 */
public interface DepartmentRepository extends ReactiveCrudRepository<Department, String> {

    Mono<Department> findByName(String name);

    @Query("{ 'name' : { $regex: ?0 } }")
    Flux<Department> findNameByPattern(String pattern);

    //This method fails because cannot perform Joins across DBRef's
    Flux<Department> findByChairMemberLastName(String lastName);

}
