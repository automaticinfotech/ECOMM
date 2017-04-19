package com.aits.dto;

import java.util.List;
import java.util.Set;
import com.aits.model.EndUserDetails;
import com.aits.model.UserMaster;

public class UserMasterDto {
	private int userMasterId;
	private String userType;
	private Set<EndUserDetails> endUserDetailSet;
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
