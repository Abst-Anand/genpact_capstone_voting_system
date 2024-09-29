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
@RequestMapping("/candidate")
public class u_candidateController {

//    @Autowired
//    private Candidate candidate;

	@GetMapping("/info")
	public String showAdminConsolidatedInfo(Model model) {
		System.out.println("candidate/info Controller called");

		return "u_candidateConsolidatedinfo"; // Maps to /WEB-INF/views/admin_consolidated_info.jsp
	}

}
