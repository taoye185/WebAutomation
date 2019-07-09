package steps;

import org.openqa.selenium.TimeoutException;
import cucumber.api.java.Before;
import acquirerportal.pageobjects.email.EmailPage;
import acquirerportal.AcquirerPortalGlobal;
import acquirerportal.pageobjects.LeftNavigation;
import acquirerportal.pageobjects.groups.GroupDetailPage;
import acquirerportal.pageobjects.groups.GroupPermissionsPage;
import acquirerportal.pageobjects.groups.GroupsSummaryPage;
import acquirerportal.pageobjects.groups.NewGroupPage;
import acquirerportal.pageobjects.login.LoginPage;
import acquirerportal.pageobjects.merchants.MerchantsPage;
import acquirerportal.pageobjects.portalusers.PortalUsersPage;
import coreutils.Browser;
import acquirerportal.CommonUtils;
import coreutils.Log;
import coreutils.TestDataGenerator;

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
	public static String tempPassword = "";

	@Before(value = "@loginAsGPAdmin", order = 0)
	public static void login_As_GP_Admin() {
		Log.info("Logging In as a GP Admin");
		try {
			if (leftNavigation.logoutLabel.isDisplayed()) {
				if (!(leftNavigation.loggedInUserLink.getText())
						.equalsIgnoreCase(AcquirerPortalGlobal.GP_ADMIN_LABEL)) {
					Browser.sleep(3000);
					leftNavigation.logoutLabel.click();
					// navigate_to_home();
					// Browser.open(AcquirerPortalGlobal.URL);
					loginAsGlobalPaymentsAdministrator(); /* login back as GP Admin */
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
					Log.info(" Log out and re-login as Root Admin user ");
					Browser.sleep(3000);
					leftNavigation.logoutLabel.click();
					// navigate_to_home();
					loginAsRootAdministrator(); /* login back as Root admin */
				}
				return;
			}
		} catch (TimeoutException ex) {
			loginAsRootAdministrator();
		}
	}

	/**
	 * Create Admin group if it is not created
	 * 
	 *
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
		Browser.open(AcquirerPortalGlobal.EMAIL_URL);
		Browser.sleep(1000);
		emailPage.mailAddress.scrollIntoView();
		tempEmail = emailPage.mailAddress.getAttribute("value");
		Log.info("tempEmail " + tempEmail);
		// tempPassword= emailPage.
		Browser.sleep(1000);
		Browser.open(AcquirerPortalGlobal.PORTALUSER_URL);

	}

	@Before("@logout")
	public static void logoutOfAcquirerPortal() {
		logout();
	}

	/**
	 * Logout of Acquirer portal
	 */
	public static void logout() {
		if (leftNavigation.logoutLabel.isClickable(4)) {
			Log.info("User is logged off of the Portal");
			leftNavigation.logoutLabel.clickByJavaScript();
		}
		Browser.sleep(2000);
		loginPage.passwordTxtBox.exists(3);
	}

	/**
	 * login as GP Admin
	 */
	public static void loginAsGlobalPaymentsAdministrator() {
		Log.info("logging in as: " + AcquirerPortalGlobal.GP_ADMIN_LABEL);
		// Browser.open(AcquirerPortalGlobal.URL);
		loginPage.navigateToLoginPage();
		loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		leftNavigation.merchantsLink.exists(5);
		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.GP_ADMIN_LABEL;
	}

	/**
	 * login as root admin
	 */
	public static void loginAsRootAdministrator() {
		Log.info("logging in as: " + AcquirerPortalGlobal.ROOT_ADMIN_LABEL);
		Browser.open(AcquirerPortalGlobal.URL);
		loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		leftNavigation.portalUserLink.exists(5);
		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.ROOT_ADMIN_LABEL;
	}

	/**
	 * @param userName - userName of the login user
	 * @param password - password of the login user
	 */
	public static void login(String userName, String password) {
		loginPage.usernameTxtBox.exists(16);
		loginPage.usernameTxtBox.clearAndSendKeys(userName);
		loginPage.passwordTxtBox.clearAndSendKeys(password);
		loginPage.signInBtn.click();
	}
}
