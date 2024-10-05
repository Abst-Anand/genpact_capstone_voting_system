package com.votingSystem.utility;

import com.votingSystem.entity.User;
import com.votingSystem.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;

public class CookieHelper {

    private User user;
    private JwtService jwtService;

    public CookieHelper(User user, JwtService jwtService) {
        this.user = user;
        this.jwtService = jwtService;
    }

//    public User getUser() {
//
//    }
//
//    private String getTokenFromCookie(HttpServletRequest request) {
//
//    }

}
