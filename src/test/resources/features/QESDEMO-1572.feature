Feature: Validate First name and Last name fields, incorrect input

  Scenario Outline: First name and Last name fields do not accept invalid values
    Given User is on Register Account page
    When User enters First Name "<First Name>"
    And User enters Last Name "<Last Name>"
    And User clicks Continue button
    Then A message is displayed
      | First Name  |
      | Last Name   |
    Examples:
      | First Name                        | Last Name |
      | Jonas Petras Jonas Petras Jonas P | Jonas Petras Jonas Petras Jonas P |
      | J0nas                             | J0naitis                          |
      | Jon@s                             | Jon@itis                          |
  # Examples 2 and 3 produce errors - because name fields should not accept numbers or special characters

  Scenario: First name and Last name fields do not accept whitespace
    Given User is on Register Account page
    When User enters whitespace
      | First Name  |
      | Last Name   |
    And User clicks Continue button
    Then A message is displayed
      | First Name  |
      | Last Name   |