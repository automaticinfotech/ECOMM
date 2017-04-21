package com.aits.constant;

public interface AppConstant {

	String ADMIN_LOGIN_AUTHENTICATION = "/adminLoginAuthentication";
	String ADMIN_SIGN_OUT = "/adminSignOut";
	String USER_LOGIN = "/userLogin";
	String URI = "http://localhost:8080/ECOMM-WS/";
	

	String ROOT = "/";
	String HOME = "/home";
	String HELLO = "/Hello";
	String LIST_PRODUCT = "/listProduct";
	String GET_PRODUCT_BY_ID = "/getProductById";
	
	
	/*Product Mgmt*/
	String GET_CATEGORY_MASTER_LIST = "/getCategoryMasterList";
	String INSERT_CATEGORY_MASTER = "/insertCategoryMaster";
	String GET_CATEGORY_MASTER_INFORMATION_BY_ID = "/getCategoryMasterInformationById/{categoryMasterId}";
	String GET_CATEGORY_MASTER_INFORMATION_BY_CATEGORY_ID = "/getCategoryMasterInformationById/"; 
	String UPDATE_CATEGORY_MASTER = "/updateCategoryMaster";
	String UPDATE_CATEGORY_STATUS = "/updateCategoryStatus";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*   added by  santosh  12/04/2017 */		
	String AdminStates="/adminStates";
	String SAVE_STATE="/saveState";
	String ADMIN_INACTIVE_STATE="/inactiveState";
	String ADMIN_ACTIVE_STATE="/activeState";
	String ADMIN_EDIT_STATE="/editState";
	String SAVE_CITY="/saveCity";
	String ADMIN_CITYS="adminAllCitys";

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Discount Mgmt*/
	String GET_DISCOUNT_LIST="/getDiscountMasterList";
	String ADD_DISCOUNT="/addDiscountMasterInformation";
	String UPDATE_DISCOUNT="/updateDiscountMasterInformation";
	String GET_DISCOUNT_INFO_BY_ID="/getDiscountMasterInformationById/";
	String GET_DISCOUNT_MAPPER_LIST="/getSubProductDiscountMapperList";
	String GET_SUB_PRODUCT_LIST="/getSubProductMasterList";
	String ADD_DISCOUNT_MAPPER_INFO="/insertSubProductDiscountMapperInformation";
	
	

	
	
	
	
	
	
	
	
	
}



