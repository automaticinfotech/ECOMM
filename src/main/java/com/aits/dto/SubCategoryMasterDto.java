package com.aits.dto;

import java.util.List;
import java.util.Set;
import com.aits.model.CategoryMaster;
import com.aits.model.ProductMaster;
import com.aits.model.SubCategoryMaster;

public class SubCategoryMasterDto {
private int subCategoryMasterId;
	private String subCategoryMasterName;
	private String isActive;
	private CategoryMaster categoryMaster;
	//private Set<ProductMaster> productMasterSet;
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
	}*/
	public List<SubCategoryMaster> getSubCategoryMasterList() {
		return subCategoryMasterList;
	}
	public void setSubCategoryMasterList(List<SubCategoryMaster> subCategoryMasterList) {
		this.subCategoryMasterList = subCategoryMasterList;
	}
	
	
}
