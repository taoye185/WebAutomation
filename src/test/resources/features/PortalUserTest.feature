@portalUser
Feature: Portal_Tests


	Background:
		Given User successfully navigated to Portal Users Page

	@regression @loginAsGPAdmin  @create10MinuteEmail @CreateSupportGroup
	Scenario Outline: Create Portal user accounts
		When user click on New Portal User button
		And provide details to create a "<newuser>" new Portal user
		And logout from portal
		And user navigates back to email and capture temporary password
		And new user successfully navigated to Home Page
		And new user "<newuser>" enter credentials and hit Login Button
		And user change password
		Then the user is successfully logged in to acquirer portal
		Examples:
			| newuser |
			| support |