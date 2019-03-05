package com.mobeewave.acquirer.tests;


import com.mobeewave.acquirer.tests.BackgroundSteps;
import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.pageObjects.LoginPage;
import com.mobeewave.acquirer.pageObjects.MerchantsSummaryPage;
import com.mobeewave.acquirer.utils.CommonUtils;

import cucumber.api.java.en.Given;

public class BackgroundSteps {

	private static String client_GBL = "";
	private static String browser_GBL = "";
	private static String username_LBL_GBL = "";
	CommonUtils comUtil = new CommonUtils();

	@Given("^User is successfully navigated to Home Page$")
	public void user_is_successfully_navigated_to_Home_Page(){
		try {
			
			browser_GBL = SetUp.getBrowser();
			client_GBL =  SetUp.getClient();
			SetUp.setupDriver(client_GBL,browser_GBL);
			comUtil.setWaitinSeconds(10);
		} catch (Exception ex) {
			System.out.println("Navigate is  Failed - scenario - login to page");
			SetUp.teardown();
		}
	}

	@Given("^User of client \"([^\"]*)\" has successfully navigated to Home Page through browser \"([^\"]*)\"$")
	public void user_of_client_has_successfully_navigated_to_Home_Page_through_browser(String client, String browser) {
		try {

			BackgroundSteps.client_GBL = client;
			BackgroundSteps.browser_GBL = browser;
			SetUp.setupDriver(client_GBL, browser_GBL);
			comUtil.setWaitinSeconds(10);
		} catch (Exception ex) {
			System.out.println("Navigate as user " + username_LBL_GBL + "is  Failed - scenario - login to page");
			SetUp.teardown();
		}
	}


}
