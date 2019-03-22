package com.mobeewave.acquirer.tests;

import com.mobeewave.acquirer.pageObjects.PortalUserPage;
import com.mobeewave.acquirer.utils.AssertUtil;
import com.mobeewave.acquirer.utils.CommonUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PortalUserSteps {
PortalUserPage portalUserPage = new PortalUserPage();
private static String portalUser_GBL = "";
private static String email_GBL = "";

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
		AssertUtil.assertEq(PortalUserPage.portalUserName, portalUser_GBL,"Verify merchant ID " + portalUser_GBL + " displays in the  Portal USer search result table");
		} catch (Exception ex) {			
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("validate the portal  " + portalUser_GBL + " user details Failed");
		}
	}
	
	@Then("^User click on edit button$")
	public void user_click_on_edit_button(){
		try {
		Thread.sleep(3000);		
		PortalUserPage.portalUserEditIcon().click();
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

}
