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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Product_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="productMasterId",scope = ProductMaster.class)
public class ProductMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductMaster_Id")
	private int productMasterId;

	@Column(name = "ProductMaster_Name", length = 100)
	private String productMasterName;

	@Column(name = "Is_Active", length = 2)
	private String isActive;

	@ManyToOne(targetEntity = SubCategoryMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_SubCategoryMasterId")
	private SubCategoryMaster subCategoryMaster;

	// Bidirectional Relationship with SubProductMaster
	@OneToMany(targetEntity = SubProductMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "productMaster")
	private Set<SubProductMaster> subProductMasterSet;

	@Transient
	private List<ProductMaster> productMasterList;

	public int getProductMasterId() {
		return productMasterId;
	}

	public void setProductMasterId(int productMasterId) {
		this.productMasterId = productMasterId;
	}

	public String getProductMasterName() {
		return productMasterName;
	}

	public void setProductMasterName(String productMasterName) {
		this.productMasterName = productMasterName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public SubCategoryMaster getSubCategoryMaster() {
		return subCategoryMaster;
	}

	public void setSubCategoryMaster(SubCategoryMaster subCategoryMaster) {
		this.subCategoryMaster = subCategoryMaster;
	}

	public Set<SubProductMaster> getSubProductMasterSet() {
		return subProductMasterSet;
	}

	public void setSubProductMasterSet(Set<SubProductMaster> subProductMasterSet) {
		this.subProductMasterSet = subProductMasterSet;
	}

	public List<ProductMaster> getProductMasterList() {
		return productMasterList;
	}

	public void setProductMasterList(List<ProductMaster> productMasterList) {
		this.productMasterList = productMasterList;
	}

}
