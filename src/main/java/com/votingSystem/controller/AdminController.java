package com.votingSystem.controller;

import com.votingSystem.entity.Election;
import com.votingSystem.entity.User;
import com.votingSystem.service.ElectionService;
import com.votingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ElectionService electionService;

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public String showAdminConsolidatedInfo(Model model) {
        System.out.println("admin/info Controller called");

        List<Election> allElectionsList = electionService.getAllElections();
        List<User> allSubAdmins = userService.findSubAdmins();

        model.addAttribute("allElections", allElectionsList);
        model.addAttribute("allSubAdmins", allSubAdmins);

        return "admin_consolidated_info"; // Maps to /WEB-INF/views/admin_consolidated_info.jsp
    }

    @GetMapping("/manageAuthority")
    public String manageAuthority(@RequestParam int admin, @RequestParam String subAdmin) {

        System.out.println("admin: " + admin);
        System.out.println("subAdmin: " + subAdmin);



        return "admin_dashboard.html";
    }
}
