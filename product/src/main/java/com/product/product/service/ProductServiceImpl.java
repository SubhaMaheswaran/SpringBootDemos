package com.product.product.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.product.model.Product;
import com.product.product.model.UserProduct;
import com.product.product.repository.ProductRepository;
import com.product.product.repository.UserRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Product> getAllProduct() {
		Product product1 = new Product("abc", 120, 5, "fgcsf");
		Product product2 = new Product("def", 160, 6, "fgsf");
		Product product3 = new Product("xyz", 190, 8, "fgsf");
		Product product4 = new Product("nvb", 140, 4, "fgcf");
		Product product5 = new Product("jsh", 180, 9, "gcsf");

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
		productRepository.save(product5);

		return productRepository.findAll();
	}

	@Override
	public Product getProductList(String productName) {
		return productRepository.findByProductName(productName);
	}

	@Override
	public ResponseEntity<String> buyProduct(int productId, int userId) {
		UserProduct userProduct = new UserProduct(productId, userId);
		userRepository.save(userProduct);

		return new ResponseEntity<String>("successfully purchased", HttpStatus.OK);
	}

	@Override
	public String numOfProduct(int userId) throws JSONException{
		List<String> list = userRepository.findnumberOfProduct(userId) ;
		String numOfProduct = "";
		
		JSONObject json = new JSONObject();
		for (String string : list) {
			String[] values = string.split(",");
			numOfProduct =values[0];
		}
		json.put("numOfProduct", numOfProduct);
		return json.toString();
	}

}
