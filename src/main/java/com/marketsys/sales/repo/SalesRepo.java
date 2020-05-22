package com.marketsys.sales.repo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.marketsys.sales.model.SalesModel;

public interface SalesRepo extends CrudRepository<SalesModel, Integer> {
	
	@Query(value = "SELECT COALESCE(MAX(transactionId), 0) FROM mymarket_db.record_sales", nativeQuery = true) 
	 public int getMaxTransactionId();

}
