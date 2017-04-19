package com.aits.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "SubProductMaster_DiscountMapper")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="subProductMasterDiscountMapperId",scope = SubProductMasterDiscountMapper.class)
public class SubProductMasterDiscountMapper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SubProductMasterDiscountMapper_Id")
	private int subProductMasterDiscountMapperId;

	@Column(name = "SubProductMasterDiscountMapper_FromDate", length = 50)
	private Date subProductMasterDiscountMapperFromDate;

	@Column(name = "SubProductMasterDiscountMapper_ToDate", length = 50)
	private Date subProductMasterDiscountMapperToDate;
	
	@Column(name="Is_Active",length=2)
	private String isActive;

	@ManyToOne(targetEntity = SubProductMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_SubProductId")
	private SubProductMaster subProductMaster;

	@ManyToOne(targetEntity = DiscountMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "Fk_DiscountMasterId")
	private DiscountMaster discountMaster;

	@Transient
	private List<SubProductMasterDiscountMapper> subProductMasterDiscountMapperList;

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
