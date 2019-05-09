Feature: verify user is able do all the actions on login page 

@sanity @loginAsRootAdmin @independentTest 
Scenario: Login as Root Admin 
	Given User navigates to portal user page 
	Then Validate user name label from the left navigation is sucessful 	
	
@sanity @loginAsGPAdmin @independentTest 
Scenario: Login as GP Admin 
	Given User navigates to merchants summary page 
	Then Validate user name label from the left navigation is sucessful 
