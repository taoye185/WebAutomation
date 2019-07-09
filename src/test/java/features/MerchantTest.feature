@merchantPage
Feature: Merchant_Tests

	Background:
		Given User successfully navigated to merchant Summary Page

	@sanity @loginAsGPAdmin
	Scenario Outline: Verify new merchant account can be locked and unlocked
		Given user click on New Merchant button and navigates to merchants Registration Page
		And provide details to create a new Merchant
		And search "<NewMerchant>" merchant record in the Merchant Summary Page
		And user lock the Merchant
		Then user unlock the Merchant
		Examples:
			| NewMerchant |
			| MWTest01    |

	@sanity @NewMerchant
	Scenario Outline: To Verify that an error message should be displayed when the Field values are missing
		Given User successfully navigated to New Merchant Page
		When User click on New merchant button
		And User select the division from dropdown 
		|division | 
		|Global Payments|
		And User leave the "<fieldName>" empty
		Then An error message "<expectedErrorMessage>" shall be displayed under the missing "<fieldName>" field
		And Create Merchant button is not active

		Examples:
			| fieldName     | expectedErrorMessage             |
			| businessName  | Please enter a business name     |
			| address       | Please enter an address          |
			| city          | Please enter a City              |
			| zipCode       | Please enter a postal / ZIP code |
			| mposUserName  | Please enter a name              |
			| mposUserEmail | Please enter an email            |
