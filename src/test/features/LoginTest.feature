Feature: 1_Login 

Background: 
	Given User is successfully navigated to Home Page 
	
@sanity @independentTest 
Scenario Outline: Login as an Admin 
	Then User enters valid credentials "<username>" and password in login Page 
	Then User navigates to the Merchants Summary Page and validate user name in left navigation 
	Examples: 
		|username	|
		|CBA_Admin	|
	