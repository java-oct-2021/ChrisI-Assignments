package com.javafun.productscats.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafun.productscats.models.Category;
import com.javafun.productscats.models.Product;
import com.javafun.productscats.repositories.CategoryRepository;
import com.javafun.productscats.repositories.ProductRepository;

@Service
public class JoinService {
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private ProductRepository productRepo;
	public void addRelationship(Long catId, Long prodId) {
		Optional<Category> optCat = this.catRepo.findById(catId);
		Optional<Product> optProd = this.productRepo.findById(prodId);
		
		if(optCat.isPresent() && optProd.isPresent()) {
			Category thisCat = optCat.get();
			Product thisProd = optProd.get();
//			System.out.println("adding "+thisCat.getName()+thisProd.getName());
			thisCat.getProducts().add(thisProd);
			catRepo.save(thisCat);
		} else {
			System.out.println("nothing added");
		}
	}
}
