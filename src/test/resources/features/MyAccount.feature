Feature: My Account Page

  Background:
    Given user is on "Home" page
    And "Testing Demo Shop" is displayed
    When user clicks "My Account" button
    * user clicks "Login" button

  Scenario: User is on "My Account Page"
    Given user is on "Login" page
    Then user login with valid credentials
      | E-Mail Address | at@xmail.com |
      | Password       | auto12345    |
    And user clicks "LoginAccount" button
    Then user is on "MyAccount" page


  Scenario Outline: Check "My Account" right side sub-menu links are present and clickable
    When user is on "MyAccount" page
    Then user see sub menu on the right side of the page
    When user click on "<Link>" link in sub menu
    Then user see "<Page Title>" page title
    Examples:
      | Link               | Page Title              |
      | My Account         | My Account              |
      | Edit Account       | My Account Information  |
      | Password           | Change Password         |
      | Address Book       | Address Book            |
      | Wish List          | My Wish List            |
      | Downloads          | Account Downloads       |
      | Recurring payments | Recurring Payments      |
      | Reward Points      | Your Reward Points      |
      | Returns            | Product Returns         |
      | Order History      | Order History           |
      | Transactions       | Your Transactions       |
      | Newsletter         | Newsletter Subscription |
      | Logout             | Account Logout          |

  Scenario Outline: Check "My Account" left side sub-menu links are present and clickable
    When user is on "My Account" page
    Then user see "<Section Name>" section on the left side of the page
    When user click on "<Link>" link below the section
    Then user see "<Page Title>" page title
    Examples:
      | Section Name         | Link                                  | Page Title                 |
      | My Account           | Edit your account information         | My Account Information     |
      | My Account           | Change your password                  | Change Password            |
      | My Account           | Modify your address book entries      | Address Book               |
      | My Account           | Modify your wish list                 | My Wish List               |
      | My Orders            | View your order history               | Order History              |
      | My Orders            | Downloads                             | Account Downloads          |
      | My Orders            | Your Reward Points                    | Your Reward Points         |
      | My Orders            | View your return requests             | Product Returns            |
      | My Orders            | Your Transactions                     | Your Transactions          |
      | My Orders            | Recurring payments                    | Recurring Payments         |
      | My Affiliate Account | Register for an affiliate account     | Your Affiliate Information |
      | Newsletter           | Subscribe / unsubscribe to newsletter | Newsletter Subscription    |


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



