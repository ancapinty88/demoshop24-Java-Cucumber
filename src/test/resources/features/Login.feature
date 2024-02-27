Feature: Login

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
  Background:
    Given user is on "Home" page
    * "Testing Demo Shop" is displayed
    When user clicks "My account" button
    * user clicks "Login" button

  Scenario: check navigation menu items are visible
    When user is on "Login" page
    Then navigation header bar icons are displayed