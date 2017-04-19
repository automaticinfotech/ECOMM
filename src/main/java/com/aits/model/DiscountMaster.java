package com.aits.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Discount_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="discountMasterId",scope = DiscountMaster.class)
public class DiscountMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Discount_Id")
	private int discountMasterId;

	@Column(name = "Discount_Name", length = 50)
	private String dicountMasterName;

	// Bidirectional relationship with SubProductMasterDiscountMapper
	@JsonBackReference
	@OneToMany(targetEntity = SubProductMasterDiscountMapper.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "discountMaster")
	private Set<SubProductMasterDiscountMapper> subProductMasterDiscountMapperSet;

	@Transient
	private List<DiscountMaster> discountMasterList;

	public int getDiscountMasterId() {
		return discountMasterId;
	}

	public void setDiscountMasterId(int discountMasterId) {
		this.discountMasterId = discountMasterId;
	}

	public String getDicountMasterName() {
		return dicountMasterName;
	}

	public void setDicountMasterName(String dicountMasterName) {
		this.dicountMasterName = dicountMasterName;
	}

	public Set<SubProductMasterDiscountMapper> getSubProductMasterDiscountMapperSet() {
		return subProductMasterDiscountMapperSet;
	}

	public void setSubProductMasterDiscountMapperSet(
			Set<SubProductMasterDiscountMapper> subProductMasterDiscountMapperSet) {
		this.subProductMasterDiscountMapperSet = subProductMasterDiscountMapperSet;
	}

	public List<DiscountMaster> getDiscountMasterList() {
		return discountMasterList;
	}

	public void setDiscountMasterList(List<DiscountMaster> discountMasterList) {
		this.discountMasterList = discountMasterList;
	}

}
