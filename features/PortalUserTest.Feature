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