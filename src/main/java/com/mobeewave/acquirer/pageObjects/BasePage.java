
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
	public static String lbl_merchantId_xpath = "//select[@id='filterChoice']";
	public static String tf_merchantfilterchoice_xpath = "//input[@id='filterByFieldValue']";
	public static String lbl_perpageCount_number_xpath = "//button[@id='dropdownMenu1";
	public static String drpdn_perpageCount_xpath ="//div[@class='dropdown open']";
	public static String lbl_perpageCount_xpath= "//span[@class='dropdown-label']";
	public static String tf_merchatId_Partialxpath = "//td[contains(text(),'";
	public static String tf_merchantName_xpath = "//td[contains(text(),'Simon Says')]";
	public static String merchantRecord_xpath = "//td[contains(text(),'Simon Says')]/.."; //need to implement 
	public static String btn_span_xpath = "//span[contains(text(),'«')]";
	//======= Details popup
	public static String btn_resendActivation_mail_xpath = "//button[contains(text(),'Resend Activation Email')]";
	public static String btn_lock_xpath ="//button[@class='btn btn-primary btn-sm pull-right']";
	public static String btn_unlocked_xapth = "//button[contains(text(),'LOCK')]";
	public static String lbl_panel_generalTitle_xpath = "//h3[contains(text(),'General Information')]";//need to implement table 
	public static String lbl_merchantName_xpath ="//h4[contains(text(),'Doing Business As (Merchant Name')]";
	public static String lbl_registrationDate_xpath ="//h4[contains(text(),'Registration Date')]";
	public static String lbl_address_xpath ="//h4[contains(text(),'Address (Street and Number)')]";
	public static String lbl_city_xpath ="//h4[contains(text(),'City')]";
	public static String lbl_country_xpath ="//h4[contains(text(),'Country')]";
	public static String lbl_provinceState_xpath ="//h4[contains(text(),'Province/State')]";
	public static String lbl_zipcode_xpath ="//h4[contains(text(),'Zip Code')]";
	public static String lbl_merchantTimeZone_xpath ="//h4[contains(text(),'Merchant Time Zone')]";
	public static String lbl_preferredCommunicationLanguage_xpath = "//h4[contains(text(),'Preferred Communication Language')]";
	public static String lbl_panel_mpos_title_xpath = "//h3[contains(text(),'Mpos Administrator')]";
	public static String lbl_fullName_xpath = "//h4[contains(text(),'Merchant Full Name')]";
	public static String lbl_phoneNumber_xpath = "//h4[contains(text(),'Merchant Phone Number')]";
	public static String lbl_email_xpath = "//h4[contains(text(),'Merchant Email')]";
	//Processing details dropdown
	public static String lbl_panel_processingTitle_xpath = "//h3[contains(text(),'Processing Details')]";
	public static String lbl_merchantID_xpath = "//div[@id='ppinfoCBA']//*[contains(text(),'Merchant ID')]";
	public static String lbl_currencyDefenition_xpath = "//div[@id='ppinfoCBA']//*[contains(text(),'Currency Definition')]";
	
	public static String lbl_panel_pendingterminaTitle_xpath = "//h3[contains(text(),'Pending Terminals'')]";
	public static String lbl_panel_activeterminalsTitle_xpath ="[contains(text(),'Active Terminals')]";
	
	
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
