package com.gigasea.learning_management.repository;

import com.gigasea.learning_management.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom queries can be added here if needed
}
