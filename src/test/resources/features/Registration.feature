Feature: Registration

  Background:
    Given user is on "Home" page
    And "Testing Demo Shop" is displayed
    When user clicks "My account" button
    * user clicks "Register" button
    Then user is on "Registration" page

  Scenario: Check if successful registration with valid credentials
    When user enter valid data in registration fields:
      | First Name       | random     |
      | Last Name        | random     |
      | E-Mail           | @xmail.com |
      | Telephone        | random     |
      | Password         | random     |
      | Password Confirm | password   |
    And user mark Privacy Policy checkbox
    And user clicks "ContinueReg" button
    Then user see "<Your Account Has Been Created!>" title

  Scenario Outline: Check if new account registration fails if password or confirm password is invalid
    When user enter registration data:
      | First Name   | Last Name   | E-Mail   | Telephone   | Password   | Password Confirm   |
      | <First Name> | <Last Name> | <E-Mail> | <Telephone> | <Password> | <Password Confirm> |
    And user clicks "Continue" button
    Then user see "<error message>" for invalid "<input field>"
    Examples:
      | First Name | Last Name | E-Mail         | Telephone | Password               | Password Confirm       | input field      | error message                                  |
      | Acc1       | Com1      | acc1@email.com | 235486652 | Pom                    | Pom                    | Password         | Password must be between 4 and 20 characters!  |
      | Acc2       | Com2      | acc2@email.com | 245486652 | fLaQnrsb3C6fqZrIJUbH21 | fLaQnrsb3C6fqZrIJUbH21 | Password         | Password must be between 4 and 20 characters!  |
      | Acc3       | Com3      | acc3@email.com | 287486652 | nowhere                | nowherez               | Password Confirm | Password confirmation does not match password! |
