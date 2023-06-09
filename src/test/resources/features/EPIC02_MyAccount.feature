Feature: EPIC-02 My Account

  Background: User is at DemoShop personal page (QESDEMO-2297)
    Given user is at DemoShop start page
    And user clicks Account icon at header top menu
    And user clicks Login at header dropdown
    And user enters email "LadyBug@mail.com" under returning customer
    And user enters password "test" under returning customer
    And user clicks Login button under returning customer
    Then user is redirected to Personal Account page

  Scenario: Presence of account block, orders block, edit account link (QESDEMO-2295)
    When user sees My Account block
    And user sees My Orders block
    Then user sees Edit Account link

  Scenario: Links of My Account section on the left side: validation (QESDEMO-2448)
    Then user sees My Account links
      | Edit your account information    |
      | Change your password             |
      | Modify your address book entries |
      | Modify your wish list            |

  Scenario: Links of My Orders section on the left side: validation (QESDEMO-2449)
#  Bug: "View your return request" in AC, but actual value is "View your return requests";
#  test relies on the actual value
    Then user sees My Orders links
      | View your order history   |
      | Downloads                 |
      | Your Reward Points        |
      | View your return requests |
      | Your Transactions         |
      | Recurring payments        |

  Scenario: Links of My Affiliate Account and Newsletter sections on the left side: validation (QESDEMO-2450)
    Then user sees My Affiliate Account links
      | Register for an affiliate account |
    And user sees Newsletter links
      | Subscribe / unsubscribe to newsletter |

  Scenario: Menu links on the right side: validation (QESDEMO-2447)
    Then user sees menu links on the right side
      | My Account         |
      | Edit Account       |
      | Password           |
      | Address Book       |
      | Wish List          |
      | Order History      |
      | Downloads          |
      | Recurring payments |
      | Reward Points      |
      | Returns            |
      | Transactions       |
      | Newsletter         |
      | Logout             |

  Scenario: Check that "Edit Account" menu item contains specific title and sub-title (QESDEMO-2468)
    When user clicks Edit Account menu item
    Then user is navigated to confirmation page with title: "My Account Information"
    And user is navigated to page with subtitle "Your Personal Details"

  Scenario: "Edit Account" menu item fields visibility and defaults check (QESDEMO-2469)
#    Mandatoriness of the fields is verified in other TCs when leaving the fields empty
    When user clicks Edit Account menu item
    Then user can see all the fields and buttons under Edit Account
      | firstName      |
      | lastName       |
      | email          |
      | telephone      |
      | buttonContinue |
      | buttonBack     |
    And user can see asterisks "\"* \"" next to the mandatory fields at Edit Account form
      | firstName |
      | lastName  |
      | email     |
      | telephone |