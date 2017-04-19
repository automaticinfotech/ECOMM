package com.aits.dto;

import java.util.List;
import java.util.Set;
import com.aits.model.CityMaster;
import com.aits.model.StateMaster;

public class StateMasterDto {
	private int stateId;
	private String stateName;
	private String isActive;
	private Set<CityMaster> cityMasterSet;
	private List<StateMaster> stateMasterList;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Set<CityMaster> getCityMasterSet() {
		return cityMasterSet;
	}

	public void setCityMasterSet(Set<CityMaster> cityMasterSet) {
		this.cityMasterSet = cityMasterSet;
	}

	public List<StateMaster> getStateMasterList() {
		return stateMasterList;
	}

	public void setStateMasterList(List<StateMaster> stateMasterList) {
		this.stateMasterList = stateMasterList;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
