@loginPage
Feature: verify user is able do all the actions on login page

	Background:
		Given User is successfully navigated to Home Page

	@sanity @logout
	Scenario Outline: Login as User
		When user "<userName>" enter credentials and hit login button
		Then "<userName>" should be displayed on the left navigation Menu
		Examples:
			| userName  |
			| RootAdmin |
			| GPAdmin   |


