package steps;

import utils.SetUp;
import pageobjects.BasePage;
import pageobjects._login.LoginPage;
import pageobjects.merchants.MerchantsSummaryPage;
import utils.AssertUtil;
import utils.CommonUtils;
import cucumber.api.java.en.Then;

public class LoginSteps {

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
			System.out.println("CURRENT PAGE IS " + BasePage.getCurrentPage() + " ");
			CommonUtils.setUpUsers(username);
			username_GBL = CommonUtils.username_GBL;
			password_GBL = CommonUtils.password_GBL;
			username_LBL_GBL = CommonUtils.username_LBL_GBL;
			loginPage.usernameTxtBox.sendKeys(username_GBL);
			loginPage.passwordTxtBox.sendKeys(password_GBL);
			loginPage.forgetPasswordLink.isDisplayed();
			loginPage.signInBtn.click();
		} catch (Exception ex) {
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("Navigate as user " + username_LBL_GBL + "is  Failed");
			SetUp.teardown();
		}
	}

	@Then("^User navigates to the Merchants Summary Page and validate user name in left navigation$")
	public void user_navigates_to_the_Merchants_Summary_Page_and_validate_user_name_in_left_navigation() {
		try {

			comUtil.waitForPageLoaded(10000);
			System.out.println("CURRENT PAGE IS " + BasePage.getCurrentPage() + " ");
			AssertUtil.assertEq(merchantsSummaryPage.usernameLabel().getText(), username_LBL_GBL,
					"Verify user " + username_LBL_GBL + " login to Merchants Summary Page ");
			AssertUtil.AggregatedResult();
			System.out.println("Navigate as user " + username_LBL_GBL + " is Passed");
			System.out.println("====USER========\n" + username_LBL_GBL + "\n=====LOGGED IN=======");
			comUtil.setWaitInSeconds(5);
			SetUp.teardown();

		} catch (Exception ex) {
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("User " + username_LBL_GBL + " navigation to Merchants Summery Page " + "is  Failed");
			comUtil.setWaitInSeconds(5);
			SetUp.teardown();

		}
	}

}
