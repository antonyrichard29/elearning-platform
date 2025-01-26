package antoEP.ElearningPlatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import antoEP.ElearningPlatform.entities.Users;
import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {
	
	 @GetMapping("/")
	    public String home() {
	        return "home"; // Points to home.html in src/main/resources/templates/
	    }
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/addC")
	public String addC() {
		return "addCourse";
	}
	
	
	@GetMapping("/studentHome")
	public String studentHome(HttpSession session, Model model) {
	    // Retrieve the logged-in user from the session
	    Users student = (Users) session.getAttribute("loggedInUser");
	    model.addAttribute("username", student.getUsername()); // Add username to the model
	    return "studentHome";
	}

	
	@GetMapping("/trainerHome")
	public String trainerHome(HttpSession session, Model model) {
	    // Retrieve the logged-in user from the session
	    Users trainer = (Users) session.getAttribute("loggedInUser");
	    model.addAttribute("username", trainer.getUsername()); // Add username to the model
	    return "trainerHome";
	}

	
}
