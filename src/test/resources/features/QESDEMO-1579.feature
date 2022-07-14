Feature: Validate Telephone field, incorrect input

  Scenario Outline: Telephone field does not accept invalid values
    Given User is on Register Account page
    When User enters Telephone "<Telephone>"
    And User clicks Continue button
    Then Warning message is displayed
      | Telephone  |
    Examples:
      | Telephone                         |
      | 123456                            |
      | 37012@345678                      |
      | testNumber                        |
      | 123456789012345678901234567890123 |
  # First three test fail - defects
