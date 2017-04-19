package com.aits.model;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "EndUser_Details")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "endUserId", scope = EndUserDetails.class)
public class EndUserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private int endUserId;

	@Column(name = "First_Name", length = 32)
	private String userFirstName;

	@Column(name = "Last_Name", length = 32)
	private String userLastName;

	@Column(name = "Gender", length = 3)
	private String userGender;

	@Column(name = "Mobile_Number", length = 10)
	private Long userMobileNumber;

	@Column(name = "Email_Id", length = 70)
	private String userEmailId;

	@Column(name = "Date_Of_Birth", length = 70)
	private Date userDateOfBirth;

	@Column(name = "Age", length = 3)
	private int userAge;

	@Column(name = "User_Password", length = 30)
	private String userPassword;

	@Column(name = "OneTime_Password", length = 30)
	private int OneTimePassword;

	@Column(name = "Is_Active", length = 2)
	private String isActive;

	@JsonManagedReference
	@OneToOne(targetEntity = AddressMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "Fk_addressId", unique = true)
	private AddressMaster addressMaster;

	// bidirectional RelationShip
	@ManyToOne(targetEntity = UserMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE })
	@JoinColumn(name = "Fk_User_MasterId")
	private UserMaster userMaster;

	// Bidirectional Relationship with CartDetails
	@OneToMany(targetEntity = CartDetails.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "endUserDetails")
	private Set<CartDetails> cartDetailSet;
	
	// Bidirectional Relationship with WishListManagement
		@OneToMany(targetEntity = WishListManagement.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
				CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "endUserDetails")
    private Set<WishListManagement> wishListManagementSet;

	@Transient
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
