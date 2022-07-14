Feature: Validate Password Confirm, different input than Password

  Scenario: Password Confirm field does not accept values different than Password
    Given User is on Register Account page
    When User enters Password "test1"
    And User enters Password Confirm "test2"
    And User clicks Continue button
    Then Warning message is displayed
      | Password Confirm |
