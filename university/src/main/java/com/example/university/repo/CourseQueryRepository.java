package com.example.university.repo;

import com.example.university.domain.Course;

/**
 * Declaring a CouseQueryRepository which can only query the Database
 */
public interface CourseQueryRepository extends ReadOnlyRepository<Course, Integer> {
}
