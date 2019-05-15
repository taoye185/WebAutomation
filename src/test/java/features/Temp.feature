Feature: verify user is login

Background: 
	Given User successfully navigated to Groups summary Page  
	
@sanity @loginAsGPAdmin @independentTest
Scenario: Delete a Group 
	Given filter created Group 
	And click on details of the Group
	Then delete the Group
	

	