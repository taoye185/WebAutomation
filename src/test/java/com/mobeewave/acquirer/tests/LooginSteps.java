package com.mobeewave.acquirer.tests;

import org.junit.Assert;

import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.pageObjects.BasePage;
import com.mobeewave.acquirer.pageObjects.LoginPage;
import com.mobeewave.acquirer.pageObjects.MerchantsSummaryPage;
import com.mobeewave.acquirer.utils.AssertUtil;
import com.mobeewave.acquirer.utils.CommonUtils;

import cucumber.api.java.en.Then;

public class LooginSteps {

	private LoginPage loginPage = new LoginPage();
	private MerchantsSummaryPage merchantsSummaryPage = new MerchantsSummaryPage();
	private static String username_GBL = "";
	private static String password_GBL = "";
	private static String username_LBL_GBL = "";
	CommonUtils comUtil = new CommonUtils();

	@Then("^User enters valid credentials \"([^\"]*)\" and password in login Page$")
	public void user_enters_valid_credentials_and_password_in_login_Page(String username) {
		try {

			comUtil.waitForPageLoaded(10000);
			System.out.println("CURRENT PAGE IS " + BasePage.getcurrentPage() + " ");

			// loginPage.isElementsveralapped();
			CommonUtils.setUpUsers(username);
			username_GBL = CommonUtils.username_GBL;
			password_GBL = CommonUtils.password_GBL;
			username_LBL_GBL = CommonUtils.username_LBL_GBL;
			loginPage.usernameTxtBox().sendKeys(username_GBL);

			loginPage.passwordTxtBox().sendKeys(password_GBL);
			loginPage.forgetPasswordLink().isDisplayed();
			loginPage.forgetPasswordLink().isDisplayed();
			loginPage.signInBtn().click();
			loginPage.isElementsveralapped();
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println("Navigate as user " + username_LBL_GBL + "is  Failed");
			SetUp.teardown();
		}
	}

	@Then("^User navigates to the Merchants Summary Page and validate user name in left navigation$")
	public void user_navigates_to_the_Merchants_Summary_Page_and_validate_user_name_in_left_navigation() {
		try {

			comUtil.waitForPageLoaded(10000);
			System.out.println("CURRENT PAGE IS " + BasePage.getcurrentPage() + " ");
			// Assert.assertEquals(username_LBL_GBL,
			// merchantsSummaryPage.usernameLabel().getText());

			// AssertUtil.AreEquals(merchantsSummaryPage.usernameLabel(),username_LBL_GBL);
			// AssertUtil.AreEquals(merchantsSummaryPage.usernameLabel(),"test");
			// AssertUtil.NoExceptions();
			AssertUtil.AreEquals(merchantsSummaryPage.usernameLabel(), username_LBL_GBL);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			AssertUtil.AggregatedResult();
			// AssertUtil.NoExceptions();

			System.out.println("Navigate as user " + username_LBL_GBL + " is Passed");
			System.out.println("====USER========\n" + username_LBL_GBL + "\n=====LOGGED IN=======");
			comUtil.setWaitinSeconds(5);
			SetUp.teardown();

		} catch (Exception ex) {
			System.out.println("User " + username_LBL_GBL + " navigation to Merchants Summery Page " + "is  Failed");
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			comUtil.setWaitinSeconds(5);
			SetUp.teardown();

		}
	}

}
