package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.service.AttendanceService;
import com.gigasea.learning_management.service.CourseService;
import com.gigasea.learning_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final AttendanceService attendanceService;
    private final EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public AdminController(StudentService studentService,
                           CourseService courseService,
                           AttendanceService attendanceService,
                           EntityManager entityManager) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.attendanceService = attendanceService;
        this.entityManager = entityManager;
    }

    /**
     * Displays the admin panel with current system statistics.
     *
     * @param model Spring's model object to pass data to the view.
     * @return The admin panel view name.
     */
    @GetMapping("/adminPanel")
    public String showAdminPanel(Model model) {
        model.addAttribute("totalStudents", studentService.countStudents());
        model.addAttribute("totalCourses", courseService.countCourses());
        model.addAttribute("totalAttendances", attendanceService.countAttendances());
        model.addAttribute("message", "Welcome to the Admin Panel.");
        return "adminPanel";  // Ensure this view name matches your actual view (e.g., adminPanel.html)
    }

    /**
     * Clears all data from the system, including students, courses, and attendance.
     *
     * @param model Spring's model object to pass data to the view.
     * @return Redirects back to the admin panel with a success or failure message.
     */
    @Transactional
    @PostMapping("/admin/clearData")
    public String clearData(Model model) {
        try {
            logger.info("Clearing all data from the system...");

            // Delete all data
            attendanceService.deleteAllAttendances();
            studentService.deleteAllStudents();
            courseService.deleteAllCourses();

            // Reset auto-increment IDs for affected tables
            entityManager.createNativeQuery("ALTER TABLE student AUTO_INCREMENT = 1").executeUpdate();
            entityManager.createNativeQuery("ALTER TABLE course AUTO_INCREMENT = 1").executeUpdate();

            logger.info("All data cleared successfully.");
            model.addAttribute("message", "All data cleared and IDs reset successfully.");
        } catch (Exception e) {
            logger.error("An error occurred while clearing data: {}", e.getMessage(), e);
            model.addAttribute("message", "Failed to clear data. Please try again later.");
        }
        return "adminPanel"; // Ensure this view name matches your actual view for redirection.
    }

    /**
     * Redirects to the leaderboard page.
     *
     * @return The leaderboard page.
     */
    @GetMapping("/admin/leaderboard")
    public String redirectToLeaderboard() {
        return "leaderboard"; // Maps to the leaderboard.html template
    }
    // Ensure the 'leaderboard.html' view exists in the correct location
    }
