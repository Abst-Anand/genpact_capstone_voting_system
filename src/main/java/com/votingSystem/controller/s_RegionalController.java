package com.votingSystem.controller;

import com.votingSystem.entity.Image;

import com.votingSystem.entity.User;
import com.votingSystem.service.CloudinaryService;
import com.votingSystem.service.ImageService;

import com.votingSystem.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/subAdmin")
public class s_RegionalController {


    private final ImageService imageService;
    private final CloudinaryService cloudinaryService;
    private final UserService userService;


    public s_RegionalController(ImageService imageService, CloudinaryService cloudinaryService,UserService userService) {
        
        this.imageService = imageService;
        this.cloudinaryService = cloudinaryService;
        this.userService = userService;
    }
   
    
    @GetMapping("/subAdmin-form")
    public String registrationForm() {
        return "subAdmin/s_registration";
    }

    @PostMapping("/register")
    public String RegionalRegistration(  @RequestParam String name,
                                        @RequestParam String email,                                    
                                        @RequestParam MultipartFile profilePic,
                                        @RequestParam String aadharNumber,
                                        @RequestParam String password,
                                        Model model
    ){
    	System.out.println("subAdmin/register called");
    	
        String profilePicturePublicId = "sn7a75ssxdqsyea2xtnb";


        int profilePicId = imageService.saveImage(new Image(profilePicturePublicId)).getImageId();
        
        String encryptedPassword = userService.encryptPassword(password);
        System.out.println("Encrypted password: " + encryptedPassword);
    
        
        User user = new User(name,email,profilePicId,aadharNumber,2,encryptedPassword,0,true);
        System.out.println(user);

            User savedUser = userService.saveUser(user);
      
        

        if(savedUser != null){
            model.addAttribute("success", "RegionalOffcier has been registered successfully");
        }else{
            model.addAttribute("error", "Unable to add Regional Offcier");
   }

        return "subAdmin/s_registration";


    }
}

