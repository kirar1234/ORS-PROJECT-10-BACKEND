package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ShoppingDTO;

public class ShoppingForm extends BaseForm {

	@NotEmpty(message = "productname is required")
	private String productname;

	@NotEmpty(message = "productname is required")
	private String shopname;

	@NotEmpty(message = "productname is required")
	private String productprice;

	@NotNull(message = "shoppingdate is required")
	private Date shoppingdate;

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
	
	@Override
	public BaseDTO getDto() {
	 ShoppingDTO dto=initDTO(new ShoppingDTO());
	 
	 dto.setProductname(productname);
	 dto.setShopname(shopname);
	 dto.setProductprice(productprice);
	 dto.setShoppingdate(shoppingdate);
	return dto;
	}
	

}
