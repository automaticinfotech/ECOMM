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
	
	/*   added by  santosh  12/04/2017 */	
	
	
	
	String AdminStates="/adminStates";
	String SAVE_STATE="/saveState";
	String ADMIN_DELETE_STATE="/deleteState";
	String ADMIN_EDIT_STATE="/editState";
	
	String SAVE_CITY="/saveCity";
	

}
