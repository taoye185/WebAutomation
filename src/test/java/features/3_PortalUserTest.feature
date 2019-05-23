Feature: 2_Portal_Tests

	Background:
		Given User successfully navigated to Portal Users Page

	@sanity @loginAsGPAdmin
	Scenario Outline:Create an Support Account
		Given user click on New Portal User button
		And provide details to create a "<user>" new Portal user
		Examples:
			| user    |
			| support |

