package com.javafun.cav.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javafun.cav.models.User;
import com.javafun.cav.services.UserService;

// imports removed for brevity
@Controller
public class Users {
	private final UserService uServ;
    
    public Users(UserService userService) {
        this.uServ = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	// if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	} else if(uServ.getByEmail(user.getEmail()) != null) {
    		System.out.println("duplicate email: "+user.getEmail());
    		return "registrationPage.jsp";
    	} else {
    		User newUser = uServ.add(user);
    		session.setAttribute("userId", newUser.getId());
    		return "redirect:/home";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(uServ.authenticatUser(email, password)) {
    		System.out.println("authenticated here!");
    		session.setAttribute("userId", uServ.getByEmail(email).getId());
    		return "redirect:/home";
    	} else {
    		return "redirect:/login";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/login";
    	} else {
    		model.addAttribute("user", uServ.getById(userId));
    		return "home.jsp";    		
    	}
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/login";
    }
}
