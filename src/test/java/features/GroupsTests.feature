Feature: 3_Groups_Tests
	Background:
		Given User successfully navigated to Groups summary Page

	@sanity36 @loginAsGPAdmin
	Scenario: Create a Support Group
		When user click on New Group button
		And provide details to create a new Group
		And filter created Group
		And verify group is listed down in the results table
		And click on details of the Group
		And edit group permissions from group details
		And assign and revoke screen appears
		Then set permissions to create support user group
		
	@sanity34 @loginAsGPAdmin
	Scenario: Create a Support Group
		When user click on New Group button
		And provide details to create a new Group
		And filter created Group
		And verify group is listed down in the results table
		And click on details of the Group
		And edit group permissions from group details
		And assign and revoke screen appears
		Then set permissions to create admin user group
		