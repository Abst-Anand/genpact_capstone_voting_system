package com.votingSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Controller
@RequestMapping("/manageAuthority")
public class ManageAuthority {

    @GetMapping
    public String manageAuthority(@RequestParam int admin, @RequestParam String subAdmin) {

        System.out.println("admin: " + admin);
        System.out.println("subAdmin: " + subAdmin);

//        return ResponseEntity.status(HttpStatus.FOUND)
//                .location(URI.create("/admin_dashboard.html"))
//                .build();

        return "admin_dashboard.html";
    }
}
