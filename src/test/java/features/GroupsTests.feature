Feature: 3_Groups_Tests 


Background: 
	Given User successfully navigated to Groups summary Page  

@sanity @loginAsGPAdmin @independentTest
Scenario: Create a Group  
	Given user click on New Group button 
	And provide details to create a new Group 	
	And filter created Group 
	Then verify group is listed down in the results table


	
	
	
