package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.model.Course;
import com.gigasea.learning_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", courseService.findCourses());
        return "courses"; // The view name to display the list of courses
    }

    @GetMapping("/registerCourse")
    public String registerCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "registerCourse"; // View to register a new course
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course); // Save or update course
        return "redirect:/courses"; // Redirect to courses page after saving
    }

    @GetMapping("/updateCourse/{id}")
    public String updateCourse(Model model, @PathVariable Long id) {
        Course course = courseService.getCourseById(id); // Get course by ID
        model.addAttribute("course", course);
        return "updateFormCourse"; // View to update course
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id); // Delete course by ID
        return "redirect:/courses"; // Redirect to courses page after deletion
    }
}
