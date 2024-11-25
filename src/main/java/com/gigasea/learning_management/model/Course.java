package com.gigasea.learning_management.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String instructor;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    /**
     * Calculates the average score of all students in this course.
     * Assumes students have a method to get their score for a course.
     *
     * @return the average score or 0.0 if no students have scores
     */
    public double getScore() {
        double totalScore = 0.0;
        int studentCount = 0;

        for (Student student : students) {
            // Assuming Student has a method getScoreForCourse(Course course)
            Double score = student.getScoreForCourse(this);
            if (score != null) {
                totalScore += score;
                studentCount++;
            }
        }

        return studentCount > 0 ? totalScore / studentCount : 0.0;
    }
}
