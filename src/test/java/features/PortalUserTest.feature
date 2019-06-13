@portaluser 
Feature: 2_Portal_Tests 

Background: 
	Given User successfully navigated to Portal Users Page 
	
@sanity @loginAsGPAdmin @CreateAdminGroup @CreateSupportGroup 
Scenario Outline: Create Portal user accounts 
	And user click on New Portal User button 
	Then provide details to create a "<user>" new Portal user 
	Examples: 
		| user   |			
		| admin  |
		| support|
		
		
		
		
