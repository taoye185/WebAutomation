
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
	public static String drpdn_perpageCount_xpath = "//div[@class='dropdown open']";
	public static String lbl_perpageCount_xpath = "//span[@class='dropdown-label']";
	public static String tf_merchatId_Partialxpath = "//td[contains(text(),'";
	public static String btn_span_xpath = "//span[contains(text(),'«')]";

	// ======= Details popup
	public static String btn_resendActivation_mail_xpath = "//button[contains(text(),'Resend Activation Email')]";
	public static String btn_lock_xpath = "//button[@class='btn btn-primary btn-sm pull-right']";
	public static String btn_unlocked_xapth = "//button[contains(text(),'LOCK')]";
	public static String lbl_panel_generalTitle_xpath = "//h3[contains(text(),'General Information')]";
	// need to implement table
	public static String lbl_merchantName_xpath = "//h4[contains(text(),'Doing Business As (Merchant Name')]";
	public static String lbl_registrationDate_xpath = "//h4[contains(text(),'Registration Date')]";
	public static String lbl_address_xpath = "//h4[contains(text(),'Address (Street and Number)')]";
	public static String lbl_city_xpath = "//h4[contains(text(),'City')]";
	public static String lbl_country_xpath = "//h4[contains(text(),'Country')]";
	public static String lbl_provinceState_xpath = "//h4[contains(text(),'Province/State')]";
	public static String lbl_zipcode_xpath = "//h4[contains(text(),'Zip Code')]";
	public static String lbl_merchantTimeZone_xpath = "//h4[contains(text(),'Merchant Time Zone')]";
	public static String lbl_preferredCommunicationLanguage_xpath = "//h4[contains(text(),'Preferred Communication Language')]";
	public static String lbl_panel_mpos_title_xpath = "//h3[contains(text(),'Mpos Administrator')]";
	public static String lbl_fullName_xpath = "//h4[contains(text(),'Merchant Full Name')]";
	public static String lbl_phoneNumber_xpath = "//h4[contains(text(),'Merchant Phone Number')]";
	public static String lbl_email_xpath = "//h4[contains(text(),'Merchant Email')]";
	public static String lbl_panel_processingTitle_xpath = "//h3[contains(text(),'Processing Details')]";
	public static String lbl_merchantID_xpath = "//div[@id='ppinfoCBA']//*[contains(text(),'Merchant ID')]";
	public static String lbl_currencyDefenition_xpath = "//div[@id='ppinfoCBA']//*[contains(text(),'Currency Definition')]";
	public static String lbl_panel_pendingterminaTitle_xpath = "//h3[contains(text(),'Pending Terminals'')]";
	public static String lbl_terminalIdentifier_xpath = "//div[@class='panel panel-default']//div[@id='globalPending']//th[contains(text(),'Terminal Identifier')]";
	public static String lbl_option_xpath = "//div[@class='panel panel-default']//div[@id='globalPending']//th[contains(text(),'Options')]";
	public static String lbl_panel_activeterminalsTitle_xpath = "[contains(text(),'Active Terminals')]";
	public static String lbl_terminalIdentifier_partialXpath = " //div[@id='active']//th[contains(text(),'Terminal Identifier')]";
	public static String lbl_terminalName = "//div[@class='panel panel-default']//th[contains(text(),'Terminal Name')]";
	public static String lbl_safetyNetAttestationStatus_partialXpath = " //div[@class='panel panel-default']//th[contains(text(),'SafetyNet Attestation Status')]";
	public static String lbl_option_partialXpath = " //div[@class='panel panel-default']//div[@id='active']//th[contains(text(),'Options')]";
	public static String btn_ellipsis_xpath = "//i[@class='mfb-component__main-icon--active fa fa-ellipsis-v']";
	public static String btn_editMerchanDetails_xpath = "]"; // need to implement
	public static String lbl_editGeneralInformation_xpath = "//*[contains(text(),'Edit General Information')]";
	public static String lbl_businessInformation_xpath = "//*[contains(text(),'Business Information')]";
	//need to add fields
	public static String tf_generalEdit_merchantName_xpath = "//input[@id='name'] ";
	public static String tf_generalAddresss_StreetAndNumber_xpath = "//label[contains(text(),'Address (Street and Number)')]/following-sibling::*"; 
	// reference need to complete from grid
	public static String btn_deleteMerchant_xpath = "//i[@class='mfb-component__child-icon fa fa-trash']";
	public static String btn_ok_xpath = "//button[contains(text(),'Ok')]";
	public static String btn_cancel_xpath = "//button[contains(text(),'Cancel')]";
	public static String lbl_confermationNeeded_xpath = "//*[contains(text(),'Confirmation Needed')]";
	public static String lbl_areyouSure_txt_xpath = "//*[contains(text(),'Are you sure?')]";

	// Transaction_Page Identifiers
	
	// Portal Users Page
	public static String lbl_portalusers_xpath = "//h1[contains(text(),'Portal Users')]";
	public static String lbl_users_xpath ="//h4[contains(text(),'Users')]";
	public static String lbl_groups_xpath ="//h4[contains(text(),'Groups')]";
	public static String lnk_summary_xpath ="//span[@ui-sref='app.hive-access.groups']";
	public static String lbl_groupprofile_xpath ="//h4[contains(text(),'Group Profile')]";
	public static String collapse_generalinformation_xpath ="//h3[contains(text(),'General Information')]";
	public static String lbl_nameGI_xpath ="//p[contains(text(),'Name')]";
	public static String ibl_namevalueGI_xpath =lbl_nameGI_xpath+"/following-sibling::*";
	public static String lbl_descriptionGI_xpath ="//p[contains(text(),'Description')]";
	public static String ibl_descriptionvalueGI_xpath =lbl_descriptionGI_xpath+"/following-sibling::*";
	public static String lbl_grouppermissions_xpath ="//h3[contains(text(),'Group Permissions')]";
	public static String lbl_groupmembers_xpath ="//h3[contains(text(),'Group Members')]";
	public static String tf_filter_portalusers_xpath ="//input[@id='filterByFieldValue']";
	// Left Navigation
	public static String lnk_partial_LeftNav_xpath ="//a[contains(text(),'";
	public static final String PORTAL_USERS="Portal Users";

	
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
