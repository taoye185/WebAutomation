@loginPage
Feature: verify user is able do all the actions on login page

  Background:
    Given User is successfully navigated to home Page

  @sanity @logout
  Scenario Outline: Login as User
    When user "<userName>" enter credentials and hit login button
    Then "<userName>" should be displayed on the left navigation Menu
    Examples:
      | userName  |
      | RootAdmin |
      | GPAdmin   |

  @test
  Scenario: Verify that error message is displayed when logged in with empty fields.
    When user leaves Username and Password empty
      |  |  |
    Then error message is displayed for blank Username
      | Please enter a username |
    And error message is displayed for blank Password
      | Please enter a password |

  @test2
  Scenario Outline: Verify that error message is displayed when logged in with different username and password criterias
    When User enters invalid combination of "<Username>" and "<Password>"
    Then "<Error_message>" is displayed
    Examples:
      | Username   | Password       | Error_message                                               |
      | gpadmin    | Mobeeewave2019 | The information you entered is incorrect, please try again. |
      | gpadmin1   | Mobeewave2015  | The information you entered is incorrect, please try again. |
      | gpadmin123 | Mobeewave123   | Invalid Login.                                              |





