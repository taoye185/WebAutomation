package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import utils.Browser;
import cucumber.api.java.en.Then;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class MerchantSteps {
  @Given("^User navigates to merchants summary page$")
  public void User_navigates_to_merchantsSummary() throws Throwable {
		Thread.sleep(6000);
	  System.out.println(Browser.getDriver().getCurrentUrl());  
	  Assert.assertEquals("User is navigated to Merchnats Page", Browser.getDriver().getCurrentUrl(),AcquirerPortalGlobal.MERCHANTS_URL);
  }

  
}
