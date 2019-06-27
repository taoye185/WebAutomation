package steps;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;
import pageobjects.login.LoginPage;
import pageobjects.portalusers.NewPortalUserRegistrationPage;
import pageobjects.portalusers.PortalUserDetailPage;
import pageobjects.portalusers.PortalUsersPage;
import utils.AgGridCommon;
import utils.Browser;
import utils.CleanUp;
import utils.CommonUtils;
import utils.Log;

public class PortalSteps {
	public static LoginPage loginPage = new LoginPage();
	public static PortalUsersPage portalUsersPage = new PortalUsersPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static NewPortalUserRegistrationPage newPortalUserRegistrationPage = new NewPortalUserRegistrationPage();
	public static PortalUserDetailPage portalUserDetailPage = new PortalUserDetailPage();
	public static String portalUserEmail="";
	
	@Given("^User \"([^\"]*)\" is successfully navigated to Portal User Page$")
	public void user_is_successfully_navigated_to_Portal_User_Page(String username) throws Throwable {
		Browser.sleep(2000);
		leftNavigation.portalUserLink.click();
	}

	@Given("^User successfully navigated to Portal Users Page$")
	public void user_successfully_navigated_to_Portal_Users_Page() throws Throwable {
		Browser.sleep(2000);
		if (leftNavigation.portalUserLink.exists(2))
			leftNavigation.portalUserLink.click();			
		Assert.assertTrue("User is logged in ",
				(leftNavigation.loggedInUserLink.getText().equalsIgnoreCase(CommonUtils.userLabel_GBL)));
		Browser.sleep(2000);
	}

	

	@And("^User validate the portal user details from results$")
	public void user_validate_the_portal_user_details_from_results() throws Throwable {

		
	}

	@And("^click on details of the portl user from results table$")
	public void click_on_details_of_the_portl_user_from_results_table() throws Throwable {
		AgGridCommon.selectAndGetSiblingElementBySearchText(portalUsersPage.portalUserListGrid, portalUserEmail,"Details");
				//portalUsersPage.selectElementintheResultsTabel2(portalUserEmail, "Details");
	}
	
	@Given("^user click on New Portal User button$")
	public void user_click_on_New_Portal_User_button() throws Throwable {
		try {
			portalUsersPage.newPortalUserButton.click();
		} catch (NoSuchElementException e) {
			newPortalUserRegistrationPage.closeButton.click();
			CleanUp.deleteAllGroups();
		}
	}

	@Given("^provide details to create a new Portal user$")
	public void provide_details_to_create_a_new_Portal_user() throws Throwable {
		Log.info("Creating new portal user");
		newPortalUserRegistrationPage.portalNameTxtBox.clearAndSendKeys("Aet user");
		newPortalUserRegistrationPage.portalGroupDropdown.selectDropDownItem("AetTest01");
	}



	@Given("^Filter portal users by \"([^\"]*)\" email$")
	public void filter_portal_users_by_email(String email) throws Throwable {
		Browser.sleep(3000);
		
		if(email.contentEquals("supportEmail")){
			portalUserEmail=CommonUtils.supportUserEmail ;			
		}
		if(email.contentEquals("adminEmail")){
			portalUserEmail=CommonUtils.adminUserEmail;		
		}
		filterPortlUserByName(portalUserEmail);		
		}

	@Then("^Delete the portal user record$")
	public void delete_the_portal_user_record() throws Throwable {
		portalUserDetailPage.deleteUserButton.click();
		portalUserDetailPage.deleteConfirmationButton.click();
		Browser.sleep(1000);
	}
	
	public static void filterPortlUserByName(String portlUserEmail ) {
		Log.info("Filter new Portal User created");
		portalUsersPage.filterButton.click();		
		portalUsersPage.emailFilterOptions.selectDropDownItem(portlUserEmail);
		portalUsersPage.OkFilterButton.click();
		Browser.sleep(3000);
		Assert.assertTrue("Portal user email is not listed", (AgGridCommon.selectAndGetElementInTheGrid(portalUsersPage.portalUserListGrid,portalUserEmail).isDisplayed()));
	}
	

 	@Given("^provide details to create a \"([^\"]*)\" new Portal user$")
	public void provide_details_to_create_a_new_Portal_user(String user) throws Throwable {
		// String userName = user.replaceAll("\\s+", "");
		Browser.sleep(2000);
		Log.info("Creating new portal user");
		if (user.contentEquals("support")) {
			newPortalUserRegistrationPage.portalNameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_NEWASUPPORT_NAME);
			newPortalUserRegistrationPage.portalUsernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_NEWASUPPORT_USER_NAME);
			newPortalUserRegistrationPage.portalEmailTxtBox.clearAndSendKeys(BackgroundSteps.tempEmail);
			newPortalUserRegistrationPage.portalGroupDropdown.selectDropDownItem(CommonUtils.supportGroup);
			CommonUtils.supportUserEmail =BackgroundSteps.tempEmail;
			
		}
		if (user.contentEquals("admin")) {
			newPortalUserRegistrationPage.portalNameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_NEWADMIN_NAME);
			newPortalUserRegistrationPage.portalUsernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_NEWADMIN_USER_NAME);
			newPortalUserRegistrationPage.portalEmailTxtBox.clearAndSendKeys(BackgroundSteps.tempEmail);
			newPortalUserRegistrationPage.portalGroupDropdown.selectDropDownItem(CommonUtils.adminGroup);
			CommonUtils.adminUserEmail =BackgroundSteps.tempEmail;
		}

		newPortalUserRegistrationPage.createUserButton.click();

	}

}
