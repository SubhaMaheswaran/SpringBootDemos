package com.product.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.product.model.UserProduct;

public interface UserRepository extends JpaRepository<UserProduct, Integer> {

	@Query(value = "select count(user_id) from user_product where user_id = ?1 group by user_id", nativeQuery = true)
	List<String> findnumberOfProduct(int userId);

}
