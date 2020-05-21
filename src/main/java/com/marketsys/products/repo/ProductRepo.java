package com.marketsys.products.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.marketsys.products.model.ProductModel;

public interface ProductRepo extends CrudRepository<ProductModel, Integer> {
	
	 @Query(value = "SELECT * FROM mymarket_db.products t where t.product_code = :product_code", nativeQuery = true) 
	 public ProductModel findByProduct_code(@Param("product_code") String product_code);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "DELETE FROM mymarket_db.products t where t.product_code = :product_code", nativeQuery = true)
	 public void deleteProduct(String product_code);

	 @Query(value = "SELECT * FROM mymarket_db.products t where t.product_name like %:name%", nativeQuery = true) 
	 public ProductModel findByProduct_name(@Param("name") String name);
}
