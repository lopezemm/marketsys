package com.marketsys.sales.controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketsys.sales.model.SalesModel;
import com.marketsys.sales.model.SalesWrapper;
import com.marketsys.sales.repo.SalesRepo;
import com.marketsys.mapper.UtilMapper;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SalesController {
		
	private int x;
	@Autowired
	SalesRepo saleRepo;
	
	//Create transaction
	@RequestMapping(method = RequestMethod.POST, value = "/addTransaction")	
	public String getSaleTransaction(@RequestBody SalesWrapper saleTransactions) {
		try {
			
			x = saleRepo.getMaxTransactionId() + 1;			
			List<SalesModel> sales= saleTransactions.getSalesWrapper();
			//Lambda expression to add transaction id and data
			sales.forEach(s -> {s.setTransactionid(x); s.setDate(new UtilMapper().getDate());});		
			System.out.println(sales);
			saleRepo.saveAll(sales);
			return "{\"message\":\"ok\"}";
		}catch(PersistenceException e) {
			//Have to send message for each error
			return "{\"myError\":\"fatal error 500\"}";
			//return ("Error in save method " + e);
		}
	}

}
