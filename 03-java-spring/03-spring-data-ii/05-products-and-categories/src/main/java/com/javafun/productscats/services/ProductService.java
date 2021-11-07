package com.javafun.productscats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafun.productscats.models.Category;
import com.javafun.productscats.models.Product;
import com.javafun.productscats.repositories.ProductRepository;

@Service
public class ProductService extends JoinService{
	@Autowired
	private ProductRepository productRepo;
	
	public Product add(Product product) {
		return this.productRepo.save(product);
	}
	
	public Product retrieveOne(Long id) {
		Optional<Product> prod = this.productRepo.findById(id);
		if(prod.isPresent()) {
			return prod.get();
		} else {
			return null;
		}
	}
	public List<Product> doesNotBelong(Category category) {
		return this.productRepo.findByCategoriesNotContains(category);
	}
}
