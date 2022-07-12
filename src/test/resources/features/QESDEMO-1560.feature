Feature: User registration form has not mandatory field
# User registration form has a "Subscribe" radio button that is not mandatory.
# By default it is marked as "No".

  Scenario: User registration form has a "Subscribe" radio button
    Given User is on Register Account page
    Then Subscribe radio button is visible
    And Subscribe radio button is set as "No"
