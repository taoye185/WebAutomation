@loginPage 
Feature: verify user is able do all the actions on login page 

Background: 
	Given User successfully navigated to Home Page 
	
@sanity123 @logout
Scenario Outline: Login as User
	When user "<userName>" enter credentials and hit Login Button 
	Then "<userName>" should be displayed on the left navigation Menu
	Examples: 
		| userName |
		| RootAdmin|
		| GPAdmin  |
		
		
