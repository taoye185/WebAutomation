package steps;

import org.openqa.selenium.TimeoutException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import pageobjects.email.EmailPage;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;
import pageobjects.groups.GroupDetailPage;
import pageobjects.groups.GroupPermissionsPage;
import pageobjects.groups.GroupsSummaryPage;
import pageobjects.groups.NewGroupPage;
import pageobjects.login.LoginPage;
import pageobjects.merchants.MerchantsPage;
import pageobjects.portalusers.PortalUsersPage;
import utils.Browser;
import utils.CommonUtils;
import utils.Log;
import utils.TestDataGenerator;

public class BackgroundSteps {

	public static LoginPage loginPage = new LoginPage();
	public static MerchantsPage merchantsPage = new MerchantsPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static PortalUsersPage PortalUsersPage = new PortalUsersPage();
	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static NewGroupPage newGroupPage = new NewGroupPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static GroupPermissionsPage groupPermissionsPage = new GroupPermissionsPage();
	static TestDataGenerator testDataGenerator = new TestDataGenerator();
	public static PortalUsersPage portalUsersPage = new PortalUsersPage();
	public static EmailPage emailPage = new EmailPage();
	public static String tempEmail = "";

	@Before(value = "@loginAsGPAdmin", order = 0)
	public static void login_As_GP_Admin() {
		Log.info("In GP Admin Login");
		try {
			if (leftNavigation.logoutLabel.isDisplayed()) {
				if (!(leftNavigation.loggedInUserLink.getText())
						.equalsIgnoreCase(AcquirerPortalGlobal.GP_ADMIN_LABEL)) {
					Browser.sleep(3000);
					leftNavigation.logoutLabel.click();
					//navigate_to_home();
					//Browser.open(AcquirerPortalGlobal.URL);
					loginAsGlobalPaymentsAdministrator(); /*
															 * login back as GP
															 * Admin
															 */
				}
				return;
			}
		} catch (TimeoutException ex) {
			loginAsGlobalPaymentsAdministrator();
		}
	}

	@Before("@loginAsRootAdmin")
	public static void login_As_Root_Admin() {
		try {
			if (leftNavigation.logoutLabel.isDisplayed()) {
				if (!(leftNavigation.loggedInUserLink.getText())
						.equalsIgnoreCase(AcquirerPortalGlobal.ROOT_ADMIN_LABEL)) {
					Log.info(" Log out and re loagin as Root Admin user ");
					Browser.sleep(3000);
					leftNavigation.logoutLabel.click();
					//navigate_to_home();
					loginAsRootAdministrator(); /* login back as Root admin */
				}
				return;
			}
		} catch (TimeoutException ex) {
			loginAsRootAdministrator();
		}
	}

	@Before("@navigateToGroupSummaryPage")
	public static void navigate_To_Group_Summary_Page() {
		try {
			Browser.open(AcquirerPortalGlobal.GROUP_URL);
		} catch (TimeoutException ex) {

		}
	}

	/**
	 * Create Admin group if it is not created
	 * 
	 * @throws Throwable
	 */
	@Before(value = "@CreateAdminGroup", order = 1)
	public void create_AdminGroup() throws Throwable {
		if (CommonUtils.adminGroup.isEmpty()) {
			Log.info("Admin Group is not created yet");
			leftNavigation.groupsLink.click();
			groupsSummaryPage.newGroupButton.exists(2);
			groupsSummaryPage.newGroupButton.click();
			GroupSteps.CreateAdminGroup();
			GroupSteps.filterGroupByName();
			GroupSteps.selectGroupandassignAdminGroupPermisisons();
		}
	}

	@Before(value = "@CreateSupportGroup", order = 2)
	public void create_SupportGroup() throws Throwable {
		if (CommonUtils.supportGroup.isEmpty()) {
			Log.info("Support Group is not created yet");
			leftNavigation.groupsLink.click();
			groupsSummaryPage.newGroupButton.exists(2);
			groupsSummaryPage.newGroupButton.click();
			GroupSteps.createSupportGroup();
			GroupSteps.filterGroupByName();
			GroupSteps.selectGroupandassignSupportGroupPermisisons();
		}
	}

	@Before(value = "@create10MinuteEmail", order = 3)
	public void create_10MinuteEmail() throws Throwable {
		Browser.sleep(5000);
		Browser.navigate(AcquirerPortalGlobal.EMAIL_URL);
		Browser.sleep(1000);
		emailPage.mailAddress.scrollIntoView();
		tempEmail = emailPage.mailAddress.getAttribute("value");
		Log.info("tempEmail " + tempEmail);
		Browser.sleep(1000);
		Browser.navigate(AcquirerPortalGlobal.PORTALUSER_URL);

	}

	@After("@logout")
	public static void logout() {
		if (leftNavigation.logoutLabel.isDisplayed()) {
			leftNavigation.logoutLabel.click();
		}
		loginPage.usernameTxtBox.exists(3);
	}

	/**
	 * login as GP Admin
	 */
	public static void loginAsGlobalPaymentsAdministrator() {
		Log.info("logging in as: " + AcquirerPortalGlobal.GP_ADMIN_LABEL);
		Browser.open(AcquirerPortalGlobal.URL);
		loginPage.usernameTxtBox.exists(16);
		loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.GP_ADMIN_LABEL;
	}

	/**
	 * login as root admin
	 */
	public static void loginAsRootAdministrator() {
		Log.info("logging in as: " + AcquirerPortalGlobal.ROOT_ADMIN_LABEL);
		Browser.open(AcquirerPortalGlobal.URL);
		loginPage.usernameTxtBox.exists(16);
		loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD);
		loginPage.signInBtn.click();

		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.ROOT_ADMIN_LABEL;
	}

	@Given("^User successfully navigated to Home Page$")
	public void user_successfully_navigated_to_Home_Page() throws Throwable {
		navigate_to_home();
	}

	/**
	 * Initial navigation to home page
	 */
	public static void navigate_to_home() {
		Log.info("logging in as: " + AcquirerPortalGlobal.ROOT_ADMIN_LABEL);
		Browser.open(AcquirerPortalGlobal.URL);
	}
}
