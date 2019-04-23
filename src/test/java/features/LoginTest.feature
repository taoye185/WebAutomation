@loginPage
Feature: verify user is able do all the actions on login page

	Background:
		Given User is successfully navigated to Home Page

	@sanity3 @independentTest
	Scenario Outline: verify is a able to login as CBA_Admin
		When User enters valid credentials "<username>" and password in login Page
		Then User navigates to the Merchants Summary Page and validate user name in left navigation
		Examples:
			| username  |
			| CBA_Admin |
