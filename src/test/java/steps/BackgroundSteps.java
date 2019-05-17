package steps;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.login.LoginPage;
import pageobjects.merchants.MerchantsPage;
import utils.Browser;
import utils.CommonUtils;

public class BackgroundSteps {

	public static LoginPage loginPage = new LoginPage();
	public static MerchantsPage merchantsPage = new MerchantsPage();

	@After("@independentTest")
	public static void teardown() {
		try {
			WebDriver _driver = Browser.getDriver();
			if (_driver == null) {
				return;
			}
			_driver.quit();
			_driver = null;
			System.out.println("\n closing browser and Quit driver..................\n");
		} catch (Exception ex) {
			System.out.println("====================    " + ex.getMessage() + "   =============================");
			System.out.println("Driver quit failed ...... ");
		}
	}

	@Before("@loginAsGPAdmin")
	public static void loginAsGPAdmin() {
		Browser.open(AcquirerPortalGlobal.URL);
		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.GP_ADMIN_LABEL;
		loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		merchantsPage.newMerchantButton.exists(3);
	}

	@Before("@loginAsRootAdmin")
	public static void loginAsRootAdmin() {
		Browser.open(AcquirerPortalGlobal.URL);
		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.ROOT_ADMIN_LABEL;
		loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		merchantsPage.newMerchantButton.exists(3);
	}

}
