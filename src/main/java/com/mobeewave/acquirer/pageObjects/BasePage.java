
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
	public static String btn_pagecount_xpath = "//button[@id='dropdownMenu1";
	public static String tf_merchatid_xpath = "//td[contains(text(),'3275555551111203')]";
	public static String tf_merchantname_xpath = "//td[contains(text(),'Simon Says')]";
	public static String merchantrecord_xpath = "//td[contains(text(),'Simon Says')]/..";

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
