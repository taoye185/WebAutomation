package steps;

import org.junit.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;
import pageobjects.login.LoginPage;
import pageobjects.merchants.MerchantsPage;
import utils.Browser;
import utils.CommonUtils;
import utils.Global;
import utils.Log;

public class LoginSteps {

	public static LoginPage loginPage = new LoginPage();	
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static Browser browser;
	

	@Given("^User is successfully navigated to Home Page$")
	public void user_is_successfully_navigated_to_Home_Page() throws Exception {			
		//browser = new Browser(Global.browserType);
		browser = new Browser(Global.BROWSER);
		Browser.open(AcquirerPortalGlobal.URL);
		Thread.sleep(1000);
		//Assert.assertTrue("User is landed on home page ", (loginPage.passwordTxtBox.isDisplayed()));
	}
	
	@When("^User enter valid username and password and hit Login button$")
	public void user_enter_valid_username_and_password() throws Throwable {
		loginPage.usernameTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
		loginPage.passwordTxtBox.sendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
		loginPage.signInBtn.click();
	}
	
	@When("^User enter valid \"([^\"]*)\" and \"([^\"]*)\" and hit Login button$")
	public void user_enter_valid_and_and_hit_Login_button(String username, String password) throws Throwable {
		//CommonUtils.setUpUsers(username);
		CommonUtils.userLabel_GBL = username;
		CommonUtils.password_GBL=password;		
	    loginPage.usernameTxtBox.sendKeys(CommonUtils.username_GBL);
		loginPage.passwordTxtBox.sendKeys(CommonUtils.password_GBL);
		loginPage.signInBtn.click();
	}

	@Then("^User navigates to portal user page$")
	public void user_navigates_to_portal_user_page() throws Throwable {		
		Thread.sleep(10000);
		System.out.println(Browser.getDriver().getCurrentUrl());
		Assert.assertEquals("User is navigated to Portal User Page", Browser.getDriver().getCurrentUrl(),AcquirerPortalGlobal.PORTALUSER_URL);
	
	}
	
	@Given("^Validate user name label from the left navigation is successful$")
	public void Validate_username_label_from_leftNav() throws Throwable {	
		Thread.sleep(1000);
		leftNavigation.inituserLink(CommonUtils.userLabel_GBL);		
		Log.info(" leftNavigation.userLink  " + leftNavigation.userLink.getText());
		Assert.assertTrue("User is logged in ", (leftNavigation.userLink.getText().equalsIgnoreCase(CommonUtils.userLabel_GBL)));  
	}
	
	public static void setBrowserType(){
		Log.info(" in before");
		Global.browserType = System.getProperty("GBL_WEB_BROWSER"); 
	}

}
