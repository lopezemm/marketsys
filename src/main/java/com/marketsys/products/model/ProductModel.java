package com.marketsys.products.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductModel {
	
	@Id
	private int id_product;
	private String product_code; 
	private String product_name;
	private double price;
	private int in_storage;
	private Date last_day_bougth;	
	private double sale_price;
	private String las_updated_date;	
	private String description;
	
	public String getLas_updated_date() {
		return las_updated_date;
	}
	public void setLas_updated_date(String las_updated_date) {
		this.las_updated_date = las_updated_date;
	}
	public Date getLast_day_bougth() {
		return last_day_bougth;
	}
	public void setLast_day_bougth(Date last_day_bougth) {
		this.last_day_bougth = last_day_bougth;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getIn_storage() {
		return in_storage;
	}
	public void setIn_storage(int in_storage) {
		this.in_storage = in_storage;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
