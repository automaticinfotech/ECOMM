package com.aits.dto;

import java.util.List;
import com.aits.model.CityMaster;
import com.aits.model.PincodeMaster;

public class PincodeMasterDto {
	private int pincodeId;
	private int pincode;
	private String isActive;
	private CityMaster cityMaster;
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

	public List<PincodeMaster> getPincodeMasterList() {
		return pincodeMasterList;
	}

	public void setPincodeMasterList(List<PincodeMaster> pincodeMasterList) {
		this.pincodeMasterList = pincodeMasterList;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
