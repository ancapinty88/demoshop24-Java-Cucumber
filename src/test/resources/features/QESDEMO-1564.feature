Feature: Edit Account menu item contains title and sub-title

  Scenario: Edit Account menu item contains title and sub-title
    Given User is on Login page
    Given User is logged in
    When User clicks Edit Account link
    Then Title is "My Account Information"
    And Subtitle is "Your Personal Details"
