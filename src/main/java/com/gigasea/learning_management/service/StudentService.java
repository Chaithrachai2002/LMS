package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> findStudents();
    Student getStudentId(Long id); // Add this method
    void deleteStudent(Long id);
    void deleteAllStudents();
    void addCourseToStudent(Long studentId, Long courseId);
    long countStudents();
}
