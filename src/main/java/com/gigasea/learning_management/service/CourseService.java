package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Course;
import java.util.List;

public interface CourseService {

    /**
     * Saves or updates a course.
     *
     * @param course the course to be saved or updated.
     */
    void saveCourse(Course course);

    /**
     * Retrieves all courses.
     *
     * @return a list of all courses.
     */
    List<Course> findCourses();

    /**
     * Retrieves a course by its ID.
     *
     * @param id the ID of the course.
     * @return the course with the specified ID.
     */
    Course getCourseById(Long id);

    /**
     * Deletes a course by its ID.
     *
     * @param id the ID of the course to be deleted.
     */
    void deleteCourse(Long id);

    /**
     * Deletes all courses from the database.
     */
    void deleteAllCourses();

    /**
     * Counts the total number of courses in the system.
     *
     * @return the total number of courses.
     */
    long countCourses(); // Added for admin dashboard statistics
}
