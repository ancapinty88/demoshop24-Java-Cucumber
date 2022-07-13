Feature: User registration form has all required mandatory fields
  # Step 1 (check asterisks' visibility) cannot be automated - skipped
  # Step 2 works independently

  Scenario: When required fields are not filled, warnings are displayed
    Given User is on Register Account page
    When User clicks Continue button
    Then Warning message is displayed
    | First Name |
    | Last Name  |
    | E-Mail     |
    | Telephone  |
    | Password   |
    | Policy     |
