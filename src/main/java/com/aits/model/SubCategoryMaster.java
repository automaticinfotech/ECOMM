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
@Table(name="SubCategory_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="subCategoryMasterId",scope = SubCategoryMaster.class)
public class SubCategoryMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SubCategoryMaster_Id")
	private int subCategoryMasterId;
	
	@Column(name = "SubCategoryMaster_Name",length=100)
	private String subCategoryMasterName;
	
	@Column(name="Is_Active",length=2)
	private String isActive;
	
	@ManyToOne(targetEntity = CategoryMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_CategoryMasterId")
	private CategoryMaster categoryMaster;
	
	//BiDirectional Relationship with ProductMaster
	@OneToMany(targetEntity = ProductMaster.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="subCategoryMaster")
	private Set<ProductMaster> productMasterSet;
	
	@Transient
	private List<SubCategoryMaster> subCategoryMasterList;

	public int getSubCategoryMasterId() {
		return subCategoryMasterId;
	}

	public void setSubCategoryMasterId(int subCategoryMasterId) {
		this.subCategoryMasterId = subCategoryMasterId;
	}

	public String getSubCategoryMasterName() {
		return subCategoryMasterName;
	}

	public void setSubCategoryMasterName(String subCategoryMasterName) {
		this.subCategoryMasterName = subCategoryMasterName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public CategoryMaster getCategoryMaster() {
		return categoryMaster;
	}

	public void setCategoryMaster(CategoryMaster categoryMaster) {
		this.categoryMaster = categoryMaster;
	}

	/*public Set<ProductMaster> getProductMasterSet() {
		return productMasterSet;
	}

	public void setProductMasterSet(Set<ProductMaster> productMasterSet) {
		this.productMasterSet = productMasterSet;
	}
*/
	public List<SubCategoryMaster> getSubCategoryMasterList() {
		return subCategoryMasterList;
	}

	public void setSubCategoryMasterList(List<SubCategoryMaster> subCategoryMasterList) {
		this.subCategoryMasterList = subCategoryMasterList;
	}

}
