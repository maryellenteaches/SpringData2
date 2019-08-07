package com.example.university.repo;

import com.example.university.domain.Course;
import com.example.university.view.CourseView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * DataSource Management for the Courses at the University.
 *
 * Created by maryellenbowman
 */
public interface CourseRepository extends CrudRepository<Course,Integer>{


}
