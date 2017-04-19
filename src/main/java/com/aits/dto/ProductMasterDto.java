package com.aits.dto;

import java.util.List;
import java.util.Set;
import com.aits.model.ProductMaster;
import com.aits.model.SubCategoryMaster;
import com.aits.model.SubProductMaster;

public class ProductMasterDto {
	private int productMasterId;
	private String productMasterName;
	private String isActive;
	private SubCategoryMaster subCategoryMaster;
	private Set<SubProductMaster> subProductMasterSet;
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
