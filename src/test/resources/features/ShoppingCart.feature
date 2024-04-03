Feature: Successfully adding and removing item from the Shopping Cart

  #US07, US08, US09, US10

Background:
  Given user is on "Home" page
  * "Testing Demo Shop" is displayed
  When user clicks "My Account" button
  * user clicks "Login" button
  Then user login with valid credentials
  And user clicks "LoginAccount" button

  #QESDEMO-2843
Scenario: Successfully add and remove item from Shopping Cart
  When user clicks on Testing Demo Shop logo link
  Then user is on "Home" page
  And  user see "Your Store" title
  When user clicks "Add To Cart" button
  Then user clicks "Black DropDown" button
  When user clicks "RemoveItemDropDown" button
  Then user see that there is "0 item(s) - $0.00" in the shopping cart

  #QESDEMO-2844
Scenario: Dropdown Button and navigation to Checkout page
  When user clicks on Testing Demo Shop logo link
  Then user is on "Home" page
  And  user see "Your Store" title
  Then user clicks "Add To Cart" button
  When user clicks "Black DropDown" button
  And  user see table with mandatory fields
    |Sub-Total     |
    |Total         |
  Then user clicks "View Cart" button
  And  user is on "ShoppingCart" page
  And  user see "Shopping Cart" title
  When user clicks "Black DropDown" button
  Then user clicks "Checkout DropDown" button
  Then user is on "Checkout" page
  And  user see "Checkout" title

  #QESDEMO-2847
Scenario: Navigation to page and verify product description table fields
  When user clicks on Testing Demo Shop logo link
  Then user clicks "Add To Cart" button
  And  user clicks "Shopping Cart" button
  Then user is on "ShoppingCart" page
  And  user see "Shopping Cart" page title
  Then user clicks on Testing Demo Shop logo link
  Then user is on "Home" page
  And  user see "Your Store" title
  When user clicks "Black DropDown" button
  Then user clicks "View Cart" button
  And  user is on "ShoppingCart" page
  And  user see "Shopping Cart" page title
  Then user see table fields
    |Image         |
    |Product Name  |
    |Model         |
    |Quantity      |
    |Unit Price    |
    |Total         |
  And user see down table fields
    |Sub-Total:    |
    |Total:        |

  #QESDEMO-2849 #QESDEMO-2853 #QESDEMO-2854
Scenario Outline: Check required buttons
  When user clicks on Testing Demo Shop logo link
  Then user is on "Home" page
  And  user see "Your Store" title
  Then user clicks "Add macBook To Cart" button
  And  user clicks "Shopping Cart" button
  Then user is on "ShoppingCart" page
  And  user see "Shopping Cart" page title
  Then user increase "<quantity>" value in quantity column
  And user clicks "Update" button
  Then user see "<update message>"
  When user clicks "Continue Shopping" button
  Then user is on "Home" page
  And  user see "Your Store" title
  And  user clicks "Shopping Cart" button
  Then user is on "ShoppingCart" page
  And  user see "Shopping Cart" page title
  When user clicks "Checkout" button
  Then user is on "Checkout" page
  And  user see "Checkout" title
  Then user clicks "Breadcrumb Shopping Cart" button
  And  user is on "ShoppingCart" page
  Then user clicks "Remove item" button
  Then user see "Your shopping cart is empty!" message
  Examples:
    | quantity | update message                                 |
    | 2        | Success: You have modified your shopping cart! |

#QESDEMO-2856
Scenario Outline: Add and Remove "Out of Stock" item
  When user clicks on Testing Demo Shop logo link
  Then user is on "Home" page
  And  user see "Your Store" title
  Then user clicks "Add iPhone To Cart" button
  Then user see "<success message>" added item to shopping cart
  Then user clicks "Shopping Cart" button
  Then user is on "ShoppingCart" page
  And  user see "Shopping Cart" page title
  When user see "<warning message>" added item is unavailable
  And  user see "***" next to the items name
  Then user clicks "Remove item" button
  And  user see "Your shopping cart is empty!" message
  Examples:
    | success message                                       | warning message                                                                    |
    | Success: You have added iPhone to your shopping cart! | Products marked with *** are not available in the desired quantity or not in stock!|

