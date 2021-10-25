package com.javaspring.lang.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.javaspring.lang.models.Language;
import com.javaspring.lang.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private LanguageService langServ;
	@GetMapping("/languages")
	public String languagesListing(@ModelAttribute("lang") Language lang, Model model) {
		model.addAttribute("languages",langServ.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String submitLanguage(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			
			langServ.addLanguage(lang);
			return "redirect:/languages";
		}
		
	}
	
	@GetMapping("/languages/{id}")
	public String viewLanguage(@PathVariable Long id, Model model) {
		Language lang = langServ.retrieveLanguage(id);
		if(lang == null) {
			return "dne.jsp";
		}
		model.addAttribute("language", lang);
		return "view.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String editLanguage(
			@PathVariable Long id,
			Model model
			) {
		Language lang = langServ.retrieveLanguage(id);
		if(lang == null) {
			return "dne.jsp";
		}
		model.addAttribute("lang", lang);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String submitEditLanguage(
			@PathVariable Long id,
			@Valid @ModelAttribute("lang") Language lang,
			BindingResult result) {
		Language l = langServ.retrieveLanguage(id);
		if(l == null) {
			return "dne.jsp";
		}
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			lang.setId(id);
			langServ.addLanguage(lang);
			return "redirect:/languages";
		}
		
	}
	@DeleteMapping("/languages/{id}")
	public String destroy(@PathVariable Long id) {
		Language lang = langServ.retrieveLanguage(id);
		if(lang == null) {
			return "dne.jsp";
		}
		langServ.removeLanguage(id);
		return "redirect:/languages";
	}
}
