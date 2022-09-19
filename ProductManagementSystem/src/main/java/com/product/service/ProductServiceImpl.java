package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Override
	public Integer addProduct(Product product) {
		// TODO Auto-generated method stub
		Product addProduct=productRepository.save(product);
		return addProduct.getId();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public Product updateProduct(Product product, Integer id) {
		// TODO Auto-generated method stub
		Product exsitingProduct=productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","id",id));
		exsitingProduct.setProductBrand(product.getProductBrand());
		exsitingProduct.setProductCategory(product.getProductCategory());
		exsitingProduct.setProductPrice(product.getProductPrice());
		
		productRepository.save(exsitingProduct);
		return exsitingProduct;
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllProduct() {
		// TODO Auto-generated method stub
		productRepository.deleteAll();
		
		
	}

	
}
