Feature: 4_Merchant_Tests 

Background: 
	Given User successfully navigated to Merchnat Summary Page 
		
@sanity @loginAsGPAdmin 
Scenario Outline: Create a New Merchant, Test lock and Unlock 
	Given user click onn New Merchant button and naivgates to merchants Registration Page
	And provide details to create a new Merchant 
	And search "<NewMerchant>" merchant record in the Merchant Summary Page 
	And user lock the Merchant 
	Then user unlock the Merchant 
	Examples: 
		| NewMerchant |
		| MWTest01    |
		