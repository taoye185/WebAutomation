Feature: 4_Merchant_Tests

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
 Scenario Outline: To Verify that an error message should be displayed when the "<FieldName>" is missing
	Given User successfully navigated to New Merchant Page
	When User leave the "<FieldName>" empty
	Then An error message shall be displayed under the missing "<FieldName>" field
	And Create Merchant button is not active

	Examples:
	|FieldName					|ExpectedErrorMessage			|
	|businessName				|Please enter a business name|
	|address					|Please enter an address|
	|CITY						|Please enter a City|
	|ZIPCODE					|Please enter a postal / ZIP code|	
	|MPOSUSERNAME				|Please enter a name|
	|MPOSUSEREMAIL				|Please enter an email|
			