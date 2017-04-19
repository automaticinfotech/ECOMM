package com.aits.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;
import com.aits.model.AddressMaster;
import com.aits.model.CartDetails;
import com.aits.model.EndUserDetails;
import com.aits.model.UserMaster;
import com.aits.model.WishListManagement;


public class EndUserDetailsDto {
	private int endUserId;
	private String userFirstName;
	private String userLastName;
	private String userGender;
	private Long userMobileNumber;
	private String userEmailId;
	private Date userDateOfBirth;
	private int userAge;
	private String userPassword;
	private int OneTimePassword;
	private String isActive;

	private AddressMaster addressMaster;
	private UserMaster userMaster;
	private Set<CartDetails> cartDetailSet;
    private Set<WishListManagement> wishListManagementSet;
	private List<EndUserDetails> endUserDetailList;
	public int getEndUserId() {
		return endUserId;
	}
	public void setEndUserId(int endUserId) {
		this.endUserId = endUserId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public Date getUserDateOfBirth() {
		return userDateOfBirth;
	}
	public void setUserDateOfBirth(Date userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getOneTimePassword() {
		return OneTimePassword;
	}
	public void setOneTimePassword(int oneTimePassword) {
		OneTimePassword = oneTimePassword;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public AddressMaster getAddressMaster() {
		return addressMaster;
	}
	public void setAddressMaster(AddressMaster addressMaster) {
		this.addressMaster = addressMaster;
	}
	public UserMaster getUserMaster() {
		return userMaster;
	}
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}
	public Set<CartDetails> getCartDetailSet() {
		return cartDetailSet;
	}
	public void setCartDetailSet(Set<CartDetails> cartDetailSet) {
		this.cartDetailSet = cartDetailSet;
	}
	public Set<WishListManagement> getWishListManagementSet() {
		return wishListManagementSet;
	}
	public void setWishListManagementSet(Set<WishListManagement> wishListManagementSet) {
		this.wishListManagementSet = wishListManagementSet;
	}
	public List<EndUserDetails> getEndUserDetailList() {
		return endUserDetailList;
	}
	public void setEndUserDetailList(List<EndUserDetails> endUserDetailList) {
		this.endUserDetailList = endUserDetailList;
	}

}
