package com.mobeewave.acquirer.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mobeewave.acquirer.utils.CommonUtils;

public class PortalUserPage extends BasePage {
	private static String portalUserEmailTblcell_xpath;
	private static String portalUserRecord_xpath;
	public static WebElement portalUserName;
	public static WebElement portalUserEmail;
	public static WebElement portalUserUserName;
	public static WebElement portalUserDivision;
	public static WebElement portalUserAccountState;
	public static WebElement portalUserDetails;

	public WebElement searchPortalUserText() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("tf_filter_portalusers_xpath")));
	}

	public static void setElementsinPortalUserRecord(String portaluserEmail) {

		portalUserEmailTblcell_xpath = locator("tblcell_portaluser_email_partialxpath") + portaluserEmail + "')]";
		portalUserRecord_xpath = portalUserEmailTblcell_xpath + "/..";
		WebElement portalUserRecord = CommonUtils.IsElementAvailable(By.xpath(portalUserRecord_xpath), 20);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<ArrayList> listtemp = CommonUtils.getChildElements(portalUserRecord);
		portalUserName = (WebElement) listtemp.get(0);
		portalUserEmail = (WebElement) listtemp.get(1);
		portalUserUserName = (WebElement) listtemp.get(2);
		portalUserDivision = (WebElement) listtemp.get(3);
		portalUserAccountState = (WebElement) listtemp.get(4);
		portalUserDetails = (WebElement) listtemp.get(7);
	}
	
	public static WebElement lastinPortalUserPagination() {
	WebElement portalUserPagination = 	CommonUtils.IsElementSelectable(By.xpath(locator("pgNav_portaluser_paging_parentXpath")));
		return CommonUtils.getLastPagination(portalUserPagination,locator("pgNav_portaluser_paging_parentXpath"));
	}
	
	public static WebElement portalUserMoreActionButton() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("icon_portaluser_moreactions_Xpath")));
	}
	
	// The + button is recognized with respect to the edit button.
	// In this case, + button is appeared approximately 50 pixel ahead to Edit
	// button and span through another 50 pixel
	public static void clickPortalUserCreateIcon() {
		CommonUtils.clickPositionAgainstElement(portalUserMoreActionButton(),0,-60);			
	}
	
	public static void clickPortalUserEditButton() {
		CommonUtils.clickPositionAgainstElement(portalUserMoreActionButton(), 0, -60);
	}

	public static void clickPortalUserDeleteButton() {
		CommonUtils.clickPositionAgainstElement(portalUserMoreActionButton(), 0, -120);
	}
	
	
	public static WebElement portalUserCreateFullNameLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_new_usernameFull_xpath")));
	}
	
	public static WebElement portalUserCreateFullNameText() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("txt_new_usernameFull_xpath")));
	}
	
	public static WebElement portalUserCreateUserNameLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_new_userlogin_xpath")));
	}
	
	
	public static WebElement portalUserCreateUserNameText() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("txt_new_userlogin_xpath")));
	}
	
	public static WebElement portalUserCreateUserEmailLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_new_useremail_xpath")));
	}
	
	public static WebElement portalUserCreateUserEmailText() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("txt_new_useremail_xpath")));
	}
	
	public static WebElement portalUserCreateUserGroupLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_new_usergroup_xpath")));
	}
	

	
	public static Select portalUserCreateUserGroupDropDown() {
		Select dropdown = new Select(CommonUtils.IsElementSelectable(By.xpath(locator("drpdwn_new_usergroup_xpath"))));
		CommonUtils.getDropdownOptions(dropdown);
		return dropdown;		
	}

	
	public static int selectPortalUserGroupValue(String value){
		int index=0;
		portalUserCreateUserGroupDropDown();
		index = CommonUtils.selectValuefromDropdown(value);
		return index;		
	}
	public static WebElement portalUserCreateUserBankLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_new_userbank_xpath")));
	}
	
	
	public static Select portalUserCreateUserBankDropDown() {

		Select dropdown = new Select(CommonUtils.IsElementSelectable(By.xpath(locator("drpdwn_new_userbank_xpath"))));
		CommonUtils.getDropdownOptions(dropdown);
		return dropdown;
	}

	public static int selectPortalUserBankValue(String value){
		int index=0;
		portalUserCreateUserBankDropDown();
		index = CommonUtils.selectValuefromDropdown(value);
		return index;		
	}
	
	public static Select portalUserCreateUserDivisionDropDown() {

		Select dropdown = new Select(CommonUtils.IsElementSelectable(By.xpath(locator("drpdwn_new_userDivision_xpath"))));
		CommonUtils.getDropdownOptions(dropdown);
		return dropdown;
	}
	
	public static int selectPortalUserDivision(String value){
		int index=0;
		portalUserCreateUserBankDropDown();
		index = CommonUtils.selectValuefromDropdown(value);
		return index;		
	}
	
	public static WebElement portalUserCreateUserSaveButton() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("btn_new_usersave_xpath")));
	}

	public static WebElement portalUserCreateUserCloseButton() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("btn_new_userclose_xpath")));
	}

	// User Profile
	
	public static WebElement portalUserProfileFullNameLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_userfullname_xpath")));
	}

	public static WebElement portalUserProfileEmailLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_useremail_xpath")));
	}
	
	public static WebElement portalUserProfileUsernameLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_username_xpath")));
	}
	
	public static WebElement portalUserProfileDivisionLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_userdivision_xpath")));
	}
	
	public static WebElement portalUserProfileGroupLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_userhivegroup_xpath")));
	}
	
	public static WebElement portalUserProfileBankLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(locator("lbl_userbank_xpath")));
	}
	

	
}
