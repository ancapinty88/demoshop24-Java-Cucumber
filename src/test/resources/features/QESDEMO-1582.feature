Feature: Validate Password field, incorrect input

  Scenario Outline: Password field does not accept invalid values
    Given User is on Register Account page
    When User enters Password "<Password>"
    And User clicks Continue button
    Then Warning message is displayed
      | Password |
    Examples:
      | Password              |
      | abc                   |
      | 123456789012345678901 |
    # Second example fails - defect
