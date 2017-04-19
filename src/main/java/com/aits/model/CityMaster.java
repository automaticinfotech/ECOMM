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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="City_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "cityId", scope = CityMaster.class)
public class CityMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "City_Id")
	private int cityId;
	
	@Column(name = "City_Name",length=32)
	private String cityName;
	
	
	@ManyToOne(targetEntity = StateMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE },fetch=FetchType.EAGER)
	@JoinColumn(name = "Fk_State_Id")
	private StateMaster stateMaster;
	
	@Column(name = "Is_Active", length = 2)
	private String isActive;
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	//Bidirectional Relationship
	@OneToMany(targetEntity=PincodeMaster.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="cityMaster",fetch=FetchType.EAGER)
	private Set<PincodeMaster> pincodeMasterSet;
	
	@Transient
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
    
}
