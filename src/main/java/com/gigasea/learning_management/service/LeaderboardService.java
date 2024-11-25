package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Student;
import com.gigasea.learning_management.model.Leaderboard; // Correct class import
import com.gigasea.learning_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaderboardService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Leaderboard> getLeaderboard() {
        // Fetch all students from the database
        List<Student> students = studentRepository.findAll();

        // Example: Calculate scores and ranks (modify this logic as per your requirements)
        List<Leaderboard> leaderboard = students.stream()
                .map(student -> {
                    // Calculate total score for each student by summing up the scores from their courses
                    int totalScore = student.getCourses().stream()
                            .mapToInt(course -> (int) course.getScore()) // Assuming the Course class has a getScore() method
                            .sum();

                    // Create a Leaderboard entry for the student
                    return new Leaderboard(
                            student.getId(),
                            student.getFirstname(),
                            student.getLastname(),
                            totalScore,
                            0 // The rank will be assigned later
                    );
                })
                .sorted((e1, e2) -> Integer.compare(e2.getTotalScore(), e1.getTotalScore())) // Sort by total score in descending order
                .collect(Collectors.toList()); // Use Collectors.toList() for earlier Java versions

        // Assign ranks based on the sorted leaderboard
        for (int i = 0; i < leaderboard.size(); i++) {
            leaderboard.get(i).setRank(i + 1); // Rank starts at 1
        }

        return leaderboard; // Return the leaderboard with ranks
    }
}
