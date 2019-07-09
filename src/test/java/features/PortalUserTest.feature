@portalUser
Feature: Portal_Tests

	Background:
		Given User successfully navigated to Portal Users Page

	@sanity @loginAsGPAdmin  @create10MinuteEmail
	Scenario Outline: Create Portal user accounts
		And user click on New Portal User button
		And provide details to create a "<newuser>" new Portal user
		And logout from portal
		#And user navigates back to email and capture temporary password
		#And new user successfully navigated to Home Page
		#And new user "<newuser>" enter credentials and hit Login Button
		#And user change password
		Examples:
			| newuser |
			| support |