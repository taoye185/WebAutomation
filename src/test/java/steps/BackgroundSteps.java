package steps;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

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

public class BackgroundSteps {

	public static LoginPage loginPage = new LoginPage();
	public static MerchantsPage merchantsPage = new MerchantsPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static PortalUsersPage PortalUsersPage = new PortalUsersPage();
	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static NewGroupPage newGroupPage = new NewGroupPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static GroupPermissionsPage groupPermissionsPage = new GroupPermissionsPage();
	public static PortalUsersPage portalUsersPage = new PortalUsersPage();
	public static EmailPage emailPage = new EmailPage();
	public static String tempEmail = "";
	public static String tempPassword = "";

	@Before(value = "@loginAsGPAdmin", order = 1)
	public static void login_As_GP_Admin() {
		Log.info("Logging In as a GP Admin");
		try {
			Browser.open(AcquirerPortalGlobal.URL);
			if (leftNavigation.logoutLabel.isDisplayed()) {
				if (!(leftNavigation.loggedInUserLink.getText())
						.equalsIgnoreCase(AcquirerPortalGlobal.GP_ADMIN_USER_NAME)) {
					leftNavigation.logoutLabel.clickByJavaScript();
					Browser.sleep(3000);
					loginAsGlobalPaymentsAdministrator(); /* login back as GP Admin */
				}
				return;
			}
		} catch (TimeoutException ex) {
			loginAsGlobalPaymentsAdministrator();
		}
	}

	@Before(value = "@loginAsRootAdmin", order = 2)
	public static void login_As_Root_Admin() {
		try {
			Browser.open(AcquirerPortalGlobal.URL);
			if (leftNavigation.logoutLabel.isDisplayed()) {
				if (!(leftNavigation.loggedInUserLink.getText())
						.equalsIgnoreCase(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME)) {
					Log.info(" Log out and re-login as Root Admin user ");
					leftNavigation.logoutLabel.clickByJavaScript();
					Browser.sleep(3000);
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
	@Before(value = "@CreateAdminGroup", order = 3)
	public void create_AdminGroup() throws Throwable {
		if (CommonUtils.adminGroup.isEmpty()) {
			Log.info("Admin Group is not created yet");
			leftNavigation.groupsLink.click();
			groupsSummaryPage.newGroupButton.exists(2);
			groupsSummaryPage.newGroupButton.click();
			GroupSteps.createAdminGroup();
			GroupSteps.filterGroupByName();
			GroupSteps.selectGroupAndAssignAdminGroupPermisisons();
		}
	}

	@Before(value = "@CreateSupportGroup", order = 4)
	public void create_SupportGroup() throws Throwable {
		if (CommonUtils.supportGroup.isEmpty()) {
			Log.info("Support Group is not created yet");
			Browser.open(AcquirerPortalGlobal.GROUP_URL);
			groupsSummaryPage.newGroupButton.exists(5); /* we need have explicit wait */
			groupsSummaryPage.newGroupButton.click();
			GroupSteps.createSupportGroup();
			GroupSteps.filterGroupByName();
			GroupSteps.selectGroupAndAssignSupportGroupPermisisons();
		}
	}

	@Before(value = "@create10MinuteEmail", order = 0)
	public void create_10MinuteEmail() throws Throwable {
		try {
			Browser.open(AcquirerPortalGlobal.EMAIL_URL, 20);
			emailPage.mailAddress.scrollIntoView();
			tempEmail = emailPage.mailAddress.getAttribute("value");
			Log.info("getting random email from 10minutes email site" + tempEmail);
			Browser.sleep(1000);
		} catch (WebDriverException e) {
			Log.info(" refreshing browser ");
			Browser.refresh();
			Log.info("retry getting random email from 10minutes email site" + tempEmail);
			Browser.open(AcquirerPortalGlobal.EMAIL_URL, 20);
			emailPage.mailAddress.scrollIntoView();
			tempEmail = emailPage.mailAddress.getAttribute("value");
			Browser.sleep(1000);
		}
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
		Log.info("logging in as: " + AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		// Browser.open(AcquirerPortalGlobal.URL);
		loginPage.navigateToLoginPage();
		login(AcquirerPortalGlobal.GP_ADMIN_USER_NAME, AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
		leftNavigation.merchantsLink.exists(5);
		CommonUtils.userName_GBL = AcquirerPortalGlobal.GP_ADMIN_USER_NAME;
	}

	/**
	 * login as root admin
	 */
	public static void loginAsRootAdministrator() {
		Log.info("logging in as: " + AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		Browser.open(AcquirerPortalGlobal.URL);
		login(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME, AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD);
		leftNavigation.portalUserLink.exists(5);
		CommonUtils.userName_GBL = AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME;
	}

	/**
	 * Login to Acquirer portal
	 * 
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
