package com.javafun.productscats.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javafun.productscats.models.Category;
import com.javafun.productscats.models.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
	List<Product> findAll();
//	List<Category> findAllByCategories(Product product);
	List<Product> findByCategoriesNotContains(Category item);
}
