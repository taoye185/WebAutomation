package com.mobeewave.acquirer.tests;

import com.mobeewave.acquirer.pageObjects.ConfirmationMesssageBoxPage;
import com.mobeewave.acquirer.pageObjects.PortalUserPage;
import com.mobeewave.acquirer.utils.AssertUtil;
import com.mobeewave.acquirer.utils.CommonUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PortalUserSteps {
PortalUserPage portalUserPage = new PortalUserPage();
private static String portalUser_GBL = "";
private static String email_GBL = "";
private static String newPortalUserFullName_GBL = "";
private static String newPortalUserName_GBL = "";
private static String newPortalUserEmail_GBL = "";
private static String newPortalUserGroup_GBL = "";
private static String newPortalUserBank_GBL = "";
private static String newPortalUserDivision_GBL = "";

	@Then("^User enter portal user name \"([^\"]*)\" and search$")
	public void user_enter_portal_user_name_and_search(String username){
		try {
			Thread.sleep(3000);			
			CommonUtils.setUpUsers(username);
			portalUser_GBL = CommonUtils.username_GBL;
			email_GBL = CommonUtils.email_GBL;
			portalUserPage.searchPortalUserText().sendKeys(portalUser_GBL);			
			System.out.println("searched in  "  + portalUserPage.searchPortalUserText().getText() );
			Thread.sleep(2000);
			
		} catch (InterruptedException ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("Search user " + portalUser_GBL + " is  Failed");
		}
	}
	
	@Then("^User validate the portal user details from results$")
	public void user_validate_the_portal_user_details_from_results(){
		try {
		PortalUserPage.setElementsinPortalUserRecord(this.email_GBL);
		System.out.println("Found Email " + email_GBL );
		System.out.println("Found username_GBL " + CommonUtils.username_GBL );
		System.out.println("Found Portal user " + PortalUserPage.portalUserName.getText());
		
		AssertUtil.assertEq(PortalUserPage.portalUserName.getText(), portalUser_GBL,"Verify merchant ID " + portalUser_GBL + " displays in the  Portal USer search result table");
		
		AssertUtil.AggregatedResult();
		} catch (Exception ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("validate the portal  " + portalUser_GBL + " user details Failed");
		}
	}
	
	
	@Then("^User go to the details of the record$")
	public void user_go_to_the_details_of_the_record(){
		try {
		PortalUserPage.portalUserDetails.click();	
		Thread.sleep(1000);	
		PortalUserPage.portalUserMoreActionButton().click();
		Thread.sleep(1000);	
		} catch (InterruptedException ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("... Loading Portal user details Failed");
		}
	}
	
	
	
	@Then("^User click on edit button$")
	public void user_click_on_edit_button(){
		try {
		Thread.sleep(3000);		
		PortalUserPage.portalUserMoreActionButton().click();
		} catch (InterruptedException ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("... More actions Failed");
		}
	}

	@Then("^User click on \\+ button to add new \"([^\"]*)\" Portal User$")
	public void user_click_on_button_to_add_new_Portal_User(String portalUSer){
		try {
			
		PortalUserPage.clickPortalUserCreateIcon();
		Thread.sleep(3000);	
		
		} catch (InterruptedException ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("... Click on + Failed");
		}
	}
	
	@Then("^User click close button on create new Portal User Page$")
	public void user_click_close_button_on_create_new_Portal_User_Page() {
		PortalUserPage.portalUserCreateUserCloseButton().click();
	}

	@Then("^User click Last in pagination of  Portal User Page$")
	public void user_click_Last_in_pagination_of_Portal_User_Page() {
		try {
		PortalUserPage.lastinPortalUserPagination().click();
		Thread.sleep(3000);	
		} catch (InterruptedException ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("... Click on last pagination Failed");
		}
	}
	
	@Then("^User provide details to create a \"([^\"]*)\" new Portal user$")
	public void user_provide_details_to_create_a_new_Portal_user(String portalUser){
		try {
		
		CommonUtils.setUpNewPortalUsers(portalUser);	
		newPortalUserFullName_GBL = CommonUtils.newUserNameFull_GBL;
		newPortalUserName_GBL = CommonUtils.newUserName_GBL;
		newPortalUserEmail_GBL = CommonUtils.newUserEmail_GBL;
		newPortalUserGroup_GBL = CommonUtils.newUserGroup;
		newPortalUserBank_GBL = CommonUtils.newUserBank;
		newPortalUserDivision_GBL = CommonUtils.newUserDivision;
			
		PortalUserPage.portalUserCreateFullNameText().sendKeys(newPortalUserFullName_GBL);
		PortalUserPage.portalUserCreateUserNameText().sendKeys(newPortalUserName_GBL);
		PortalUserPage.portalUserCreateUserEmailText().sendKeys(newPortalUserEmail_GBL);
		PortalUserPage.portalUserCreateUserGroupDropDown().selectByIndex(PortalUserPage.selectPortalUserGroupValue(newPortalUserGroup_GBL));
		//PortalUserPage.portalUserCreateUserGroupDropDown().selectByValue(portalUser);
		Thread.sleep(2000);	
		PortalUserPage.portalUserCreateUserBankDropDown().selectByIndex(PortalUserPage.selectPortalUserBankValue(newPortalUserBank_GBL));
		Thread.sleep(2000);	
		PortalUserPage.portalUserCreateUserDivisionDropDown().selectByIndex(PortalUserPage.selectPortalUserDivision(newPortalUserDivision_GBL));
		Thread.sleep(2000);
		PortalUserPage.portalUserCreateUserSaveButton().click();
		Thread.sleep(2000);
		PortalUserPage.portalUserCreateUserCloseButton().click();
		
		} catch (InterruptedException ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("... Portal user creation is Failed");
		}
		
	}
	
	@Then("^User delete the portal user record$")
	public void user_delete_the_portal_user_record(){
		try{
		PortalUserPage.clickPortalUserDeleteButton();
		Thread.sleep(1000);	
		ConfirmationMesssageBoxPage.setConfirmationBoxElements();
		Thread.sleep(1000);	
		ConfirmationMesssageBoxPage.confirmationMessageOK.click();
		} catch (InterruptedException ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("Portal user delete Failed");
		}
	}

}
