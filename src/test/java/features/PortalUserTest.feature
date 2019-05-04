Feature: 2_Portal_Tests 

Background: 
	Given User successfully navigated to Portal Users Page 
	
@sanity @loginAsRootAdmin @independentTest @2
Scenario Outline: Create an Admin Account 
	Given user click on New Portal User button 
	And provide details to create a "<NewAdminuser>" new Portal user 
	Examples: 
		|NewAdminuser|
		|New_Admin   |
		
@sanity @loginAsGPAdmin @independentTest @1
Scenario Outline: Create an Support Account 
	Given user click on New Portal User button 
	And provide details to create a "<NewSupportuser>" new Portal user 
	Examples: 
		|NewSupportuser|
		|New_Support |