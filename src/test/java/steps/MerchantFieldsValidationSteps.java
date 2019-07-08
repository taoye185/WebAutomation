package steps;


import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.merchants.MerchantRegistrationPage;
import pageobjects.merchants.MerchantsPage;
import utils.Browser;

public class MerchantFieldsValidationSteps  


{
	public static MerchantRegistrationPage MerchantRegistrationPage = new MerchantRegistrationPage();
	MerchantsPage merchantsPage = new MerchantsPage();
	String FieldName;
	
	@Given("^User successfully navigated to New Merchant Page$")
	  public void User_successfully_navigated_to_New_Merchant_Page(){
	
		 merchantsPage.navigateToMerchantSummaryPage();
		 Assert.assertEquals("User is navigated to Merchnats Page", Browser.getDriver().getCurrentUrl(), AcquirerPortalGlobal.MERCHANTS_URL);
		 merchantsPage.newMerchantButton.click();
		 MerchantRegistrationPage.newMerchantRegistrationDivisionDropDown.selectDropDownItem("Global Payments");
	}
	

	@When ("^User leave the \"([^\"]*)\" empty$") 
	  public void User_leave_the_merchant_ID_empty(String FieldName) {
		switch(FieldName) {
		 case "businessName":{
				MerchantRegistrationPage.businessNameTextbox.sendKeys("");
				MerchantRegistrationPage.businessNameTextbox.sendKeys(Keys.TAB);
				break; 
				
			}
		 case "address":{
				MerchantRegistrationPage.addressTextbox.sendKeys("");
				MerchantRegistrationPage.addressTextbox.sendKeys(Keys.TAB);
				break; 
			}
		 case "city":{
				MerchantRegistrationPage.cityTextbox.sendKeys("");
				MerchantRegistrationPage.cityTextbox.sendKeys(Keys.TAB);
				break; 
			}
		 case "zipCode":{
				MerchantRegistrationPage.zipCodeTextbox.sendKeys("");
				MerchantRegistrationPage.zipCodeTextbox.sendKeys(Keys.TAB);
				break; 
			}
		 
		 case "mposUserName":{
				MerchantRegistrationPage.mposUserNameTextbox.sendKeys("");
				MerchantRegistrationPage.mposUserNameTextbox.sendKeys(Keys.TAB);
				break; 
			}
		 case "mposUserEmail":{
				MerchantRegistrationPage.userEmailTextbox.sendKeys("");
				MerchantRegistrationPage.userEmailTextbox.sendKeys(Keys.TAB);
				break; 
			}
		 
	  }
	}
	@Then("^An error message shall be displayed under the missing \"([^\"]*)\" field$") 
	 public void An_error_message_shall_be_displayed_under_the_missing_field(String FieldName) {
		String actualErrorMessage = MerchantRegistrationPage.errortooltiptext.getText();
	System.out.append(actualErrorMessage);

		switch(FieldName.toUpperCase()) {
		case "BUSINESSNAME":{
			Assert.assertTrue("Business Name error-tooltip is not displayed Correctly",actualErrorMessage.equalsIgnoreCase("Please enter a business name"));
			
			break; 
		}
		case "ADDRESS":{
			Assert.assertTrue("Address error-tooltip is not displayed Correctly",actualErrorMessage.equalsIgnoreCase("Please enter an address"));
			break; 
		}
		case "CITY":{
			Assert.assertTrue("City error-tooltip is not displayed Correctly",actualErrorMessage.equalsIgnoreCase("Please enter a City"));
			break; 
		}
		case "ZIPCODE":{
			Assert.assertTrue("zipCode error-tooltip is not displayed Correctly",actualErrorMessage.equalsIgnoreCase("Please enter a postal / ZIP code"));
			break; 
		}
		case "MPOSUSERNAME":{
			Assert.assertTrue("Merchant full name error-tooltip is not displayed Correctly",actualErrorMessage.equalsIgnoreCase("Please enter a name"));
			break; 
		}
		case "MPOSUSEREMAIL":{
			Assert.assertTrue("Merchant Email error-tooltip is not displayed Correctly",actualErrorMessage.equalsIgnoreCase("Please enter an email"));
			break; 
		}
		}
		}
		
	@And ("^Create Merchant button is not active$")
	public void Create_Merchant_button_is_not_active$() {
		MerchantRegistrationPage.MerchantCreateButton.scrollIntoView();
		Assert.assertTrue(!(MerchantRegistrationPage.MerchantCreateButton.isEnabled()));

	  }
}
	
/*  @When ("^User leave the merchant ID empty$") 
	  public void User_leave_the_merchant_ID_empty() {
		MerchantRegistrationPage.MerchantIDTextbox.sendKeys("");
		MerchantRegistrationPage.MerchantIDTextbox.sendKeys(Keys.TAB);
	  }

	@Then("^An error message shall be displayed under the merchant ID field$") 
	 public void An_error_message_shall_be_displayed_under_the_merchant_ID_field() {
		String actualErrorMessage = MerchantRegistrationPage.MerchantIDErrorMessage.getText();
		Assert.assertTrue("No Validation for the Merchant ID",actualErrorMessage.contains("Please enter the merchant ID"));
	  }
*/
	

	
