package com.javafun.productscats.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javafun.productscats.models.Category;
import com.javafun.productscats.models.Product;

public interface CategoryRepository extends CrudRepository<Category,Long>{
	List<Category> findAll();
//	List<Product> findAllByCategories(Category category);
	List<Category> findByProductsNotContains(Product product);
}
