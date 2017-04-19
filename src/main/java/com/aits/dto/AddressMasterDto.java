package com.aits.dto;

import java.util.List;
import com.aits.model.AddressMaster;
import com.aits.model.EndUserDetails;
import com.aits.model.PincodeMaster;

public class AddressMasterDto {
	private int addressId;
	private String addressLine1;
	private String addressLine2;
	private String isActive;

	private PincodeMaster pincodeMaster;
	private EndUserDetails endUserDetails;
	private List<AddressMaster> addressMasterList;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public PincodeMaster getPincodeMaster() {
		return pincodeMaster;
	}

	public void setPincodeMaster(PincodeMaster pincodeMaster) {
		this.pincodeMaster = pincodeMaster;
	}

	public EndUserDetails getEndUserDetails() {
		return endUserDetails;
	}

	public void setEndUserDetails(EndUserDetails endUserDetails) {
		this.endUserDetails = endUserDetails;
	}

	public List<AddressMaster> getAddressMasterList() {
		return addressMasterList;
	}

	public void setAddressMasterList(List<AddressMaster> addressMasterList) {
		this.addressMasterList = addressMasterList;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
