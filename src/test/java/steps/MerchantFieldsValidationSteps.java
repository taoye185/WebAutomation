package steps;

import java.lang.reflect.Type;

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
		 Assert.assertEquals("User is navigated to Merchnats Page", Browser.getDriver().getCurrentUrl(),
		 AcquirerPortalGlobal.MERCHANTS_URL);	
		 merchantsPage.newMerchantButton.click();
	  }

	@When ("^User leave the \\\"([^\\\"]*)\\\" empty$") 
	  public void User_leave_the_merchant_ID_empty(String FieldName) {
		switch(FieldName) {
		case "MerchantIDTextbox":{
			MerchantRegistrationPage.MerchantIDTextbox.sendKeys("");
			MerchantRegistrationPage.MerchantIDTextbox.sendKeys(Keys.TAB);
		}
		
	  case "mposUserName":{
			MerchantRegistrationPage.mposUserNameTextbox.sendKeys("");
			MerchantRegistrationPage.mposUserNameTextbox.sendKeys(Keys.TAB);
		}
	  case "UserEmail" :{
		  MerchantRegistrationPage.userEmailTextbox.sendKeys("");
			MerchantRegistrationPage.userEmailTextbox.sendKeys(Keys.TAB);
	  }
	  
		
	  }
	}
	@Then("^An \\\\\\\"([^\\\\\\\"]*)\\\\\\\" shall be displayed under the  \\\\\\\"([^\\\\\\\"]*)\\\\\\\" field$") 
	 public void An_error_message_shall_be_displayed_under_the_merchant_ID_field(String FieldName) {
		switch(FieldName) {
		case "MerchantIDTextbox":{
			String actualErrorMessage = MerchantRegistrationPage.MerchantIDErrorMessage.getText();
			Assert.assertTrue("No Validation for the Merchant ID",actualErrorMessage.contains("Please enter the merchant ID"));
		}
		
	  case "mposUserName":{
		  String actualErrorMessage = MerchantRegistrationPage.MerchantIDErrorMessage.getText();
			Assert.assertTrue("No Validation for the Business Name",actualErrorMessage.contains("Please enter a name"));
		}
		}
		}
		
	@And ("^Create Merchant button is not active$")
	public void Create_Merchant_button_is_not_active$() {
		MerchantRegistrationPage.MerchantCreateButton.scrollIntoView();
		Assert.assertTrue(!(MerchantRegistrationPage.MerchantCreateButton.isEnabled()));

	  }
}
	
	/*@When ("^User leave the merchant ID empty$") 
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
	

	
