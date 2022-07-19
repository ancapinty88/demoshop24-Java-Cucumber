Feature: User is not able to login with invalid credentials

  Scenario: User is not able to login with invalid password
    Given User is on Login page
    When User enters Login data
      | E-Mail Address   | jonjon@tesmail.com |
      | Password         | 123123123          |
    And User clicks Login button
    Then User is not redirected to User personal page
    And Login warning is displayed

  Scenario: User is not able to login with invalid email
    Given User is on Login page
    When User enters Login data
      | E-Mail Address   | jonjon@testmail.co |
      | Password         | TestPass_1         |
    And User clicks Login button
    Then User is not redirected to User personal page
    And Login warning is displayed
