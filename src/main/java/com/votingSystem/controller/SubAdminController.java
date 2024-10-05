package com.votingSystem.controller;

import com.votingSystem.entity.Election;
import com.votingSystem.entity.User;
import com.votingSystem.repository.UserDaoImpl;
import com.votingSystem.service.ElectionService;
import com.votingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



import javax.sql.rowset.serial.SerialException;

@Controller
@RequestMapping("/subAdmin")
public class SubAdminController {
	
	 @Autowired
	 private UserService userService;
	
	 @Autowired
	 UserDaoImpl u_UserImpl;
	 
	 @GetMapping("/info")
	    public String showAdminConsolidatedInfo(Model model) {
	        System.out.println("subAdmin/info Controller called");
	      
	        List<User> allVoters = userService.findPendingVoters();

	        
	        model.addAttribute("allVoters", allVoters);

	        return "voter/u_voter_consolidated_info"; // Maps to /WEB-INF/views/voter/u_voter_consolidated_info.jsp
	    }
	 

	    @GetMapping("/manageVoters")
	    public String manageAuthority(@RequestParam int subAdminId, @RequestParam int voterId, RedirectAttributes attributes,Model model)
	    	throws IOException, SerialException, SQLException {

	        System.out.println("admin: " + subAdminId);
	        System.out.println("subAdmin: " + voterId);
	        
	        int result = u_UserImpl.isApproved(voterId);
	        
	        List<User> allVoters = userService.findPendingVoters();

	       
	        model.addAttribute("allVoters", allVoters);
	        
	         
	     
	        attributes.addFlashAttribute("updateResult", result > 0 ? "Success" : "Failure");
	        
	        return "redirect:/s_subAdmin_dashboard.html";
	        
	    }
	    
	    
	 
	    
	 

}
