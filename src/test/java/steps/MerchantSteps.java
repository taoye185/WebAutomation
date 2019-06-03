package steps;

import cucumber.api.java.en.Given;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.merchants.MerchantRegistrationPage;
import pageobjects.merchants.MerchantsPage;
import utils.Browser;
import cucumber.api.java.en.Then;

import org.junit.Assert;

public class MerchantSteps {
  MerchantsPage merchantsPage = new MerchantsPage();
  MerchantRegistrationPage merchantRegistrationPage = new MerchantRegistrationPage();

  @Given("^User successfully navigated to merchant Summary Page$")
  public void user_successfully_navigated_to_Merchant_Summary_Page() throws Throwable {
    merchantsPage.navigateToMerchantSummaryPage();
    Assert.assertEquals("User is navigated to Merchant's Page", Browser.getDriver().getCurrentUrl(),
        AcquirerPortalGlobal.MERCHANTS_URL);

  }

  @Given("^user click on New Merchant button and navigates to merchants Registration Page$")
  public void user_click_on_New_Merchant_button() throws Throwable {
    merchantsPage.newMerchantButton.click();
    Assert.assertEquals("User is navigated to Merchant's Registration's Page",
        merchantRegistrationPage.newMerchantRegistrationLabel.getText(),
        AcquirerPortalGlobal.MERCHNAT_REGISTRATION_TITLE);
  }

  @Given("^provide details to create a new Merchant$")
  public void provide_details_to_create_a_new_Merchant() throws Throwable {
    // merchantRegistrationPage.newMerchantRegistrationDivisionDropDown.click();
    merchantRegistrationPage.getChilds();

  }

  @Given("^search \"([^\"]*)\" merchant record in the Merchant Summary Page$")
  public void search_merchant_record_in_the_Merchant_Summary_Page(String arg1) throws Throwable {

  }

  @Given("^user lock the Merchant$")
  public void user_lock_the_Merchant() throws Throwable {

  }

  @Then("^user unlock the Merchant$")
  public void user_unlock_the_Merchant() throws Throwable {

  }

}
