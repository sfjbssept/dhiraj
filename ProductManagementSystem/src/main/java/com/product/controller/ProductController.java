package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.product.entity.Product;
import com.product.service.IProductService;
import com.product.service.ProductServiceImpl;
import java.util.*;
@RestController
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@PostMapping("/addProduct")
      Integer addProduct(@RequestBody Product product) {
		Integer id=productService.addProduct(product);
		System.out.println("iD---"+id);
		return id;
	}	
	
	@GetMapping("/allProducts")
    List<Product> getProducts() {
		return productService.getAllProducts();
	}	


	@GetMapping("/product/{id}")
    Optional<Product> getProductById(@PathVariable Integer id) {
		return productService.getProduct(id);
	}	

	
	@PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
		System.out.println(id);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			productService.deleteProduct(id);

		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return responseEntity;
	}

	@DeleteMapping("/deleteAllProducts")
	public ResponseEntity<Product> deleteProduct() {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			productService.deleteAllProduct();

		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return responseEntity;
	}

}
