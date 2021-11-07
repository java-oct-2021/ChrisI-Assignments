package com.javafun.productscats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javafun.productscats.models.Product;
import com.javafun.productscats.services.CategoryService;
import com.javafun.productscats.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService pServ;
	@Autowired
	CategoryService cServ;
	
	@GetMapping("/products/new")
	public String createProductPage(@ModelAttribute Product product) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@ModelAttribute Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		} else {
			pServ.add(product);
			return "redirect:/products/new";
		}
	}
	
	@GetMapping("/products/{prodId}")
	public String getProductPage(
			@PathVariable Long prodId,
			Model model
			) {
		Product prod = pServ.retrieveOne(prodId);
		model.addAttribute("product", prod);
		model.addAttribute("unCategories", cServ.doesNotBelong(prod));
//		System.out.println(pServ.doesNotBelong(prod.getCategories().get(0)));
//		pServ.test1();
		return "product.jsp";
	}
	
	@PostMapping("/products/{prodId}")
	public String addToCategory(
			@PathVariable Long prodId,
			@RequestParam Long catId
			) {
		pServ.addRelationship(catId, prodId);
		return "redirect:/products/"+prodId;
	}
	
}
