package com.votingSystem.controller;


import com.votingSystem.entity.Candidate;
import com.votingSystem.entity.Image;
import com.votingSystem.service.CandidateService;
import com.votingSystem.service.CloudinaryService;
import com.votingSystem.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

    private final CandidateService candidateService;
    private final ImageService imageService;
    private final CloudinaryService cloudinaryService;


    public CandidateController(CandidateService candidateService,ImageService imageService, CloudinaryService cloudinaryService) {
        this.candidateService = candidateService;
        this.imageService = imageService;
        this.cloudinaryService = cloudinaryService;
    }






    @GetMapping("/registration-form")
    public String registrationForm() {
        return "candidate/registration";
    }

    @PostMapping("/register")
    public String candidateRegistration(  @RequestParam String name,
                                        @RequestParam String description,
                                        @RequestParam String aadharNumber,
                                        @RequestParam MultipartFile profilePic,
                                        @RequestParam String partyName,
                                        @RequestParam MultipartFile partyLogo,
                                        @RequestParam int createdBy,
                                        Model model
    ){


        String profilePicPublicId, partyLogoPublicId;

        try {
            profilePicPublicId = cloudinaryService.uploadImage(profilePic);
        } catch (IOException e) {
            model.addAttribute("error", "Unable to upload profile picture");
            return "/candiate/registration";
        }

        try {
            partyLogoPublicId = cloudinaryService.uploadImage(partyLogo);
        } catch (IOException e) {
            model.addAttribute("error", "Unable to upload party logo");
            return "/candidate/registration";
        }

        int profilePicId = imageService.saveImage(new Image(profilePicPublicId)).getImageId();
        int partyLogoId = imageService.saveImage(new Image(partyLogoPublicId)).getImageId();



        Candidate candidate = new Candidate(name,description,aadharNumber,profilePicId,partyName,partyLogoId,createdBy);

        System.out.println(candidate);

        Candidate savedCandidate = candidateService.saveCandidate(candidate);

        if(savedCandidate != null){
            model.addAttribute("success", "Candidate has been registered successfully");
        }else{
            model.addAttribute("error", "Unable to add candidate");
        }

        return "/candidate/registration";


    }






}
