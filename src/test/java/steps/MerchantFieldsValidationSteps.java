package steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.Map;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import acquirerportal.AcquirerPortalGlobal;
import acquirerportal.pageobjects.merchants.MerchantRegistrationPage;
import acquirerportal.pageobjects.merchants.MerchantsPage;
import coreutils.Browser;
import coreutils.Log;

public class MerchantFieldsValidationSteps

{
	public static MerchantRegistrationPage MerchantRegistrationPage = new MerchantRegistrationPage();
	public static MerchantsPage merchantsPage = new MerchantsPage();

	@Given("^User successfully navigated to New Merchant Page$")
	public void User_successfully_navigated_to_New_Merchant_Page() {
		merchantsPage.navigateToMerchantSummaryPage();
		Assert.assertEquals("User is navigated to Merchants Page", Browser.getDriver().getCurrentUrl(),
				AcquirerPortalGlobal.MERCHANTS_URL);
	}

	@When("^User click on New merchant button$")
	public void User_click_on_New_merchant_button() {
		merchantsPage.newMerchantButton.click();
	}

	@When("^User select the division from dropdown$")
	public void User_select_the_division_from_dropdown(DataTable division) {
		List<Map<String, String>> list = division.asMaps(String.class, String.class);
		MerchantRegistrationPage.merchantRegistrationDivisionFilterTexbox.sendKeys(list.get(0).get("division"));
		Browser.sleep(1000);
		MerchantRegistrationPage.merchantRegistrationDivisionFilterTexbox.sendKeys(Keys.ENTER);
	}

	@When("^User leave the \"([^\"]*)\" empty$")
	public void User_leave_the_merchant_ID_empty(String FieldName) {
		switch (FieldName.toUpperCase()) {
		case "BUSINESSNAME": {

			MerchantRegistrationPage.businessNameTextbox.clearAndSendKeys("", Keys.TAB);
			break;
		}
		case "ADDRESS": {
			MerchantRegistrationPage.addressTextbox.clearAndSendKeys("", Keys.TAB);
			break;
		}
		case "CITY": {
			MerchantRegistrationPage.cityTextbox.scrollIntoView();
			MerchantRegistrationPage.cityTextbox.clearAndSendKeys("", Keys.TAB);
			break;
		}
		case "ZIPCODE": {
			MerchantRegistrationPage.zipCodeTextbox.scrollIntoView();
			MerchantRegistrationPage.zipCodeTextbox.clearAndSendKeys("", Keys.TAB);
			break;
		}
		case "MPOSUSERNAME": {
			MerchantRegistrationPage.mposUserNameTextbox.scrollIntoView();
			MerchantRegistrationPage.mposUserNameTextbox.clearAndSendKeys("", Keys.TAB);
			break;
		}
		case "MPOSUSEREMAIL": {
			MerchantRegistrationPage.userEmailTextbox.scrollIntoView();
			MerchantRegistrationPage.userEmailTextbox.clearAndSendKeys("", Keys.TAB);
			break;
		}
		}
	}

	@Then("^An error message \"([^\"]*)\" shall be displayed under the missing \"([^\"]*)\" field$")
	public void An_error_message_shall_be_displayed_under_the_missing_field(String expectedErrorMessage,
			String fieldName) {
		String actualErrorMessage = MerchantRegistrationPage.errorTooltipLabel.getText();
		Log.info(actualErrorMessage);
		switch (fieldName.toUpperCase()) {
		case "BUSINESSNAME": {
			Assert.assertTrue("Business Name error-tooltip is not displayed Correctly",
					actualErrorMessage.equalsIgnoreCase(expectedErrorMessage));
			break;
		}
		case "ADDRESS": {
			Assert.assertTrue("Address error-tooltip is not displayed Correctly",
					actualErrorMessage.equalsIgnoreCase(expectedErrorMessage));
			break;
		}
		case "CITY": {
			Assert.assertTrue("City error-tooltip is not displayed Correctly",
					actualErrorMessage.equalsIgnoreCase(expectedErrorMessage));
			break;
		}
		case "ZIPCODE": {
			Assert.assertTrue("zipCode error-tooltip is not displayed Correctly",
					actualErrorMessage.equalsIgnoreCase(expectedErrorMessage));
			break;
		}
		case "MPOSUSERNAME": {
			Assert.assertTrue("Merchant full name error-tooltip is not displayed Correctly",
					actualErrorMessage.equalsIgnoreCase(expectedErrorMessage));
			break;
		}
		case "MPOSUSEREMAIL": {
			Assert.assertTrue("Merchant Email error-tooltip is not displayed Correctly",
					actualErrorMessage.equalsIgnoreCase(expectedErrorMessage));
			break;
		}
		default: {
			Log.info(fieldName + " doesn't exist ");
		}
		}
	}

	@Then("^Create Merchant button is not active$")
	public void Create_Merchant_button_is_not_active$() {
		MerchantRegistrationPage.createMerchant.scrollIntoView();
		Assert.assertTrue(!(MerchantRegistrationPage.createMerchant.isEnabled()));

	}
}
