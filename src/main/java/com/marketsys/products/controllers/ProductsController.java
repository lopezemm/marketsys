package com.marketsys.products.controllers;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketsys.mapper.UtilMapper;
import com.marketsys.products.model.ProductFromAng;
import com.marketsys.products.model.ProductModel;
import com.marketsys.products.repo.ProductRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductsController {
	
	@Autowired
	ProductRepo productRepo;
	@Autowired
	UtilMapper mapper;
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "hi";
	}
	//get product by product code
	@RequestMapping("/getProduct/{product_code}")
	public ProductModel getProduct(@PathVariable String product_code) {
		return productRepo.findByProduct_code(product_code);
	}
    //Add products
	@RequestMapping(method=RequestMethod.POST, value = "/addProduct")
	public String addProduct(@RequestBody ProductFromAng prodAng) {
		try {
			productRepo.save(mapper.mapToProductModel(prodAng));
			return "{\"message\":\"ok\"}";
		}catch(PersistenceException e) {
			//Have to send message for each error
			return "{\"myError\":\"fatal error 500\"}";
			//return ("Error in save method " + e);
		}
		 
	}		
	//Remove a product
	@RequestMapping(method=RequestMethod.POST, value = "/deleteProd/{product_code}")
	public String deleteProduct(@PathVariable String product_code) {
		try {
			productRepo.deleteProduct(product_code);
			return "{\"message\":\"ok\"}";
		}catch(PersistenceException e) {
			//Have to send message for each error
			return "{\"myError\":\"fatal error 500\"}";
			//return ("Error in save method " + e);
		}
	}
	//Retrieve product by name
	@RequestMapping("/searchProduct/{name}")
	public ProductModel getProdName(@PathVariable String name){
		try {
			return productRepo.findByProduct_name(name);
		}catch(PersistenceException e) {
			return null;
		}
	}
	
	//Update product
	@RequestMapping (method=RequestMethod.POST, value = "/updateProd")
	public String updateProd(@RequestBody ProductModel prodModel) {
		try {
			productRepo.save(prodModel);
			return "{\"message\":\"ok\"}";
		}catch(PersistenceException e) {
			//Have to send message for each error
			return "{\"myError\":\"fatal error 500\"}";
			//return ("Error in save method " + e);
		}
	}
}
