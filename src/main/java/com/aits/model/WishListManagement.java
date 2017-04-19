package com.aits.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "WishList")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "wishListId", scope = WishListManagement.class)
public class WishListManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WishList_Id")
	private int wishListId;

	@Column(name = "Is_Active", length = 2)
	private String isActive;

	@OneToOne(targetEntity = SubProductMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_SubProductId")
	private SubProductMaster subProductMaster;

	@ManyToOne(targetEntity = EndUserDetails.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_EndUserId")
	private EndUserDetails endUserDetails;

	@Transient
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
