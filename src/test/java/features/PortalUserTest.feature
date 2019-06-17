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
		
		
	@sanity 
	Scenario Outline:  Delete Portal users
	And Filter portal users by "<email>" email
	And User validate the portal user details from results
	And click on details of the portl user from results table
	Then Delete the portal user record
	Examples:
		| email    |
		| supportEmail |
		| adminEmail |
		
