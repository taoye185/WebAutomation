Feature: 4_Merchant_Tests

	Background:
		Given User successfully navigated to merchant Summary Page

	@sanity1 @loginAsGPAdmin
	Scenario Outline: Verify new merchant account can be locked and unlocked
		Given user click on New Merchant button and navigates to merchants Registration Page
		And provide details to create a new Merchant
		And search "<NewMerchant>" merchant record in the Merchant Summary Page
		And user lock the Merchant
		Then user unlock the Merchant
		Examples:
			| NewMerchant |
			| MWTest01    |
