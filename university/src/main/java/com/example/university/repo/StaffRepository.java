package com.example.university.repo;

import com.example.university.domain.Staff;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * DataSource Management for the Staff at the University.
 * <p>
 * Created by maryellenbowman.
 */
public interface StaffRepository extends ReactiveCrudRepository<Staff, Integer> {
    Flux<Staff> findByMemberLastName(String lastName);
}
