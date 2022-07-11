Feature: New user is able to register successfully
  # to successfully run this test change email
  Scenario: New user registration
    Given User is on Register Account page
    When User enters data
    | First Name        | Jonas                |
    | Last Name         | Jonaitis             |
    | E-Mail            | jonas@testmail.test |
    | Telephone         | 876543210            |
    | Password          | TestPass_1           |
    | Password Confirm  | TestPass_1           |
    And User ticks Privacy Policy checkbox
    And User clicks Continue button
    Then User is redirected to confirmation page
    And Confirmation message is displayed: "Your Account Has Been Created!"