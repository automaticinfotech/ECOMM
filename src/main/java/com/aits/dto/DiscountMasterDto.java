package com.aits.dto;

import java.util.List;
import java.util.Set;
import com.aits.model.DiscountMaster;
import com.aits.model.SubProductMasterDiscountMapper;

public class DiscountMasterDto {
	private int discountMasterId;
	private String dicountMasterName;
	private Set<SubProductMasterDiscountMapper> subProductMasterDiscountMapperSet;
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
