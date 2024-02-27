Feature: My Account Page


  Background: User is on "My Account Page"
    Given User is on Login Page
    When Check if Returning Customer section is visible on Login Page
    Then User fill the input fields with valid e-mail and valid password
    And Click on the Login button
    Then Check if user is on My Account page

Scenario: Check the sub-menu on the LEFT side on "My account" page
  Then Check the sub-menu on the LEFT side on My account page
  And Check My account section links on the left sub-menu are visible
  And Check My Orders section links on the left sub-menu are visible
  And Check My Affiliate Account section links on the left sub-menu are visible
  Then Check Newsletter section links on the left sub-menu are visible

Scenario: Check sub-menu right side on "My Account" page
  Then Check the sub-menu on the RIGHT side on "My account" page

Scenario:



