package com.mobeewave.acquirer.tests;

import cucumber.api.java.en.Then;

public class PortalUserSteps {

	@Then("^User enter portal user name \"([^\"]*)\" and search$")
	public void user_enter_portal_user_name_and_search(String username){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
