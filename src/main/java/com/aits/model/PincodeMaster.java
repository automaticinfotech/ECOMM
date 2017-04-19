package com.aits.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Pincode_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "pincodeId", scope = PincodeMaster.class)
public class PincodeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pincode_Id")
	private int pincodeId;

	@Column(name = "Pincode", length = 6)
	private int pincode;

	@Column(name = "Is_Active", length = 2)
	private String isActive;
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@ManyToOne(targetEntity = CityMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE },fetch=FetchType.EAGER)
	@JoinColumn(name = "Fk_City_Id")
	private CityMaster cityMaster;
	
	//Bidirectional RelationShip
	@OneToOne(targetEntity = AddressMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE },mappedBy="pincodeMaster")
	private AddressMaster addressMaster;

	@Transient
	private List<PincodeMaster> pincodeMasterList;

	public int getPincodeId() {
		return pincodeId;
	}

	public void setPincodeId(int pincodeId) {
		this.pincodeId = pincodeId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public CityMaster getCityMaster() {
		return cityMaster;
	}

	public void setCityMaster(CityMaster cityMaster) {
		this.cityMaster = cityMaster;
	}

	public AddressMaster getAddressMaster() {
		return addressMaster;
	}

	public void setAddressMaster(AddressMaster addressMaster) {
		this.addressMaster = addressMaster;
	}

	public List<PincodeMaster> getPincodeMasterList() {
		return pincodeMasterList;
	}

	public void setPincodeMasterList(List<PincodeMaster> pincodeMasterList) {
		this.pincodeMasterList = pincodeMasterList;
	}

}
