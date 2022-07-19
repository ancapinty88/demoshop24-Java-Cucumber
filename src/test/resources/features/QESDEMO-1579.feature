Feature: Validate Telephone field, incorrect input

  Scenario Outline: Telephone field does not accept invalid values
    Given User is on Register Account page
    When User enters Telephone "<Telephone>"
    And User clicks Continue button
    Then A message is displayed
      | Telephone  |
    Examples:
      | Telephone                         |
      | 123456                            |
      | 37012@345678                      |
      | testNumber                        |
      | 123456789012345678901234567890123 |
  # First three tests fail - defects: not accepts values that should not be accepted
  # Fourth test fails - incorrect warning message (3-32 instead of 7-32)
