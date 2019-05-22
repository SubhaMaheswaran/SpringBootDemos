package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Product;
import com.hcl.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductInterface {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProductList() {
		return productRepository.findAll();
	}

	public Product getSearchProduct(String product){
		return productRepository.getByName(product);
	}

}
