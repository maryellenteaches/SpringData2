package com.example.university.repo;

import com.example.university.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * DataSource Management for the Students at the University.
 * <p>
 * Created by maryellenbowman
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
