package com.aits.dto;

import java.util.List;
import java.util.Set;
import com.aits.model.CategoryMaster;
import com.aits.model.SubCategoryMaster;

public class CategoryMasterDto {
	private int categoryMasterId;
	private String categoryMasterName;
	private String isActive;
	private Set<SubCategoryMaster> subCategoryMasterSet;
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
