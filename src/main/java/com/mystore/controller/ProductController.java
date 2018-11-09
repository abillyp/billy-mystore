package com.mystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mystore.model.Product;
import com.mystore.repository.ProductRepository;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("/list")
	public List<Product> getProducts(){
		return productRepository.findAll();
	}

	@GetMapping("/by-id/{id}")
	public Product getProductById(@PathVariable Long id){
		return productRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/search")
	public List<Product> getById(@RequestParam String nameSearch) {
		List<Product> listProduct = productRepository.findByNameContaining(nameSearch);
		return listProduct;
	}	

}