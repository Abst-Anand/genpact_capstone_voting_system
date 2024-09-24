package com.votingSystem.controller;

import com.votingSystem.entity.Election;
import com.votingSystem.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JspController {

    @Autowired
    private ElectionService electionService;

    @GetMapping("/admin/consolidated")
    public String showAdminConsolidatedInfo(Model model) {
        System.out.println("JSP Controller called");

        List<Election> allElectionsList = electionService.getAllElections();

        System.out.println(allElectionsList);
        model.addAttribute("allElections", allElectionsList);


        return "admin_consolidated_info"; // Maps to /WEB-INF/views/admin_consolidated_info.jsp
    }
}
