Feature: 3_PortalUser 

Background: 
	Given User "CBA_Admin" successfully navigated to Portal Users Page 
	
@sanity @independentTest 
Scenario Outline: Search portal user and verify details 
	Then User enter portal user name "<portaluser>" and search 
	Then User validate the portal user details from results 
	
	
	Examples: 
		|portaluser	|
		|CBA_Admin	|
		
		
@sanity @independentTest 
Scenario Outline: Create a portal user 
	Then User click on edit button 
	And User click on + button to add new "<portaluser>" Portal User 
		
	Examples: 
		|portaluser	|
		|CBA_Support|