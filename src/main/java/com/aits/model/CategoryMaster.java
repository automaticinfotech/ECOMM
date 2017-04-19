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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Category_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="categoryMasterId",scope = CategoryMaster.class)
public class CategoryMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CategoryMaster_Id")
	private int categoryMasterId;
	
	@Column(name="CategoryMaster_Name",length=80)
	private String categoryMasterName;
	
	@Column(name="Is_Active",length=2)
	private String isActive;
	
	//BiDirectional Relationship with SubCategoryMaster
	@OneToMany(targetEntity=SubCategoryMaster.class,cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE },mappedBy="categoryMaster")
	private Set<SubCategoryMaster> subCategoryMasterSet;
	
	@Transient
	private List<CategoryMaster> categoryMasterList;

	public int getCategoryMasterId() {
		return categoryMasterId;
	}

	public void setCategoryMasterId(int categoryMasterId) {
		this.categoryMasterId = categoryMasterId;
	}

	public String getCategoryMasterName() {
		return categoryMasterName;
	}

	public void setCategoryMasterName(String categoryMasterName) {
		this.categoryMasterName = categoryMasterName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Set<SubCategoryMaster> getSubCategoryMasterSet() {
		return subCategoryMasterSet;
	}

	public void setSubCategoryMasterSet(Set<SubCategoryMaster> subCategoryMasterSet) {
		this.subCategoryMasterSet = subCategoryMasterSet;
	}

	public List<CategoryMaster> getCategoryMasterList() {
		return categoryMasterList;
	}

	public void setCategoryMasterList(List<CategoryMaster> categoryMasterList) {
		this.categoryMasterList = categoryMasterList;
	}

}
