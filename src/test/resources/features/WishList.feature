Feature: Logged in user navigates to "My wish list" page and adds items to the Wish List

  Background:
    Given user is on "Home" page
    * "Testing Demo Shop" is displayed
    When user clicks "My Account" button
    * user clicks "Login" button
    Then user login with valid credentials
      | email               | password        |
      | mt@xmail.com        | manual12345      |
    And user clicks "LoginAccount" button

  Scenario Outline: Check if user can navigate to the Wish List
    When user clicks on Testing Demo Shop logo link
    Then user is on "Home" page
    And  user see "Your Store" title
    When user clicks on heart icon under the MacBook item
    Then user see "<Success message>" that product was added
    When user click on Wish List link in navigation header menu
    Then user is on "WishList" page
    And  user see "My Wish List" title
    When user see table with fields
      |Image         |
      |Product Name  |
      |Model         |
      |Stock         |
      |Unit Price    |
      |Action        |
    Then user click on Add to Cart button in Action table field
    And  user see "<Message>" that product was added
    When user clicks on Remove button from Action table field
    Then user see "<Update message>" that Wish list was updated

    Examples:
      |Success message                                   |Message                                               |Update message                           |
      |Success: You have added MacBook to your wish list!|Success: You have added MacBook to your shopping cart!| Success: You have modified your wish list!|


Scenario Outline:
  When user is on "MyAccount" page
  And  user click on "<Link>" link in sub menu
  Then user see "Page Title" page title
  When user clicks "Continue" button in Wish List page
  Then user is on "MyAccount" page
  And  user see "My Account" title
  Then user click on Wish List link in navigation header menu
  And  user see "<Page Title>" page title
  When user clicks "Continue" button in Wish List page
  Then user is on "MyAccount" page
  And  user see "My Account" title
  When user clicks on Testing Demo Shop logo link
  Then user is on "Home" page
  And  user see "Your Store" title
  When user clicks on heart icon under the MacBook item
  Then user see "<Success message>" that product was added
  When user clicks on wish list link in success message description
  Then user see "<Page Title>" page title
  And  user clicks on Remove button from Action table field
  Examples:
    | Link                | Page Title                 |Success message                                   |
    | Wish List           | My Wish List               |Success: You have added MacBook to your wish list!|


