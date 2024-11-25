package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Student;
import com.gigasea.learning_management.model.Course;
import com.gigasea.learning_management.repository.StudentRepository;
import com.gigasea.learning_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentId(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll(); // Deletes all students
    }

    @Override
    public void addCourseToStudent(Long studentId, Long courseId) {
        // Fetch student and course by their IDs
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Add the course to the student's course list
        student.getCourses().add(course);

        // Save the updated student
        studentRepository.save(student);
    }

    @Override
    public long countStudents() {
        return studentRepository.count(); // Counts the number of students in the repository
    }
}
