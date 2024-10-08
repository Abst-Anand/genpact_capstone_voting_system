package com.votingSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PublicController {

    public String indexPage(){
        return "index";
    }

    @GetMapping("/voter-registration-form")
    public String registrationForm() {
        return "redirect:/voter_form.html";
    }
}
