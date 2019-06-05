Feature: 0_CleanUp_Tests

	Background:
		Given Test run is completed
				
	@sanity @loginAsGPAdmin
	Scenario: Delete all Created Groups during Testrun
	When all the tests are executed and user wants to clean up data
	And clean all the created groups
	