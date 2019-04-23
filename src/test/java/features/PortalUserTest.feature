@portalUser
Feature:

	Background:
		Given User "CBA_Admin" successfully navigated to Portal Users Page

	@sanity @independentTest
	Scenario Outline: Search portal user and verify details
		Then User enter portal user name "<portaluser>" and search
		Then User validate the portal user details from results


		Examples:
			| portaluser |
			| CBA_Admin  |


	@independentTest
	Scenario Outline: Create a portal user
		Then User click on edit button
		And User click on + button to add new "<portaluser>" Portal User
		Then User provide details to create a "<Newportaluser>" new Portal user
		Then New user "<Newportaluser>" navigate to email and verify email sent by MW

		Examples:
			| portaluser  |
			| CBA_Support |


	@sanity @independentTest
	Scenario Outline: Verify portal user Pagination
		Then User click Last in pagination of  Portal User Page


		Examples:
			| portaluser  |
			| CBA_Support |