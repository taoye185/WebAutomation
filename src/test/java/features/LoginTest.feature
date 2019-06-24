@loginPage 
Feature: verify user is able do all the actions on login page 

Background: 
	Given User successfully navigated to Home Page 
	
@sanity @logout
Scenario Outline: Login as Root Admin 
	When user "<userName>" enter credentials and hit Login Button 
	Then Validate user name label from the left navigation is successful 
	Examples: 
		| userName |
		| RootAdmin|
		| GPAdmin  |
		
		
