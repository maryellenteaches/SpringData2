package com.example.university.repo;

import com.example.university.domain.Department;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * DataSource Management for the Departments at the University.
 * <p>
 * Created by maryellenbowman.
 */
public interface DepartmentRepository extends ReactiveCrudRepository<Department, String> {

}
