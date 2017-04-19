package com.aits.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "User_Master")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="userMasterId",scope = UserMaster.class)
public class UserMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Master_Id")
	private int userMasterId;

	@Column(name = "User_Type", length = 25)
	private String userType;

	@OneToMany(targetEntity = EndUserDetails.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "userMaster")
	private Set<EndUserDetails> endUserDetailSet;

	@Transient
	private List<UserMaster> userMasterList;

	public int getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(int userMasterId) {
		this.userMasterId = userMasterId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Set<EndUserDetails> getEndUserDetailSet() {
		return endUserDetailSet;
	}

	public void setEndUserDetailSet(Set<EndUserDetails> endUserDetailSet) {
		this.endUserDetailSet = endUserDetailSet;
	}

	public List<UserMaster> getUserMasterList() {
		return userMasterList;
	}

	public void setUserMasterList(List<UserMaster> userMasterList) {
		this.userMasterList = userMasterList;
	}

}
