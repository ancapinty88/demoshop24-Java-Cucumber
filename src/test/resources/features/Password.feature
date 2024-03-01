Feature: Change password form mandatory fields check
  Background:
    Given user is on "Home" page
    * "Testing Demo Shop" is displayed
    When user clicks "My account" button
    * user clicks "Login" button
    Then user login with valid credentials
      | email               | password        |
      | ank@gmail.com       | 1Password7      |
    And user clicks "Login" button

  Scenario Outline: Check mandatory information fields are present on "Change Password" form
    Then user is on "MyAccount" page
    And user click on "<Link>" link in sub menu
    Then user see "<Page Title>" page title
    And user see "<Sub Title>" page subtitle
    When user see mandatory fields in the Change Password form
      | Password         |
      | Password Confirm |
    And user click on Back button at the bottom of Change Password form
    Then user is on "MyAccount" page
    Examples:
      | Link            | Page Title          | Sub Title      |
      | Password        | Change Password     | Your Password  |
