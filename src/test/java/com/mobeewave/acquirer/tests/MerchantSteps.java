package com.mobeewave.acquirer.tests;

import com.mobeewave.acquirer.pageObjects.MerchantsSummaryPage;
import com.mobeewave.acquirer.utils.AssertUtil;
import com.mobeewave.acquirer.utils.CommonUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class MerchantSteps {
	private MerchantsSummaryPage merchantsSummaryPage = new MerchantsSummaryPage();
	CommonUtils comUtil = new CommonUtils();
	private String merchantID = "";

	@Then("^User enter merchant ID \"([^\"]*)\" and search$")
	public void user_enter_merchant_ID_and_search(String merchantID) {
		merchantsSummaryPage.searchMerchantText().sendKeys(merchantID);
		this.merchantID = merchantID;
	}

	@Then("^User enter merchant Name\"([^\"]*)\" and search$")
	public void user_enter_merchant_Name_and_search(String merchantName) {

	}

	@Then("^User validate the merchant details from results$")
	public void user_validate_the_merchant_details_from_results() {

		AssertUtil.assertEq(merchantsSummaryPage.merchantIDinMerchantSummuryTabel(merchantID).getText(), merchantID,
				"Verify merchant ID " + merchantID + " displays in the  Mrchants Summary result table");

		merchantsSummaryPage.setElementsinMerchantRecord(this.merchantID);

	}

	@And("^user click on details in search Result$")
	public void user_click_on_details_in_search_Result() {
		merchantsSummaryPage.merchantDetails.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// Allowing tester to see navigation to the details page.
			// This sleep is subject to remove with future developments
			e.printStackTrace();
		}
	}

}
