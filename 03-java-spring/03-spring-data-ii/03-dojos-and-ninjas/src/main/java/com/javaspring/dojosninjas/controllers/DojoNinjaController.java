package com.javaspring.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaspring.dojosninjas.models.Dojo;
import com.javaspring.dojosninjas.models.Ninja;
import com.javaspring.dojosninjas.services.DojoService;
import com.javaspring.dojosninjas.services.NinjaService;

@Controller
public class DojoNinjaController {
	@Autowired
	DojoService dServ;
	@Autowired
	NinjaService nServ;
	
	@GetMapping("/dojos/new")
	public String createDojoPage(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";			
		} else {
			dServ.add(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String getDojo(@PathVariable Long id, Model model) {
		//no handler for invalid dojo id
		model.addAttribute("dojo", dServ.retrieveOne(id));
		return "dojo.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String createNinjaPage(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dServ.all());
		return "newninja.jsp";			

	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newninja.jsp";			
		} else {
			nServ.add(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
