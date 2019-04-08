package com.mobeewave.acquirer.tests;

import com.mobeewave.acquirer.tests.BackgroundSteps;
import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.pageObjects.BasePage;
import com.mobeewave.acquirer.pageObjects.LeftNavigation;
import com.mobeewave.acquirer.pageObjects.LoginPage;
import com.mobeewave.acquirer.pageObjects.MerchantsSummaryPage;
import com.mobeewave.acquirer.utils.AssertUtil;
import com.mobeewave.acquirer.utils.CommonUtils;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class BackgroundSteps {

	private static String client_GBL = "";
	private static String browser_GBL = "";
	private static String username_GBL = "";
	private static String password_GBL = "";
	private static String username_LBL_GBL = "";
	CommonUtils comUtil = new CommonUtils();
	private LoginPage loginPage = new LoginPage();
	private MerchantsSummaryPage merchantsSummaryPage = new MerchantsSummaryPage();
	private LeftNavigation leftNav = new LeftNavigation();

	@Given("^User is successfully navigated to Home Page$")
	public void user_is_successfully_navigated_to_Home_Page() {
		try {
			browser_GBL = SetUp.getBrowser();
			client_GBL = SetUp.getClient();
			SetUp.setupDriver(client_GBL, browser_GBL);
			comUtil.setWaitInSeconds(10);
		} catch (Exception ex) {
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("Navigation Failed - Login Scenario");
			SetUp.teardown();
		}
	}

	// Navigation to Merchant Summary Page
	@Given("^User \"([^\"]*)\" successfully navigated to Merchant Summary Page$")
	public void user_successfully_navigated_to_Merchant_Summary_Page(String userName) {
		login(userName);
		AssertUtil.assertEq(merchantsSummaryPage.usernameLabel().getText(), username_LBL_GBL,
				"Verify user " + username_LBL_GBL + " login to Merchants Summary Page ");
	}

	// Navigation to Portal User Page
	@Given("^User \"([^\"]*)\" successfully navigated to Portal Users Page$")
	public void user_successfully_navigated_to_Portal_Users_Page(String userName) {
		login(userName);

		try {
			Thread.sleep(2000);
			leftNav.leftNavigationLink(BasePage.locator("PORTAL_USERS")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void login(String userName) {
		browser_GBL = SetUp.getBrowser();
		client_GBL = SetUp.getClient();
		SetUp.setupDriver(client_GBL, browser_GBL);
		comUtil.setWaitInSeconds(10);
		CommonUtils.setUpUsers(userName);
		username_GBL = CommonUtils.username_GBL;
		password_GBL = CommonUtils.password_GBL;
		username_LBL_GBL = CommonUtils.username_LBL_GBL;
		loginPage.usernameTxtBox().sendKeys(username_GBL);
		loginPage.passwordTxtBox().sendKeys(password_GBL);
		loginPage.signInBtn().click();
		comUtil.setWaitInSeconds(3);
		comUtil.waitForPageLoaded(10000);
	}
}
