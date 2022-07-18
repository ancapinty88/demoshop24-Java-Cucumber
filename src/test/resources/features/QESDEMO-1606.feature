Feature: User cannot register if email is already registered

  Scenario: New user registration with already registered email
    Given User is on Register Account page
    When User enters First Name "Adas"
    And User enters Last Name "Jonelis"
    And User enters E-Mail "aj1@testmail.test"
    And User enters Telephone "8765432189"
    And User enters Password "TestPass_3"
    And User enters Password Confirm "TestPass_3"
    And User selects Subscribe option "No"
    And User ticks Privacy Policy checkbox
    And User clicks Continue button
    Then A message is displayed
      | Email already registered |
