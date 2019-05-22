package com.product.product.service;

import java.util.ArrayList;




import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.product.product.model.Product;
import com.product.product.model.UserProduct;
import com.product.product.repository.ProductRepository;
import com.product.product.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@Mock
	ProductRepository productRepository;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	static List<Product> expectval1 = null;

	ResponseEntity<String> expectedvalue3 = new ResponseEntity<String>("successfully purchased", HttpStatus.OK);
	Product product2 = new Product("abc", 120, 5, "fgcsf");

	@BeforeClass
	public static void setUp() {
		expectval1 = new ArrayList<Product>();
		Product product1 = new Product("abc", 120, 5, "fgcsf");
		product1.setProductId(1);
		expectval1.add(product1);

		UserProduct userProduct = new UserProduct(1, 5);
	}

	@Test
	public void testGetAllProduct() {
		Mockito.when(productRepository.findAll()).thenReturn(expectval1);
		List<Product> actval1 = productServiceImpl.getAllProduct();
		Assert.assertEquals(expectval1.size(), actval1.size());
	}

	@Test
	public void testGetProductList() {

		Mockito.when(productRepository.findByProductName("abc")).thenReturn(product2);

		Product actval2 = productServiceImpl.getProductList("abc");
		Assert.assertEquals(product2, actval2);
	}

}
