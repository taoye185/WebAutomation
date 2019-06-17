@loginPage
Feature: verify user is able do all the actions on login page

	@sanity @loginAsRootAdmin 
	Scenario: Login as Root Admin
		Then User navigates to portal user page
		And Validate user name label from the left navigation is successful

	@sanity @loginAsGPAdmin
	Scenario: Login as GP Admin
		Then User navigates to merchants summary page
		And Validate user name label from the left navigation is successful
