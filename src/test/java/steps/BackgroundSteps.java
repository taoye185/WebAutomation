package steps;

import org.openqa.selenium.TimeoutException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;
import pageobjects.login.LoginPage;
import pageobjects.merchants.MerchantsPage;
import pageobjects.portalusers.PortalUsersPage;
import utils.Browser;
import utils.Log;

public class BackgroundSteps {

	public static LoginPage loginPage = new LoginPage();
	public static MerchantsPage merchantsPage = new MerchantsPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static PortalUsersPage PortalUsersPage = new PortalUsersPage();

	@Before("@loginAsGPAdmin")
	public static void login_As_GP_Admin() {
		try {
			if (leftNavigation.logoutLabel.isDisplayed()) {
				if (leftNavigation.userLink.getText() == AcquirerPortalGlobal.ROOT_ADMIN_LABEL) {
					leftNavigation.logoutLabel.click();
					loginAsGlobalPaymentsAdministrator(); /* login back as global payment admin */
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
				if (leftNavigation.userLink.getText() != AcquirerPortalGlobal.ROOT_ADMIN_LABEL) {
					leftNavigation.logoutLabel.click();
					loginAsRootAdministrator(); /* login back as root admin */
				}
				return;
			}
		} catch (TimeoutException ex) {
			loginAsRootAdministrator();
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
	}

	/**
	 * login as root admin
	 */
	public static void loginAsRootAdministrator() {

		Browser.open(AcquirerPortalGlobal.URL);
		Log.info("logging in as: " + AcquirerPortalGlobal.ROOT_ADMIN_LABEL);
		loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		PortalUsersPage.newPortalUserButton.exists(4);
	}

}
