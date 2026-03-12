package com.rays.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_shopping")
public class ShoppingDTO extends BaseDTO   {

	private String productname;
	
	private String shopname;
	
	private String productprice;
	
	private Date shoppingdate;

	@Override
	public String getUniqueKey() {
		return"productname";
	}

	@Override
	public String getUniqueValue() {
		return productname;
	}

	@Override
	public String getLabel() {
		return"product name";
	}

	@Override
	public String getTableName() {
		return"Shopping";
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}

	public Date getShoppingdate() {
		return shoppingdate;
	}

	public void setShoppingdate(Date shoppingdate) {
		this.shoppingdate = shoppingdate;
	}
	
	
	
}
