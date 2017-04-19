package com.aits.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="State_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "stateId", scope = StateMaster.class)
public class StateMaster {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "State_Id")
	private int stateId;
	
	@Column(name = "State_Name",length=32)
	private String stateName;
	
	@Column(name = "Is_Active", length = 2)
	private String isActive;
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	//Bidirectional RelationShip
	@OneToMany(targetEntity=CityMaster.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="stateMaster",fetch=FetchType.EAGER)
    private Set<CityMaster> cityMasterSet;
	
	@Transient
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
	  
}
