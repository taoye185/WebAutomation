@loginPage
Feature: verify user is able do all the actions on login page

	@sanity @loginAsRootAdmin 
	Scenario: Login as Root Admin		
		And Validate user name label from the left navigation is successful

	@sanity @loginAsGPAdmin
	Scenario: Login as GP Admin		
		And Validate user name label from the left navigation is successful
