package com.votingSystem.controller;

import com.votingSystem.entity.User;
import com.votingSystem.service.JwtService;
import com.votingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/election")
public class ElectionController {

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/registraion-form")
    public String registraionForm(Model model) {

        List<User> subAdmins = userService.findSubAdmins();
        User currentUser = jwtService.getCurrentUser();

        model.addAttribute("allSubAdmins", subAdmins);
        model.addAttribute("currentUser", currentUser);

        return "election/election_creation_form";
    }

}
