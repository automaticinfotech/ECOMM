package com.aits.dto;

import java.util.List;
import java.util.Set;
import com.aits.model.CityMaster;
import com.aits.model.PincodeMaster;
import com.aits.model.StateMaster;
public class CityMasterDto {
	private int cityId;
	private String cityName;
	private String isActive;
	private StateMaster stateMaster;
	private Set<PincodeMaster> pincodeMasterSet;
	private List<CityMaster> cityMasterList;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public StateMaster getStateMaster() {
		return stateMaster;
	}

	public void setStateMaster(StateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}

	public Set<PincodeMaster> getPincodeMasterSet() {
		return pincodeMasterSet;
	}

	public void setPincodeMasterSet(Set<PincodeMaster> pincodeMasterSet) {
		this.pincodeMasterSet = pincodeMasterSet;
	}

	public List<CityMaster> getCityMasterList() {
		return cityMasterList;
	}

	public void setCityMasterList(List<CityMaster> cityMasterList) {
		this.cityMasterList = cityMasterList;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
