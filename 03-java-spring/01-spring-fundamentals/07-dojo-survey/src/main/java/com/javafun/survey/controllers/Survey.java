package com.javafun.survey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Survey {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/submit")
	public String submit(HttpSession session,
			@RequestParam("name") String name,
			@RequestParam("location") String location,
			@RequestParam("language") String language,
			@RequestParam("comment") String comment
			) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		String lang = "java";
		System.out.println("|"+language+"|"+lang+"|");
		if (language.equals(lang)) {
			System.out.println("this is "+lang);
			return "redirect:/java";
		} else {
			System.out.println("not "+lang);
			return "redirect:/result";			
		}
	}
	@GetMapping("/result")
	public String result(HttpSession session, Model model) {
		model.addAttribute("name", 		session.getAttribute("name"));
		model.addAttribute("location", 	session.getAttribute("location"));
		model.addAttribute("language", 	session.getAttribute("language"));
		model.addAttribute("comment", 	session.getAttribute("comment"));
		return "result.jsp";
	}
	@GetMapping("/java")
	public String javaCircle() {
		return "java.jsp";
	}
}
