Feature: Change password form mandatory fields check

  Background:
    Given user is on "Home" page
    * "Testing Demo Shop" is displayed
    When user clicks "My account" button
    * user clicks "Login" button
    Then user login with valid credentials
      | email        | password  |
      | at@xmail.com | auto12345 |
    And user clicks "LoginAccount" button

    #QESDEMO-2810
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
      | Link     | Page Title      | Sub Title     |
      | Password | Change Password | Your Password |

    #QESDEMO-2808
  Scenario Outline: Check Password and Password Confirm fields validation with incorrect data
    When user click on "<Link>" link in sub menu
    Then user see "<Page Title>" page title
    And user see "<Sub Title>" page subtitle
    When user enter new credentials to the Change Password form fields
      | Password   | Password Confirm   |
      | <Password> | <Password Confirm> |
    And user clicks "Continue" button in Change Password page
    Then user see "<Error message>" for invalid Password Change "<Input field>" field
    Examples:
      | Password                      | Password Confirm              | Input field      | Error message                                  | Link     | Page Title      | Sub Title     |
      | pom                           | pom                           | Password         | Password must be between 4 and 20 characters!  | Password | Change Password | Your Password |
      | pvTMXuBS0XyVN1n6TnuI333556677 | pvTMXuBS0XyVN1n6TnuI333556677 | Password         | Password must be between 4 and 20 characters!  | Password | Change Password | Your Password |
      | lithuania                     | lithuania2024                 | Password Confirm | Password confirmation does not match password! | Password | Change Password | Your Password |


  Scenario Outline: Check if logged in user can successful change password in Change Password page
    When user is on "MyAccount" page
    When user click on "<Link>" link in sub menu
    Then user see "<Page Title>" page title
    And user see "<Sub Title>" page subtitle
    When user enter new credentials to the Change Password form fields
      | Password   | Password Confirm   |
      | <Password> | <Password Confirm> |
    And user clicks "Continue" button
    Then user is back at the "MyAccount" page with success message "<Message>"
    When user is back at My Account page I press on "Password" link again
    Then user enter previous password credentials
      | Password         | auto12345 |
      | Password Confirm | auto12345 |
    And user clicks "Continue" button
    Examples:
      | Password      | Password Confirm | Message                                               | Link     | Page Title      | Sub Title     |
      | manualSuccess | manualSuccess    | Success: Your password has been successfully updated. | Password | Change Password | Your Password |