package steps;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
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
	//public static String groupName = "";

	@Before(value="@loginAsGPAdmin",order=0)
	public static void login_As_GP_Admin() {
		try {
			if (leftNavigation.logoutLabel.isDisplayed()) {			
				if (leftNavigation.loggedInUserLink.getText() != AcquirerPortalGlobal.GP_ADMIN_LABEL) {
					leftNavigation.logoutLabel.click();
					loginAsGlobalPaymentsAdministrator();  /* login back as GP admin */
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
				if (leftNavigation.loggedInUserLink.getText() != AcquirerPortalGlobal.ROOT_ADMIN_LABEL) {
					leftNavigation.logoutLabel.click();
					loginAsRootAdministrator(); /* login back as root admin */
				}
				return;
			}
		} catch (TimeoutException ex) {
			loginAsRootAdministrator();
		}
		/*catch (ElementClickInterceptedException ex) {
			loginAsRootAdministrator();
		}*/
	}

	@Before("@navigateToGroupSummaryPage")
	public static void navigate_To_Group_Summary_Page() {
		try {
			Browser.open(AcquirerPortalGlobal.GROUP_URL);
		} catch (TimeoutException ex) {

		}
	}
	
	@Before(value="@CreateAdminGroup",order=1)	
	public void create_AdminGroup() throws Throwable {
		if (CommonUtils.adminGroup.isEmpty()) {
			Log.info("Admin Group is not created yet");
			leftNavigation.initLeftNavLink("Groups").click();
			groupsSummaryPage.newGroupButton
					.exists(2000);		
			groupsSummaryPage.newGroupButton.click();			
			GroupSteps.CreateAdminGroup();
			GroupSteps.filterGroupByName();
			GroupSteps.selectGroupandassignAdminGroupPermisisons();

		}
	}

	@Before(value="@CreateSupportGroup",order=2)	
	public void create_SupportGroup() throws Throwable {
		if (CommonUtils.supportGroup.isEmpty()) {
			Log.info("Support Group is not created yet");
			leftNavigation.initLeftNavLink("Groups").click();
			groupsSummaryPage.newGroupButton
					.exists(2000); /* we need have implicit wait */
			groupsSummaryPage.newGroupButton.click();
			GroupSteps.createSupportGroup();
			GroupSteps.filterGroupByName();
			GroupSteps.selectGroupandassignSupportGroupPermisisons();
		}
	}
	
	@After("@logout")
	public static void logout() {
		if (leftNavigation.logoutLabel.isDisplayed()) {
			leftNavigation.logoutLabel.click();
		}
		loginPage.usernameTxtBox.exists(3);
	}

	/**
	 * login as gp admin
	 */
	public static void loginAsGlobalPaymentsAdministrator() {

		Browser.open(AcquirerPortalGlobal.URL);
		Log.info("logging in as: " + AcquirerPortalGlobal.GP_ADMIN_LABEL);
		loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		merchantsPage.newMerchantButton.exists(4);
		CommonUtils.username_GBL = AcquirerPortalGlobal.GP_ADMIN_USER_NAME;
		CommonUtils.password_GBL = AcquirerPortalGlobal.GP_ADMIN_PASSWORD;
		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.GP_ADMIN_LABEL;
	}

	/**
	 * login as root admin
	 */
	public static void loginAsRootAdministrator() {

		Browser.open(AcquirerPortalGlobal.URL);
		Log.info("logging in as: " + AcquirerPortalGlobal.ROOT_ADMIN_LABEL);		
		loginPage.usernameTxtBox.exists(15);
		loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		PortalUsersPage.newPortalUserButton.exists(4);
		CommonUtils.username_GBL = AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME;
		CommonUtils.password_GBL = AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD;
		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.ROOT_ADMIN_LABEL;
	}	
}
