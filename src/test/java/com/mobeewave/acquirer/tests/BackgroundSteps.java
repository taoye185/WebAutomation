package com.mobeewave.acquirer.tests;


import com.mobeewave.acquirer.tests.BackgroundSteps;
import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.utils.CommonUtils;
import cucumber.api.java.en.Given;

public class BackgroundSteps {

	private static String client_GBL = "";
	private static String browser_GBL = "";	
	CommonUtils comUtil = new CommonUtils();

	@Given("^User is successfully navigated to Home Page$")
	public void user_is_successfully_navigated_to_Home_Page(){
		try {
			
			browser_GBL = SetUp.getBrowser();
			client_GBL =  SetUp.getClient();
			SetUp.setupDriver(client_GBL,browser_GBL);
			comUtil.setWaitInSeconds(10);
		} catch (Exception ex) {
			System.out.println("ERROR : ==================== /n" + ex.getMessage() + "/n====================");
			System.out.println("Navigation Failed - Login Scenario");
			SetUp.teardown();
		}
	}


}
