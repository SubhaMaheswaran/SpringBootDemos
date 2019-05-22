package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Product;
import com.hcl.service.ProductServiceImpl;

@RestController("/rest")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping("/getProductList")
	public List<Product> getProductList() {
		return productServiceImpl.getProductList();
	}

	@GetMapping("/getSearchProduct/{product}")
	public Product getSearchProduct(@PathVariable("product") String product) {
		return productServiceImpl.getSearchProduct(product);
	}

}
