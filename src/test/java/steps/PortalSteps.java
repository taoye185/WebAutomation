package steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import acquirerportal.AcquirerPortalGlobal;
import acquirerportal.pageobjects.LeftNavigation;
import acquirerportal.pageobjects.login.ChangePasswordPage;
import acquirerportal.pageobjects.login.LoginPage;
import acquirerportal.pageobjects.portalusers.NewPortalUserRegistrationPage;
import acquirerportal.pageobjects.portalusers.PortalUserDetailPage;
import acquirerportal.pageobjects.portalusers.PortalUsersPage;
import coreutils.GridCommon;
import coreutils.Browser;
import acquirerportal.CleanUp;
import acquirerportal.CommonUtils;
import coreutils.Log;
import coreutils.TestDataGenerator;

public class PortalSteps {
	public static LoginPage loginPage = new LoginPage();
	public static PortalUsersPage portalUsersPage = new PortalUsersPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static NewPortalUserRegistrationPage newPortalUserRegistrationPage = new NewPortalUserRegistrationPage();
	public static PortalUserDetailPage portalUserDetailPage = new PortalUserDetailPage();
	public static String portalUserEmail = "";
	public static String newPortalUserID = "";
	public TestDataGenerator testDataGenerator = new TestDataGenerator();
	public static ChangePasswordPage changePasswordPage = new ChangePasswordPage();

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
		Assert.assertTrue("User is not logged in ",
				(Browser.getDriver().getCurrentUrl().equalsIgnoreCase(AcquirerPortalGlobal.PORTAL_USER_URL)));
	}

	@And("^User validate the portal user details from results$")
	public void user_validate_the_portal_user_details_from_results() throws Throwable {

	}

	@And("^logout from portal$")
	public void logout_from_portal() throws Throwable {
		BackgroundSteps.logout();
	}

	@And("^click on details of the portal user from results table$")
	public void click_on_details_of_the_portal_user_from_results_table() throws Throwable {
		GridCommon.selectAndGetSiblingElementBySearchText(portalUsersPage.portalUserListGrid, portalUserEmail,
				"Details");
		// portalUsersPage.selectElementintheResultsTabel2(portalUserEmail, "Details");
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

		if (email.contentEquals("supportEmail")) {
			portalUserEmail = CommonUtils.supportUserEmail;
		}
		if (email.contentEquals("adminEmail")) {
			portalUserEmail = CommonUtils.adminUserEmail;
		}
		filterPortalUserByName(portalUserEmail);
	}

	@Then("^Delete the portal user record$")
	public void delete_the_portal_user_record() throws Throwable {
		portalUserDetailPage.deleteUserButton.click();
		portalUserDetailPage.deleteConfirmationButton.click();
		Browser.sleep(1000);
	}

	public static void filterPortalUserByName(String portalUserEmail) {
		Log.info("Filter new Portal User created");
		portalUsersPage.filterButton.click();
		portalUsersPage.portalUserFilterEmailFilterOptions.selectDropDownItem(portalUserEmail);
		portalUsersPage.OkFilterButton.click();
		Browser.sleep(3000);
		Assert.assertTrue("Portal user email is not listed", (GridCommon
				.selectAndGetElementInTheGrid(portalUsersPage.portalUserListGrid, portalUserEmail).isDisplayed()));
	}

	@Given("^provide details to create a \"([^\"]*)\" new Portal user$")
	public void provide_details_to_create_a_new_Portal_user(String user) throws Throwable {
		Browser.sleep(2000);
		Log.info("Creating new portal user");
		if (user.contentEquals("support")) {
			String userName = testDataGenerator.getCharacterNumericString("newsupport");
			newPortalUserRegistrationPage.portalUsernameTxtBox.clearAndSendKeys(userName);
			newPortalUserRegistrationPage.portalEmailTxtBox.clearAndSendKeys(BackgroundSteps.tempEmail);
			newPortalUserRegistrationPage.portalNameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_NEWASUPPORT_NAME);
			newPortalUserRegistrationPage.portalGroupDropdown.sendKeys(CommonUtils.supportGroup);
			Browser.sleep(1000);
			newPortalUserRegistrationPage.portalGroupDropdown.sendKeys(Keys.ENTER);
			CommonUtils.supportUserEmail = BackgroundSteps.tempEmail;
			CommonUtils.supportUserName = userName;
		}
		if (user.contentEquals("admin")) {
			String userName = testDataGenerator.getCharacterNumericString("newadmin");
			newPortalUserRegistrationPage.portalUsernameTxtBox.clearAndSendKeys(userName);
			newPortalUserRegistrationPage.portalEmailTxtBox.clearAndSendKeys(BackgroundSteps.tempEmail);
			newPortalUserRegistrationPage.portalNameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_NEWADMIN_NAME);
			newPortalUserRegistrationPage.portalGroupDropdown.selectDropDownItem(CommonUtils.adminGroup);
			Browser.sleep(1000);
			CommonUtils.adminUserEmail = BackgroundSteps.tempEmail;
			CommonUtils.adminUserName = userName;
		}
		newPortalUserRegistrationPage.createUserButton.exists(3);
		newPortalUserRegistrationPage.createUserButton.click();

	}

	@Given("^new user \"([^\"]*)\" enter credentials and hit Login Button$")
	public void new_user_enter_credentials_and_hit_Login_Button(String user) throws Throwable {
		Browser.sleep(1000);
		BackgroundSteps.login(EmailSteps.tempUserID, EmailSteps.tempEmailPassword);
	}

	@And("^user navigates back to email and capture temporary password$")
	public void user_navigates_back_to_email_and_capture_temporary_password() throws Throwable {
		Browser.open(AcquirerPortalGlobal.EMAIL_URL);
		EmailSteps.getPortalUserCredentials();
		Browser.sleep(2000);
	}

	@And("^new user successfully navigated to Home Page$")
	public void new_user_successfully_navigated_to_Home_Page() throws Throwable {
		Browser.open(AcquirerPortalGlobal.URL);
	}

	@Then("^the user is successfully logged in to acquirer portal$")
	public void the_user_is_successfully_logged__in_to_acquirer_portal() throws Throwable {
		Assert.assertTrue(leftNavigation.loggedInUserLink.exists(2));
	}

	@And("^user change password$")
	public void user_change_password() throws Throwable {
		Browser.sleep(1000);
		changePasswordPage.changePasswordLabel.exists(5);
		changePasswordPage.oldPasswordTxtBox.sendKeys(EmailSteps.tempEmailPassword);
		changePasswordPage.newPasswordTxtBox.sendKeys(AcquirerPortalGlobal.GP_NEWSUPPORT_PASSWORD);
		changePasswordPage.confirmNewPasswordTxtBox.sendKeys(AcquirerPortalGlobal.GP_NEWSUPPORT_PASSWORD);
		Browser.sleep(1000);
		changePasswordPage.changePasswordButton.click();
		Browser.sleep(3000);
	}

}
