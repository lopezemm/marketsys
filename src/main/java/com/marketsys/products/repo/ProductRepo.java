package com.marketsys.products.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marketsys.products.model.ProductModel;

public interface ProductRepo extends CrudRepository<ProductModel, Integer> {
	
	 @Query(value = "SELECT * FROM mymarket_db.products t where t.product_code = :product_code", nativeQuery = true) 
	 public ProductModel findByProduct_code(@Param("product_code") String product_code);

}
