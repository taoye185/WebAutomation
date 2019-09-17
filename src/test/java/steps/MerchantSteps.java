package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import acquirerportal.AcquirerPortalGlobal;
import acquirerportal.CommonUtils;
import acquirerportal.pageobjects.merchants.MerchantRegistrationPage;
import acquirerportal.pageobjects.merchants.MerchantsPage;
import coreutils.Browser;
import coreutils.GridCommon;
import coreutils.Log;

import org.junit.Assert;
import org.openqa.selenium.Keys;

public class MerchantSteps {
	MerchantsPage merchantsPage = new MerchantsPage();
	MerchantRegistrationPage merchantRegistrationPage = new MerchantRegistrationPage();

	@Given("^User successfully navigated to merchant Summary Page$")
	public void user_successfully_navigated_to_Merchant_Summary_Page() throws Throwable {
		merchantsPage.navigateToMerchantSummaryPage();
		Browser.sleep(3000);
		Log.info("current " + Browser.getDriver().getCurrentUrl());
		Log.info("expected  " + AcquirerPortalGlobal.MERCHANTS_URL);
		Assert.assertTrue("User is not navigated to Merchant's Page",
				Browser.getDriver().getCurrentUrl().equalsIgnoreCase(AcquirerPortalGlobal.MERCHANTS_URL));

	}

	@When("^user click on New Merchant button and navigates to merchants Registration Page$")
	public void user_click_on_New_Merchant_button() throws Throwable {
		merchantsPage.newMerchantButton.click();
		Assert.assertTrue("User is not navigated to Merchant's Registration's Page",
				merchantRegistrationPage.newMerchantRegistrationLabel.getText()
						.equalsIgnoreCase(AcquirerPortalGlobal.MERCHNAT_REGISTRATION_TITLE));
	}

	@Given("^provide details to create a new Merchant$")
	public void provide_details_to_create_a_new_Merchant() throws Throwable {

		CommonUtils.merchantBusinessUserName = AcquirerPortalGlobal.MERCHANT_BUSINESS_NAME;
		merchantRegistrationPage.merchantRegistrationDivisionFilterTexbox.sendKeys("Global Payments");
		Browser.sleep(2000);				
		merchantRegistrationPage.merchantRegistrationDivisionFilterTexbox.sendKeys(Keys.ENTER);	
		merchantRegistrationPage.businessNameTextbox.exists(10);
		merchantRegistrationPage.businessNameTextbox.sendKeys(CommonUtils.merchantBusinessUserName);
		merchantRegistrationPage.address.sendKeys("No 23, 1street");
		merchantRegistrationPage.city.sendKeys("Ottawa");
		merchantRegistrationPage.zipCode.sendKeys("K1P");
		merchantRegistrationPage.country.sendKeys("Canada", Keys.ENTER);
		merchantRegistrationPage.state.exists(5);
		merchantRegistrationPage.state.sendKeys("Alberta");
		Browser.sleep(1000);
		merchantRegistrationPage.state.sendKeys(Keys.ENTER, Keys.TAB);
		// Personal Information
		merchantRegistrationPage.mposUserNameTextbox.clearAndSendKeys("AetAutomation");
		merchantRegistrationPage.userEmailTextbox.clearAndSendKeys(BackgroundSteps.tempEmail); // CommonUtils.tempEmail
		CommonUtils.merchantEmailAddress= BackgroundSteps.tempEmail;
		merchantRegistrationPage.mposUserPhoneTextbox.clearAndSendKeys("1234567882");
		merchantRegistrationPage.userLanguageOption.sendKeys("English", Keys.ENTER, Keys.TAB);
		Browser.sleep(1000);
		merchantRegistrationPage.userLanguageOption.sendKeys(Keys.ENTER, Keys.TAB);
		// Processing details
		merchantRegistrationPage.MerchantIDTextbox.sendKeys(AcquirerPortalGlobal.MERCHANT_ID);
		merchantRegistrationPage.merchantCategoryCode.clearAndSendKeys(AcquirerPortalGlobal.MERCHANT_CATEGORY_CODE);		
		merchantRegistrationPage.timeZoneTextField.sendKeys("Pacific Time");
		Browser.sleep(1000);
		merchantRegistrationPage.timeZoneTextField.sendKeys(Keys.ENTER);
		merchantRegistrationPage.manualEntry.click();
		// Terminals
		merchantRegistrationPage.terminalID.clearAndSendKeys(AcquirerPortalGlobal.MERCHANT_TERMINAL);
		merchantRegistrationPage.addTerminalButton.click();	
		merchantRegistrationPage.createMerchant.exists(5);
		merchantRegistrationPage.createMerchant.click();		
		Log.info("Merchant " + CommonUtils.merchantBusinessUserName + " is created");
	}

	@Given("^new merchant record in the Merchant Summary Page is displayed$")
	public void new_merchant_record_in_the_Merchant_Summary_Page_is_displayed() throws Throwable {
		merchantsPage.merchantNameFilterTextField.sendKeysToFilter(CommonUtils.merchantBusinessUserName);
		Assert.assertNotNull("Merchant is not listed",
				GridCommon.getGridRowElement(merchantsPage.merchantListGrid, CommonUtils.merchantBusinessUserName));
	}
	


}
