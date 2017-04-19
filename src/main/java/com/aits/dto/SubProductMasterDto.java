package com.aits.dto;

import java.util.List;
import java.util.Set;
import com.aits.model.CartDetails;
import com.aits.model.ImageMaster;
import com.aits.model.ProductMaster;
import com.aits.model.SubProductMaster;
import com.aits.model.SubProductMasterDiscountMapper;
import com.aits.model.WishListManagement;

public class SubProductMasterDto {
	private int subProductId;
	private String subProductName;
	private String subProductColor;
	private double subProductWeigth;
	private int subProductQuantity;
	private double subProductPrice;
	private String isActive;
	private ProductMaster productMaster;
	private Set<ImageMaster> imageMasterSet;
	private Set<SubProductMasterDiscountMapper> subProductMasterDiscountMapperSet;
	private CartDetails cartDetails;
	private WishListManagement wishListManagement;
	private List<SubProductMaster> subProductMasterList;

	public int getSubProductId() {
		return subProductId;
	}

	public void setSubProductId(int subProductId) {
		this.subProductId = subProductId;
	}

	public String getSubProductName() {
		return subProductName;
	}

	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}

	public String getSubProductColor() {
		return subProductColor;
	}

	public void setSubProductColor(String subProductColor) {
		this.subProductColor = subProductColor;
	}

	public double getSubProductWeigth() {
		return subProductWeigth;
	}

	public void setSubProductWeigth(double subProductWeigth) {
		this.subProductWeigth = subProductWeigth;
	}

	public int getSubProductQuantity() {
		return subProductQuantity;
	}

	public void setSubProductQuantity(int subProductQuantity) {
		this.subProductQuantity = subProductQuantity;
	}

	public double getSubProductPrice() {
		return subProductPrice;
	}

	public void setSubProductPrice(double subProductPrice) {
		this.subProductPrice = subProductPrice;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public ProductMaster getProductMaster() {
		return productMaster;
	}

	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}

	public Set<ImageMaster> getImageMasterSet() {
		return imageMasterSet;
	}

	public void setImageMasterSet(Set<ImageMaster> imageMasterSet) {
		this.imageMasterSet = imageMasterSet;
	}

	public Set<SubProductMasterDiscountMapper> getSubProductMasterDiscountMapperSet() {
		return subProductMasterDiscountMapperSet;
	}

	public void setSubProductMasterDiscountMapperSet(
			Set<SubProductMasterDiscountMapper> subProductMasterDiscountMapperSet) {
		this.subProductMasterDiscountMapperSet = subProductMasterDiscountMapperSet;
	}

	public CartDetails getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(CartDetails cartDetails) {
		this.cartDetails = cartDetails;
	}

	public WishListManagement getWishListManagement() {
		return wishListManagement;
	}

	public void setWishListManagement(WishListManagement wishListManagement) {
		this.wishListManagement = wishListManagement;
	}

	public List<SubProductMaster> getSubProductMasterList() {
		return subProductMasterList;
	}

	public void setSubProductMasterList(List<SubProductMaster> subProductMasterList) {
		this.subProductMasterList = subProductMasterList;
	}

}
