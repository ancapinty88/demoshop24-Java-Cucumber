Feature: Login

  Background:
    Given user is on "Home" page
    And "Testing Demo Shop" is displayed
    When user clicks "My account" button
    * user clicks "Login" button

  Scenario: check navigation menu items are visible
    When user is on "Login" page
    #Then navigation useheader bar icons are displayed

    #QESDEMO-2750
  Scenario: Login into system

    Then user login with valid credentials
      | E-Mail Address   | ank@gmail.com   |
      | Password         | 1Password7      |
    Then user clicks "Login" button
#    And Check that all sections are visible on page


      |                     |                 |


    #  #QESDEMO-2759
# Background: Pre-condition: User is on "Login Page"
#    Given open home page
#    Then check that navigation header bar is visible with following icons: valuta, contact, my account, wish list, shopping cart, checkout
#    Then click on My account icon on the navigation header bar
#    Then Click on Login from My Account menu
#
#  #QESDEMO-2750
#  Scenario Outline: Login into system
#    When Fill input "<email>" and "<password>" fields in the Returning Customer section
#    Then Click on the Login button
#    And Check that all sections are visible on page
#
#    Examples:
#      | email               | password        |
#      | ank@gmail.com       | 1Password7      |
#      |                     |                 |