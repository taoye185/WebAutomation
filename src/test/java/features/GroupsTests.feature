Feature: 3_Groups_Tests 

Background: 
	Given User successfully navigated to Groups summary Page 
	
@sanity @login 
Scenario Outline: Create a Group 
	Given user click on New Group button 
	And provide details to create a new Group 
	Then Group is created 
	Examples: 
		| portaluser |
		| Root_Admin |
		| GP_Admin   |