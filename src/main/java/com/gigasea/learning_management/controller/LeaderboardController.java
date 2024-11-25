package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.model.Leaderboard;
import com.gigasea.learning_management.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @Autowired
    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        List<Leaderboard> leaderboardData = leaderboardService.getLeaderboard();
        model.addAttribute("leaderboard", leaderboardData);
        return "leaderboard";
    }
}
