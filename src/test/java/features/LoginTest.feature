@loginPage
Feature: verify user is able do all the actions on login page

	@sanity @loginAsRootAdmin @logout
	Scenario: Login as Root Admin
		Then User navigates to portal user page
		And Validate user name label from the left navigation is successful

	@sanity @loginAsGPAdmin  @logout
	Scenario: Login as GP Admin
		Then User navigates to merchants summary page
		And Validate user name label from the left navigation is successful
    @test
    Scenario: Verify that error message is displayed when logged in with empty fields.
    Given User is successfully navigated to login Page
    When user leaves Username and Password empty
    |        |      |
    Then error message is displayed for blank Username
    |Please enter a username|
    And error message is displayed for blank Password
    |Please enter a password|
    
    @test2
    Scenario Outline: Verify that error message is displayed when logged in with different username and password criterias
    Given User is successfully navigated to login Page
    When User enters invalid combination of "<Username>" and "<Password>"
    Then "<Error_message>" is displayed
     Examples:
    |Username |Password |Error_message |
    |gpadmin | Mobeeewave2019        |The information you entered is incorrect, please try again.         |
    |gpadmin1 |Mobeewave2015 |The information you entered is incorrect, please try again.| 
    |gpadmin123|Mobeewave123|Invalid Login.|
    
       
    