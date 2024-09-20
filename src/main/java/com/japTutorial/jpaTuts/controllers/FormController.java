package com.japTutorial.jpaTuts.controllers;

import com.japTutorial.jpaTuts.entities.FormDataEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class FormController {

    @PostMapping("/submitForm")
    public String handleFormSubmit(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("aadharNumber") String aadharNumber,
            @RequestParam("profilePic") MultipartFile profilePic,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword
    ){

        System.out.println("name: " + name);
        System.out.println("email: " + email);
        System.out.println("aadharNumber: " + aadharNumber);
        System.out.println("profilePic: " + profilePic);
        System.out.println("password: " + password);
        System.out.println("confirmPassword: " + confirmPassword);

        return "Form submitted successfully!";

    }

    @PostMapping("/submit")
    public String handleFormSubmission(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("aadhar") String aadhar,
            @RequestParam("profilePic") MultipartFile profilePic,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword
            ) throws IOException {

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Aadhar Number: " + aadhar);
        System.out.println("ProfilePic: " + profilePic);
        System.out.println("Password: " + password);
        System.out.println("ConfirmPassword: " + confirmPassword);

//        String uploadDir = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadedImages";
//        System.out.println("UploadDir"+uploadDir);
//
//        // Create a temporary file
//        File file = new File(uploadDir+ File.separator + profilePic.getOriginalFilename());
//
//        // Save MultipartFile to the temporary file
//        profilePic.transferTo(file);

        FormDataEntity formData = new FormDataEntity(name,email,password,profilePic,aadhar);
        System.out.println(formData);

        return "redirect:/result.html";
    }
}
