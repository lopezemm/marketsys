package com.marketsys.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.marketsys.products.model.ProductFromAng;
import com.marketsys.products.model.ProductModel;

@Component
public class UtilMapper {	
	
	public ProductModel mapToProductModel(ProductFromAng prodAng) {
		ProductModel prodModel = new ProductModel();
		prodModel.setProduct_code(prodAng.getCodigo());
		prodModel.setProduct_name(prodAng.getNombre());
		prodModel.setDescription(prodAng.getDesc());
		prodModel.setPrice(prodAng.getPrecio());
		prodModel.setSale_price(prodAng.getPrecioCom());
		prodModel.setLas_updated_date(getStringDate());
		prodModel.setLast_day_bougth(getDate());
		prodModel.setIn_storage(4);					
		return prodModel;
	}
	
	private String getStringDate () {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		String year  = Integer.toString(localDate.getYear());
		String month = (localDate.getMonthValue()<10)? "0" + Integer.toString(localDate.getMonthValue()): Integer.toString(localDate.getMonthValue());		
		String day   = (localDate.getDayOfMonth()<10)? "0" + Integer.toString(localDate.getDayOfMonth()): Integer.toString(localDate.getDayOfMonth());
		String last_update = year + "-" + month +"-"+day;				
		//LocalDate date1 = LocalDate.parse(x);
		return last_update;
	}
	
	private Date getDate() {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date today = Calendar.getInstance().getTime();        
		return today;
		
	}
	
}
