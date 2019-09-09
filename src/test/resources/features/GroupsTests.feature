@groupsPage
Feature: Groups_Tests
	Background:
		Given User successfully navigated to Groups summary Page

	@sanity @loginAsGPAdmin
	Scenario: Create a Support Group
		When user click on New Group button
		And provide details to create a new Group
		And filter created Group
		Then verify group is listed down in the results table
		And click on details of the Group
		And edit group permissions from group details
		Then assign and revoke screen appears
		And set permissions to create support user group

	@sanity @loginAsGPAdmin
	Scenario: Create an Admin Group
		When user click on New Group button
		And provide details to create a new Admin Group
		And filter created Group
		Then verify group is listed down in the results table
		And click on details of the Group
		And edit group permissions from group details
		And assign and revoke screen appears
		And set permissions to create admin user group
