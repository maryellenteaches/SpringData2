package com.example.university.repo;

import com.example.university.domain.Staff;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

/**
 * DataSource Management for the Staff at the University.
 * <p>
 * Created by maryellenbowman.
 */
public interface StaffRepository extends ReactiveSortingRepository<Staff, Integer> {

    Flux<Staff> findByMemberLastName(String lastName);

    @Query("{ 'member.firstName' : ?0 }")
    Flux<Staff> findByFirstName(String firstName);

}
