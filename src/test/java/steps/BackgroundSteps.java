package steps;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;
import pageobjects.login.LoginPage;
import pageobjects.merchants.MerchantsPage;
import utils.Browser;
import utils.CommonUtils;

public class BackgroundSteps {

	public static LoginPage loginPage = new LoginPage();
	public static MerchantsPage merchantsPage = new MerchantsPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();


	@Before("@loginAsGPAdmin")
	public static void loginAsGPAdmin() {
		try{
		if(leftNavigation.logoutLabel.isDisplayed()){
			return;
		}
		
		}catch(TimeoutException ex){
			Browser.open(AcquirerPortalGlobal.URL);
			CommonUtils.userLabel_GBL = AcquirerPortalGlobal.GP_ADMIN_LABEL;
			loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
			loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
			loginPage.signInBtn.click();
			merchantsPage.newMerchantButton.exists(3);
		}
		
	}

	@Before("@loginAsRootAdmin")
	public static void loginAsRootAdmin() {
		try{
			if(leftNavigation.logoutLabel.isDisplayed()){
				return;
			}
		}catch(TimeoutException ex){
		Browser.open(AcquirerPortalGlobal.URL);
		CommonUtils.userLabel_GBL = AcquirerPortalGlobal.ROOT_ADMIN_LABEL;
		loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
		merchantsPage.newMerchantButton.exists(3);
			}
		
	}
	
	@After
	public static void logout(){
		//loginPage.
	}

}
