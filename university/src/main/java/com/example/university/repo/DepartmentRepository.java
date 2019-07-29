package com.example.university.repo;

import com.example.university.domain.Department;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * DataSource Management for the Departments at the University.
 * <p>
 * Created by maryellenbowman.
 */
public interface DepartmentRepository extends CrudRepository<Department, String> {

    @Query("SELECT DEPARTMENT.id AS id, DEPARTMENT.name AS name, chair.department AS chair_department, chair.name AS chair_name " +
            "FROM DEPARTMENT LEFT OUTER JOIN CHAIR AS chair ON chair.DEPARTMENT = DEPARTMENT.id " +
            "WHERE DEPARTMENT.name =:name")
    Optional<Department> findByName(@Param("name")String name);
}
