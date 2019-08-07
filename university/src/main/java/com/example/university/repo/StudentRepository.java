package com.example.university.repo;

import com.example.university.domain.Person;
import com.example.university.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * DataSource Management for the Students at the University.
 *
 * Created by maryellenbowman
 */
public interface StudentRepository extends CrudRepository<Student, Integer>{
}
