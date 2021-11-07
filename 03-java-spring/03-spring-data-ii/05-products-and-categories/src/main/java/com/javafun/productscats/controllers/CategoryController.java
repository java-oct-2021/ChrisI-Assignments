package com.javafun.productscats.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javafun.productscats.models.Category;
import com.javafun.productscats.services.CategoryService;
import com.javafun.productscats.services.ProductService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService cServ;
	@Autowired
	ProductService pServ;
	
	@GetMapping("/categories/new")
	public String createCategoryPage(@ModelAttribute Category category) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute Category category, BindingResult result,RedirectAttributes ra) {
		if(result.hasErrors()) {
			System.out.println("other err");
			System.out.println(result.getAllErrors());
			return "newcategory.jsp";
		} else {
			try {
				cServ.add(category);
			} catch (DataIntegrityViolationException e) {
				ra.addFlashAttribute("errors", "duplicate");
			}
			return "redirect:/categories/new";
		}
	}
	
	@GetMapping("/categories/{catId}")
	public String getCategoryPage(
			@PathVariable Long catId,
			Model model
			) {
		Category cat = cServ.retrieveOne(catId);
		model.addAttribute("category", cat);
		model.addAttribute("unProducts", pServ.doesNotBelong(cat));
		return "category.jsp";
	}
	
	@PostMapping("/categories/{catId}")
	public String addToProduct(
			@PathVariable Long catId,
			@RequestParam Long prodId
			) {
		cServ.addRelationship(catId, prodId);
		return "redirect:/categories/"+catId;
	}
}
