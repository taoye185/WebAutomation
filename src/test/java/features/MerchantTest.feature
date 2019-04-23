@merchantSummary
Feature:

	Background:
		Given User "CBA_Admin" successfully navigated to Merchant Summary Page


	@sanity @independentTest
	Scenario Outline: Search Merchant by ID and verify details
		Then User enter merchant ID "<merchantID>" and search
		Then User validate the merchant details from results
		And user click on details in search Result

		Examples:
			| merchantID       |
			| test000000000003 |