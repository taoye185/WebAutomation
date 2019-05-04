Feature: 4_Merchant_Tests 

Background: 
	Given User successfully navigated to Merchnat Summary Page 
	
@sanity @login 
Scenario Outline: Create a "<NewMerchant>" Merchant locak and Unlock 
	Given user click on New Merchant button 
	And provide details to create a new Merchant 
	And search "<NewMerchant>" merchant record in the Merchant Summary Page 
	And user lock the Merchant 
	Then user unlock the Merchant 
	Examples: 
		| portaluser |
		| Root_Admin |
		| GP_Admin   |