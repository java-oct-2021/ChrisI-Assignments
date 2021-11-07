package com.javafun.productscats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafun.productscats.models.Category;
import com.javafun.productscats.models.Product;
import com.javafun.productscats.repositories.CategoryRepository;

@Service
public class CategoryService extends JoinService {
	@Autowired
	private CategoryRepository catRepo;
	
	public Category add(Category category) {
		return this.catRepo.save(category);
	}
	
	public Category retrieveOne(Long id) {
		Optional<Category> cat = this.catRepo.findById(id);
		if(cat.isPresent()) {
			return cat.get();
		} else {
			return null;
		}
	}
	public List<Category> doesNotBelong(Product product) {
		return this.catRepo.findByProductsNotContains(product);
	}
}
