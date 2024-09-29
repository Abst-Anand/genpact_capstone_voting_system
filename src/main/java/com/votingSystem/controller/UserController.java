package com.votingSystem.controller;

import com.votingSystem.entity.Image;
import com.votingSystem.entity.User;
import com.votingSystem.service.CloudinaryService;
import com.votingSystem.service.ImageService;
import com.votingSystem.service.UserService;
import com.votingSystem.utilities.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final ImageService imageService;
    private final CloudinaryService cloudinaryService;
    private final JwtUtil jwtUtil;


    public UserController(UserService userService, ImageService imageService, CloudinaryService cloudinaryService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.imageService = imageService;
        this.cloudinaryService = cloudinaryService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/registration-form")
    public String registrationForm() {
        return "redirect:/voter_form.html";
    }

    @PostMapping("/voter-registration")
    public String voterRegistration(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("aadharNumber") String aadharNumber,
            @RequestParam("profilePic") MultipartFile profilePic,
            @RequestParam("password") String password,
            Model model
    ){

        System.out.println("/userr/voter-registration called");
        String imagePublicUrlId;
        int role = 3;

        email = email.toLowerCase();

        try {
            imagePublicUrlId = cloudinaryService.uploadImage(profilePic);
        }catch (IOException e){
            model.addAttribute("error", "Image upload failed. Try again.");
            return "redirect:/user/registration-form";
        }

        Image image = imageService.saveImage(new Image(imagePublicUrlId));


        User user = new User(name, email, image.getImageId(), aadharNumber, role, password, false);

        boolean signUpStatus = userService.signUp(user);

        String successMessage = "Registration Successful! Your data will be reviewed and approved soon.";
        String failureMessage = "A user with email " + user.getEmail() + " already exists.";

        if (signUpStatus) {
            model.addAttribute("successMessage", successMessage);
        }
        else{
            model.addAttribute("failureMessage", failureMessage);
        }

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpServletResponse response,
                        Model model) {

        System.out.println("/user/login called");
        email = email.toLowerCase();
        Optional<User> userOptional = userService.findUserByEmail(email);

        if(userOptional.isEmpty()) {
            model.addAttribute("error", "No user exists with given email.");
            return "redirect:/";
        }

        User user = userOptional.get();

        if(user.getRole() == 3 && !user.isApproved()){
            model.addAttribute("error", "Your account has not been approved yet.");
            return "redirect:/";
        }

        if(!password.equals(user.getPassword())) {
            model.addAttribute("error", "Wrong password.");
            return "redirect:/";
        }

        String token = jwtUtil.generateJwtToken(user);

        // Create a cookie
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true); // Helps prevent XSS attacks
        cookie.setPath("/"); // Accessible to the entire application
        cookie.setMaxAge(60 * 60); // Set cookie expiration (1 hour)

        // Add the cookie to the response
        response.addCookie(cookie);

        if(user.getRole() == 1){
            return "redirect:/admin_dashboard.html";
        }
        else if(user.getRole() == 2){
            return "redirect:/s_subAdmin_dashboard.html";
        }
        else{
//            return "redirect:/u_voter_dashboard.html";
            return "test";
        }


    }

    @GetMapping("/profile")
    public String getUserProfile(@CookieValue(value = "token", defaultValue = "NA") String token, Model model) {

        if(token.equals("NA")){
            return "redirect:/";
        }

        if(jwtUtil.isTokenExpired(token)) {
            model.addAttribute("message", "Please login again.");
            return "redirect:/";
        }

        Map<String, String> userDetails = jwtUtil.extractUserDetails(token);

        System.out.println("User details map" + userDetails.keySet());
        System.out.println("User details map" + userDetails.values());

        int imageId = Integer.parseInt(userDetails.get("profilePicId"));
        int roleId = Integer.parseInt(userDetails.get("roleId"));


        String imagePublicId = imageService.getImage(imageId).getImageUrl();
        String role = getRoleName(roleId);

        userDetails.put("imagePublicId", imagePublicId);
        userDetails.put("role", role);

        System.out.println("User details map" + userDetails.keySet());
        System.out.println("User details map" + userDetails.values());

        model.addAttribute("userDetails",userDetails);

        return "profile";
    }


    private String getRoleName(int roleId){
        if(roleId == 1) return "ELECTION COMMISSIONER";

        if(roleId == 2) return "REGIONAL OFFICER";

        if(roleId == 3) return "VOTER";

        return null;
    }


}
