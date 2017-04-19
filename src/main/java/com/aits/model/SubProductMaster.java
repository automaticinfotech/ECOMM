package com.aits.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "SubProduct_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="subProductId",scope = SubProductMaster.class)
public class SubProductMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Sub_Product_Id")
	private int subProductId;

	@Column(name = "Sub_Product_Name", length = 50)
	private String subProductName;

	@Column(name = "Sub_Product_Color", length = 20)
	private String subProductColor;

	@Column(name = "Sub_Product_Weight", length = 10)
	private double subProductWeigth;

	@Column(name = "Sub_Product_Quantity", length = 10)
	private int subProductQuantity;

	@Column(name = "Sub_Product_Price", length = 50)
	private double subProductPrice;

	@Column(name = "Is_Active", length = 2)
	private String isActive;

	@ManyToOne(targetEntity = ProductMaster.class, cascade =  CascadeType.ALL )
	@JoinColumn(name = "Fk_ProductMasterId")
	private ProductMaster productMaster;

	// Bidirectional Relationship
	@OneToMany(targetEntity = ImageMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE }, mappedBy = "subProductMaster")
	private Set<ImageMaster> imageMasterSet;

	// Bidirectional Relationship with SubProductMasterDiscountMapper
	@OneToMany(targetEntity = SubProductMasterDiscountMapper.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "subProductMaster")
	private Set<SubProductMasterDiscountMapper> subProductMasterDiscountMapperSet;

	// Bidirectional Relationship with CartDetails

	@OneToOne(targetEntity = CartDetails.class, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE }, mappedBy = "subProductMaster")
	private CartDetails cartDetails;

	// Bidirectional Relationship with CartDetails

	@OneToOne(targetEntity = WishListManagement.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "subProductMaster")
	private WishListManagement wishListManagement;

	@Transient
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
