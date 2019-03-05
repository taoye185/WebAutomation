package com.mobeewave.acquirer.pageObjects;

import com.mobeewave.acquirer.utils.CommonUtils;

public class BasePage {

	
	public static String pageTitle="";
	
	//currently CBA pages has been taken as the base
	
	// Login_Page Identifiers
	public static String tf_username_xpath = "//input[@placeholder='Username']";
	public static String tf_password_xpath = "//input[@placeholder='Password']";
	public static String btn_signIn_xpath = ".//*[@id='login']";
	public static String lnk_forgetPassword_xpath = "//span[contains(text(),'Forgot Password')]";

	// MerchantSummery_Page Identifiers
	public static String lbl_username_partialxpath = "//div[@ui-view='leftNav']//table[@class='options']//td[contains(text(),'";
	
	public static void isElementsveralapped(){
		CommonUtils.isElementsveralapped();
		CommonUtils.makeBothElementListandMapClear();
	}
	
  public static void getAllPageEliments(){
	  
  }
  
 public static String getcurrentPage(){
	  return pageTitle = CommonUtils.getPageTitle();
  }
 
 

}
