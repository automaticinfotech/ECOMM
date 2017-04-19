package com.aits.dto;

import java.util.Date;
import java.util.List;
import com.aits.model.DiscountMaster;
import com.aits.model.SubProductMaster;
import com.aits.model.SubProductMasterDiscountMapper;

public class SubProductMasterDiscountMapperDto {
	private int subProductMasterDiscountMapperId;
	private Date subProductMasterDiscountMapperFromDate;
	private Date subProductMasterDiscountMapperToDate;
	private SubProductMaster subProductMaster;
	private DiscountMaster discountMaster;
	private List<SubProductMasterDiscountMapper> subProductMasterDiscountMapperList;
	private String isActive;
	
	public int getSubProductMasterDiscountMapperId() {
		return subProductMasterDiscountMapperId;
	}
	public void setSubProductMasterDiscountMapperId(int subProductMasterDiscountMapperId) {
		this.subProductMasterDiscountMapperId = subProductMasterDiscountMapperId;
	}
	public Date getSubProductMasterDiscountMapperFromDate() {
		return subProductMasterDiscountMapperFromDate;
	}
	public void setSubProductMasterDiscountMapperFromDate(Date subProductMasterDiscountMapperFromDate) {
		this.subProductMasterDiscountMapperFromDate = subProductMasterDiscountMapperFromDate;
	}
	public Date getSubProductMasterDiscountMapperToDate() {
		return subProductMasterDiscountMapperToDate;
	}
	public void setSubProductMasterDiscountMapperToDate(Date subProductMasterDiscountMapperToDate) {
		this.subProductMasterDiscountMapperToDate = subProductMasterDiscountMapperToDate;
	}
	public SubProductMaster getSubProductMaster() {
		return subProductMaster;
	}
	public void setSubProductMaster(SubProductMaster subProductMaster) {
		this.subProductMaster = subProductMaster;
	}
	public DiscountMaster getDiscountMaster() {
		return discountMaster;
	}
	public void setDiscountMaster(DiscountMaster discountMaster) {
		this.discountMaster = discountMaster;
	}
	public List<SubProductMasterDiscountMapper> getSubProductMasterDiscountMapperList() {
		return subProductMasterDiscountMapperList;
	}
	public void setSubProductMasterDiscountMapperList(
			List<SubProductMasterDiscountMapper> subProductMasterDiscountMapperList) {
		this.subProductMasterDiscountMapperList = subProductMasterDiscountMapperList;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
}
