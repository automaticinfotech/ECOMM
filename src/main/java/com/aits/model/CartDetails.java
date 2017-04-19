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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "CartDetails")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "cartDetailsId", scope = CartDetails.class)
public class CartDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CartDetails_Id")
	private int cartDetailsId;

	@Column(name = "Quantity", length = 2)
	private int quantity;

	@Column(name = "Is_Active", length = 2)
	private String isActive;

	@ManyToOne(targetEntity = EndUserDetails.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_EndUserId")
	private EndUserDetails endUserDetails;

	/*
	 * This is one to many relationship but instead of making new table I
	 * created it through one to one only and removed unique constraint in join
	 * coloumn
	 */
	@OneToOne(targetEntity = SubProductMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_SubProductId")
	private SubProductMaster subProductMaster;

	@Transient
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
