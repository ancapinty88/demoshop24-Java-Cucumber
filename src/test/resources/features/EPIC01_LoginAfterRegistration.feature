Feature: EPIC-01 Registration

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


