Feature: Validate First name and Last name fields, correct input
# Validate whether First name and Last name fields accept:
# alphabetic characters length from 1 to 32 characters
# alphabetic characters separated by space
# alphabetic characters separated by dash
# length of 1 character
# length of 32 characters
  Scenario Outline: First name and Last name fields accept correct input
    Given User is on Register Account page
    When User enters First Name "<First Name>"
    And User enters Last Name "<Last Name>"
    And User clicks Continue button
    Then "First Name" value field has grey borders
    And "Last Name" value field has grey borders
    Examples:
    | First Name                        | Last Name           |
    | Jonas                             | Jonaitis            |
    | Jonas Petras                      | Jonaitis Petraitis  |
    | Jonas-Petras                      | Jonaitis-Petraitis  |
    | J                                 | J                   |
    | Jonas Petras Jonas Petras JonasP  | Jonas Petras Jonas Petras JonasP  |