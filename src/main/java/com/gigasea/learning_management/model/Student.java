package com.gigasea.learning_management.model;

import jakarta.persistence.*;
import java.util.*;

/**
 * Entity representing a student in the learning management system.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;

    // Many-to-Many relationship with Course
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();  // Avoid duplicates using Set

    // Map of courses to scores
    @ElementCollection
    @CollectionTable(name = "student_course_scores", joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyJoinColumn(name = "course_id") // Maps the key to the Course entity
    @Column(name = "score") // Column to store the score value
    private Map<Course, Double> courseScores = new HashMap<>();


    // Constructors
    public Student() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Map<Course, Double> getCourseScores() {
        return courseScores;
    }

    public void setCourseScores(Map<Course, Double> courseScores) {
        this.courseScores = courseScores;
    }





    /**
     * Retrieves the score for a specific course.
     *
     * @param course the course for which the score is to be fetched
     * @return the score or null if no score is available
     */
    public Double getScoreForCourse(Course course) {
        return courseScores.get(course);
    }

    /**
     * Adds a new feedback entry to the student's feedback list.
     *
     * @param feedbackComment the feedback comment to add
     */


    /**
     * Adds a course to the student's course list.
     *
     * @param course the course to add
     */
    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
