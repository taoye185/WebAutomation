@loginPage
Feature: verify user is able do all the actions on login page

@sanity @logindatadriven
Scenario Outline: Login data driven 
	Given User is successfully navigated to Home Page 	
	When User enter valid "<username>" and "<password>" and hit Login button 
	And User navigates to portal user page 
	Then close the browser
	Examples: 
		|username	|		
		|GP_Admin	|
		|Root_Admin |