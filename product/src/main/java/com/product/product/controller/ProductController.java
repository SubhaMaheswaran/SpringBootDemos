package com.product.product.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.product.product.model.Product;
import com.product.product.service.ProductServiceImpl;

@RestController("/productapp")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping("/getallproduct")
	public List<Product> getAlProduct() {
		return productServiceImpl.getAllProduct();

	}

	@GetMapping("/getproducts/{productName}")
	public Product getProduct(@PathVariable("productName") String productName) {
		return productServiceImpl.getProductList(productName);

	}

	@PostMapping("/buyproduct/{productId}/{userId}")
	public ResponseEntity<String> buyProduct(@PathVariable("productId") int productId,
			@PathVariable("userId") int userId) {
		return productServiceImpl.buyProduct(productId, userId);

	}

	@GetMapping(value = "numofproducts/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getnumOfProduct(@PathVariable("userId") int userId) throws JSONException {
		return productServiceImpl.numOfProduct(userId);

	}

}
