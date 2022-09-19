package com.product.service;

import com.product.entity.Product;
import java.util.*;

public interface IProductService {
	
Integer addProduct(Product product);

public  List<Product> getAllProducts();
	
 Optional<Product> getProduct(Integer id);
 
 Product updateProduct(Product product ,Integer id);
 public void deleteProduct(Integer id);
 
 public void deleteAllProduct();

}
