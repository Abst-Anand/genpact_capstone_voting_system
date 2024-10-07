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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ElectionService electionService;

    @Autowired
    private UserService userService;
    

	@Autowired
	UserDaoImpl u_UserImpl;

    @GetMapping("/info")
    public String showAdminConsolidatedInfo(Model model) {
        System.out.println("admin/info Controller called");

        List<Election> allElectionsList = electionService.getAllElections();
        List<User> allSubAdmins = userService.findSubAdmins();

        model.addAttribute("allElections", allElectionsList);
        model.addAttribute("allSubAdmins", allSubAdmins);

        return "admin_consolidated_info"; // Maps to /WEB-INF/views/admin_consolidated_info.jsp
    }



    @GetMapping("/manageAuthority")
    public String manageAuthority(@RequestParam int admin, @RequestParam int subAdmin, RedirectAttributes attributes,Model model)
    	throws IOException, SerialException, SQLException {

        System.out.println("admin: " + admin);
        System.out.println("subAdmin: " + subAdmin);
        
        int result = u_UserImpl.revokeAuthority(subAdmin);
        List<Election> allElectionsList = electionService.getAllElections();
        List<User> allSubAdmins = userService.findSubAdmins();

        model.addAttribute("allElections", allElectionsList);
        model.addAttribute("allSubAdmins", allSubAdmins);
        
        attributes.addFlashAttribute("adminId", admin);
     
        attributes.addFlashAttribute("updateResult", result > 0 ? "Success" : "Failure");
        
        return "redirect:/admin_dashboard.html";
        
    }
}
