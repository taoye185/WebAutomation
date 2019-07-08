@portaluser 
Feature: 2_Portal_Tests 

Background: 
	Given User successfully navigated to Portal Users Page 	
	
@sanity22 @loginAsGPAdmin @CreateAdminGroup @CreateSupportGroup @create10MinuteEmail 
Scenario Outline: Create Portal user accounts 
	And user click on New Portal User button 
	Then provide details to create a "<user>" new Portal user 
	Examples: 
		| user   |			
		| admin  |
		| support|		
		
	@sanity22
	Scenario Outline:  Delete Portal users
	And Filter portal users by "<email>" email
	And User validate the portal user details from results
	And click on details of the portl user from results table
	Then Delete the portal user record
	Examples:
		| email    |
		| supportEmail |
		| adminEmail |
		
		
@sanity3 @loginAsGPAdmin  @create10MinuteEmail 
Scenario Outline: Create Portal user accounts 
	And user click on New Portal User button 	
	And provide details to create a "<newuser>" new Portal user 
	And logout from portal
	And user navigates back to email and capture temporary password
	And new user successfully navigated to Home Page
	And new user "<newuser>" enter credentials and hit Login Button
	And user change password 	
	Examples: 
		| newuser   |	
		| support|		