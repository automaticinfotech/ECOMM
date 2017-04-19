package com.aits.dto;

import java.util.List;
import com.aits.model.CartDetails;
import com.aits.model.EndUserDetails;
import com.aits.model.SubProductMaster;

public class CartDetailsDto {
	private int cartDetailsId;
	private int quantity;
	private String isActive;
	private EndUserDetails endUserDetails;
	private SubProductMaster subProductMaster;
	private List<CartDetails> cartDetailList;

	public int getCartDetailsId() {
		return cartDetailsId;
	}

	public void setCartDetailsId(int cartDetailsId) {
		this.cartDetailsId = cartDetailsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public EndUserDetails getEndUserDetails() {
		return endUserDetails;
	}

	public void setEndUserDetails(EndUserDetails endUserDetails) {
		this.endUserDetails = endUserDetails;
	}

	public SubProductMaster getSubProductMaster() {
		return subProductMaster;
	}

	public void setSubProductMaster(SubProductMaster subProductMaster) {
		this.subProductMaster = subProductMaster;
	}

	public List<CartDetails> getCartDetailList() {
		return cartDetailList;
	}

	public void setCartDetailList(List<CartDetails> cartDetailList) {
		this.cartDetailList = cartDetailList;
	}

}
