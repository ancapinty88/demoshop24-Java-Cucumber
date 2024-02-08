#Feature: EPIC-02 My Account
#
#  Background: User is at DemoShop personal page (QESDEMO-2297)
#    Given user is at DemoShop start page
#    And user clicks Account icon at header top menu
#    And user clicks Login at header dropdown
#    And user enters email "LadyBug@mail.com" under returning customer
#    And user enters password "test" under returning customer
#    And user clicks Login button under returning customer
#    Then user is redirected to Personal Account page
#
#  Scenario: Presence of account block, orders block, edit account link (QESDEMO-2295)
#    When user sees My Account block
#    And user sees My Orders block
#    Then user sees Edit Account link
#
#  Scenario: Links of My Account section on the left side: validation (QESDEMO-2448)
#    Then user sees My Account links
#      | Edit your account information    |
#      | Change your password             |
#      | Modify your address book entries |
#      | Modify your wish list            |
#
#  Scenario: Links of My Orders section on the left side: validation (QESDEMO-2449)
##  Bug: "View your return request" in AC, but actual value is "View your return requests";
##  test relies on the actual value
#    Then user sees My Orders links
#      | View your order history   |
#      | Downloads                 |
#      | Your Reward Points        |
#      | View your return requests |
#      | Your Transactions         |
#      | Recurring payments        |
#
#  Scenario: Links of My Affiliate Account and Newsletter sections on the left side: validation (QESDEMO-2450)
#    Then user sees My Affiliate Account links
#      | Register for an affiliate account |
#    And user sees Newsletter links
#      | Subscribe / unsubscribe to newsletter |
#
#  Scenario: Menu links on the right side: validation (QESDEMO-2447)
#    Then user sees menu links on the right side
#      | My Account         |
#      | Edit Account       |
#      | Password           |
#      | Address Book       |
#      | Wish List          |
#      | Order History      |
#      | Downloads          |
#      | Recurring payments |
#      | Reward Points      |
#      | Returns            |
#      | Transactions       |
#      | Newsletter         |
#      | Logout             |
#
#  Scenario: Check that "Edit Account" menu item contains specific title and sub-title (QESDEMO-2468)
#    When user clicks Edit Account menu item
#    Then user is navigated to confirmation page with title: "My Account Information"
#    And user is navigated to page with subtitle "Your Personal Details"
#
#  Scenario: "Edit Account" menu item fields visibility and defaults check (QESDEMO-2469)
##    Mandatoriness of the fields is verified in other TCs when leaving the fields empty
#    When user clicks Edit Account menu item
#    Then user can see all the fields and buttons under Edit Account
#      | firstName      |
#      | lastName       |
#      | email          |
#      | telephone      |
#      | buttonContinue |
#      | buttonBack     |
#    And user can see asterisks "\"* \"" next to the mandatory fields at Edit Account form
#      | firstName |
#      | lastName  |
#      | email     |
#      | telephone |
#
#  Scenario Outline: Validation of the First Name field in My Account Information (QESDEMO-2473): invalid data
## Bug1: AC do not mention that the name must be between between 1 and 32 characters
## Bug2: AC upon registration required First Name input to be alpha-numeric,
## but not when editing My Account Information (inconsistent requirements)
#    When user clicks Edit Account menu item
#    When user changes first name to "<firstName>"
#    And user clicks Continue button below Edit Account form
#    Then first name "<firstName>" should be valid and error message "<errorMessage>" is shown if it is invalid
#    Examples:
#      | firstName                         | errorMessage                                    |
#      | LadyLadyLadyLadyLadyLadyLadyLadyB | First Name must be between 1 and 32 characters! |
#      |                                   | First Name must be between 1 and 32 characters! |
#
#  Scenario Outline: Validation of the First Name field in My Account Information (QESDEMO-2473): valid data
## Bug1: AC do not mention that the name must be between between 1 and 32 characters
## Bug2: AC upon registration required First Name input to be alpha-numeric,
## but not when editing My Account Information (inconsistent requirements)
#    When user clicks Edit Account menu item
#    When user changes first name to "<firstName>"
#    And user clicks Continue button below Edit Account form
#    Then user is redirected to Personal Account page
#    And message "Success: Your account has been successfully updated." is shown
#    Examples:
#      | firstName                        |
#      | LadyLadyLadyLadyLadyLadyLadyLady |
#      | L                                |
#
#  Scenario Outline: Validation of the Last Name field in My Account Information (QESDEMO-2475): invalid data
## Bug: AC do not mention that the last name must be between between 1 and 32 characters
#    When user clicks Edit Account menu item
#    When user changes last name to "<lastName>"
#    And user clicks Continue button below Edit Account form
#    Then last name "<lastName>" should be valid and error message "<errorMessage>" is shown if it is invalid
#    Examples:
#      | lastName                          | errorMessage                                   |
#      | BugBugBugBugBugBugBugBugBugBugBug | Last Name must be between 1 and 32 characters! |
#      |                                   | Last Name must be between 1 and 32 characters! |
#
#  Scenario Outline: Validation of the Last Name field in My Account Information (QESDEMO-2475): valid data
## Bug: AC do not mention that the last name must be between between 1 and 32 characters
#    When user clicks Edit Account menu item
#    When user changes last name to "<lastName>"
#    And user clicks Continue button below Edit Account form
#    Then user is redirected to Personal Account page
#    And message "Success: Your account has been successfully updated." is shown
#    Examples:
#      | lastName                         |
#      | BugBugBugBugBugBugBugBugBugBugBB |
#      | B                                |
#
#  Scenario Outline: Validation of the Telephone field in My Account Information (QESDEMO-2478): invalid data
## Bug: AC do not mention that the last name must be between between 1 and 32 characters
#    When user clicks Edit Account menu item
#    When user changes telephone to "<telephone>"
#    And user clicks Continue button below Edit Account form
#    Then telephone "<telephone>" should be valid and error message "<errorMessage>" is shown if it is invalid
#    Examples:
#      | telephone                         | errorMessage                                   |
#      |                                   | Telephone must be between 3 and 32 characters! |
#      | 12                                | Telephone must be between 3 and 32 characters! |
#      | 123456789123456789123456789000000 | Telephone must be between 3 and 32 characters! |
#
#  Scenario Outline: Validation of the Telephone field in My Account Information (QESDEMO-2478): valid data
## Bug: AC do not mention that the last name must be between between 1 and 32 characters
#    When user clicks Edit Account menu item
#    When user changes telephone to "<telephone>"
#    And user clicks Continue button below Edit Account form
#    Then user is redirected to Personal Account page
#    And message "Success: Your account has been successfully updated." is shown
#    Examples:
#      | telephone                        |
#      | 12345678912345678912345678900000 |
#      | 123                              |