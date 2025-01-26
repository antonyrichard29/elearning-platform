package antoEP.ElearningPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import antoEP.ElearningPlatform.entities.Users;
import antoEP.ElearningPlatform.services.UsersService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

    @Autowired
    UsersService uservice;

    // Register a new user
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute Users user, Model model) {
        String email = user.getEmail();
        boolean isPresent = uservice.checkEmail(email);

        if (!isPresent) {
            uservice.addUser(user);
            model.addAttribute("successMessage", "Registration successful! Please login.");
            return "login";  // Redirect to login page after successful registration
        } else {
            model.addAttribute("errorMessage", "This email is already registered.");
            return "register";  // Stay on the registration page if the email already exists
        }
    }

    // Validate user login
    @PostMapping("/validateUser")
    public String validateUser(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {
        Users user = uservice.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user); // Store user in session
            // Redirect based on the user's role
            if ("trainer".equals(user.getRole())) {
                return "redirect:/trainerHome";  // Redirect to trainer's home page
            } else {
                return "redirect:/studentHome";  // Redirect to student's home page
            }
        } else {
            model.addAttribute("errorMessage", "Incorrect email or password");
            return "login";  // Return to login page with error message
        }
    }

}

