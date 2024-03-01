Feature: My Account Page

  Scenario: User is on "My Account Page"
    Given user is on "Login" page
    Then user login with valid credentials
      | E-Mail Address   | ank@gmail.com   |
      | Password         | 1Password7      |
    And user clicks "Login" button
    Then user is on "MyAccount" page


  Scenario Outline: Check if all sub menu links are present on the right side of My Account page and is clickable
    When user is on "MyAccount" page
    Then user see sub menu on the right side of the page
    When user click on "<Link>" link in sub menu
    Then user see "<Page Title>" page title
    Examples:
      | Link                | Page Title                 |
      | My Account          | My Account                 |
      | Edit Account        | My Account Information     |
      | Password            | Change Password            |
      | Address Book        | Address Book               |
      | Wish List           | My Wish List               |
      | Downloads           | Account Downloads          |
      | Recurring payments  | Recurring Payments         |
      | Reward Points       | Your Reward Points         |
      | Returns             | Product Returns            |
      | Order History       | Order History              |
      | Transactions        | Your Transactions          |
      | Newsletter          | Newsletter Subscription    |
      | Logout              | Account Logout             |
##
#Scenario: Check the sub-menu on the LEFT side on "My account" page
#  Then Check the sub-menu on the LEFT side on My account page
#  And Check My account section links on the left sub-menu are visible
#  And Check My Orders section links on the left sub-menu are visible
#  And Check My Affiliate Account section links on the left sub-menu are visible
#  Then Check Newsletter section links on the left sub-menu are visible
#
#Scenario: Check sub-menu right side on "My Account" page
#  Then Check the sub-menu on the RIGHT side on "My account" page
#
#Scenario:



