package com.aits.dto;

import java.util.List;
import com.aits.model.EndUserDetails;
import com.aits.model.SubProductMaster;
import com.aits.model.WishListManagement;

public class WishListManagementDto {
	private int wishListId;
	private String isActive;
	private SubProductMaster subProductMaster;
	private EndUserDetails endUserDetails;
	private List<WishListManagement> wishListManagementList;

	public int getWishListId() {
		return wishListId;
	}

	public void setWishListId(int wishListId) {
		this.wishListId = wishListId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public SubProductMaster getSubProductMaster() {
		return subProductMaster;
	}

	public void setSubProductMaster(SubProductMaster subProductMaster) {
		this.subProductMaster = subProductMaster;
	}

	public EndUserDetails getEndUserDetails() {
		return endUserDetails;
	}

	public void setEndUserDetails(EndUserDetails endUserDetails) {
		this.endUserDetails = endUserDetails;
	}

	public List<WishListManagement> getWishListManagementList() {
		return wishListManagementList;
	}

	public void setWishListManagementList(List<WishListManagement> wishListManagementList) {
		this.wishListManagementList = wishListManagementList;
	}

}
