Feature: 2_pU

	Background:
		Given User successfully navigated to Portal Users Page

	@sanity @independentTest @login
	Scenario Outline: Search portal user and verify details
		When User enter portal user name "<portaluser>" and search
		Then User validate the portal user details from results
		Examples:
			| portaluser |
			| GP_Admin  |