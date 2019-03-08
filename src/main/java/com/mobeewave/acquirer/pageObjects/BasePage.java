
package com.mobeewave.acquirer.pageObjects;

import com.mobeewave.acquirer.utils.CommonUtils;

public class BasePage {

	public static String pageTitle = "";

	// currently CBA pages has been taken as the base

	// Login_Page Identifiers
	public static String tf_username_xpath = "//input[@placeholder='Username']";
	public static String tf_password_xpath = "//input[@placeholder='Password']";
	public static String btn_signIn_xpath = ".//*[@id='login']";
	public static String lnk_forgetPassword_xpath = "//span[contains(text(),'Forgot Password')]";

	// MerchantSummery_Page Identifiers
	public static String lbl_username_partialxpath = "//div[@ui-view='leftNav']//table[@class='options']//td[contains(text(),'";
	public static String lbl_merchantid_xpath = "//select[@id='filterChoice']";
	public static String tf_merchantfilterchoice_xpath = "//input[@id='filterByFieldValue']";
	public static String lbl_perpagecount_number_xpath = "//button[@id='dropdownMenu1";
	public static String drpdn_perpagecount_xpath ="//div[@class='dropdown open']";
	public static String lbl_perpagecount_xpath= "//span[@class='dropdown-label']";
	public static String tf_merchatid_xpath = "//td[contains(text(),'3275555551111203')]";
	public static String tf_merchantname_xpath = "//td[contains(text(),'Simon Says')]";
	public static String merchantrecord_xpath = "//td[contains(text(),'Simon Says')]/.."; //need to implement 
	public static String btn_span_xpath = "//span[contains(text(),'«')]";
	//Details
	public static String btn_resend_activation_mail_xpath = "//button[contains(text(),'Resend Activation Email')]";
	public static String btn_lock_xpath ="//button[@class='btn btn-primary btn-sm pull-right']";
	public static String btn_unlocked_xapth = "//button[contains(text(),'LOCK')]";
	public static String lbl_panel_title_xpath = "//h3[contains(text(),'General Information')]";
	
	// Transaction_Page Identifiers

	// AuditLog_Page Identifiers

	public static void areElementsOveralapped() {
		CommonUtils.checkOverlap();
		CommonUtils.makeBothElementListandMapClear(); 
	}

	public static void getAllPageEliments() {

	}

	public static String getCurrentPage() {
		return pageTitle = CommonUtils.getPageTitle();
	}

}
