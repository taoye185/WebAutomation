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

		return CommonUtils.IsElementSelectable(By.xpath(tf_filter_portalusers_xpath), 20);
	}

	public static void setElementsinPortalUserRecord(String portaluserEmail) {

		portalUserEmailTblcell_xpath = BasePage.tblcell_portaluser_email_partialxpath + portaluserEmail + "')]";
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
	WebElement portalUserPagination = 	CommonUtils.IsElementSelectable(By.xpath(pgNav_portaluser_paging_parentXpath), 20);
		return CommonUtils.getLastPagination(portalUserPagination,pgNav_portaluser_paging_parentXpath);
	}
	
	public static WebElement portalUserMoreActionButton() {

		return CommonUtils.IsElementSelectable(By.xpath(icon_portaluser_moreactions_Xpath), 20);
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

		return CommonUtils.IsElementSelectable(By.xpath(lbl_new_usernameFull_xpath), 20);
	}
	
	public static WebElement portalUserCreateFullNameText() {

		return CommonUtils.IsElementSelectable(By.xpath(txt_new_usernameFull_xpath), 20);
	}
	
	public static WebElement portalUserCreateUserNameLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_new_userlogin_xpath), 20);
	}
	
	
	public static WebElement portalUserCreateUserNameText() {

		return CommonUtils.IsElementSelectable(By.xpath(txt_new_userlogin_xpath), 20);
	}
	
	public static WebElement portalUserCreateUserEmailLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_new_useremail_xpath), 20);
	}
	
	public static WebElement portalUserCreateUserEmailText() {

		return CommonUtils.IsElementSelectable(By.xpath(txt_new_useremail_xpath), 20);
	}
	
	public static WebElement portalUserCreateUserGroupLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_new_usergroup_xpath), 20);
	}
	

	
	public static Select portalUserCreateUserGroupDropDown() {
		Select dropdown = new Select(CommonUtils.IsElementSelectable(By.xpath(drpdwn_new_usergroup_xpath), 20));
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

		return CommonUtils.IsElementSelectable(By.xpath(lbl_new_userbank_xpath), 20);
	}
	
	
	public static Select portalUserCreateUserBankDropDown() {

		Select dropdown = new Select(CommonUtils.IsElementSelectable(By.xpath(drpdwn_new_userbank_xpath), 20));
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

		Select dropdown = new Select(CommonUtils.IsElementSelectable(By.xpath(drpdwn_new_userDivision_xpath), 20));
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

		return CommonUtils.IsElementSelectable(By.xpath(btn_new_usersave_xpath), 20);
	}

	public static WebElement portalUserCreateUserCloseButton() {

		return CommonUtils.IsElementSelectable(By.xpath(btn_new_userclose_xpath), 20);
	}

	// User Profile
	
	public static WebElement portalUserProfileFullNameLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_userfullname_xpath), 20);
	}

	public static WebElement portalUserProfileEmailLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_useremail_xpath), 20);
	}
	
	public static WebElement portalUserProfileUsernameLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_username_xpath), 20);
	}
	
	public static WebElement portalUserProfileDivisionLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_userdivision_xpath), 20);
	}
	
	public static WebElement portalUserProfileGroupLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_userhivegroup_xpath), 20);
	}
	
	public static WebElement portalUserProfileBankLabel() {

		return CommonUtils.IsElementSelectable(By.xpath(lbl_userbank_xpath), 20);
	}
	

	
}
