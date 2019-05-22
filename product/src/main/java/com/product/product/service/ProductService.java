package com.product.product.service;

import java.util.List;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.product.model.Product;

@Service
public interface ProductService {
	public List<Product> getAllProduct();
	public Product getProductList(String productName);
	public ResponseEntity<String> buyProduct(int productId,int userId);
	public String numOfProduct(int userId) throws JSONException;

}
