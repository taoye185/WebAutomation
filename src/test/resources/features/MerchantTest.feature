@merchantPage
Feature: Merchant_Tests

	Background:
		Given User successfully navigated to merchant Summary Page

	@sanity @loginAsGPAdmin  @create10MinuteEmail
	Scenario: Verify new merchant account can be created
		When user click on New Merchant button and navigates to merchants Registration Page
		And provide details to create a new Merchant
		Then new merchant record in the Merchant Summary Page is displayed

	@regression  @loginAsGPAdmin
	Scenario Outline: To Verify that an error message should be displayed when the Field values are missing
		Given User successfully navigated to New Merchant Page
		When User click on New merchant button
		And User select the division from dropdown
			| division        |
			| Global Payments |
		And User leave the "<fieldName>" empty
		Then An error message "<expectedErrorMessage>" shall be displayed under the missing "<fieldName>" field
		And Create Merchant button is not active

		Examples:
			| fieldName     | expectedErrorMessage               |
			| businessName  | Please enter a business name       |
			| address       | Please enter an address            |
			| city          | Please enter a City                |
			| zipCode       | Please enter a postal / ZIP code |
			| mposUserName  | Please enter a name                |
			| mposUserEmail | Please enter an email              |
