package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Course;
import com.gigasea.learning_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course); // Save or update the course
    }

    @Override
    public List<Course> findCourses() {
        return courseRepository.findAll(); // Retrieve all courses
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null); // Get a course by ID
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id); // Delete a course by ID
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll(); // Delete all courses
    }

    @Override
    public long countCourses() {
        return courseRepository.count(); // Count the total number of courses
    }
}
