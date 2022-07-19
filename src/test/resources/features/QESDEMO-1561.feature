Feature: User is able to login after a successful registration

  Scenario: User is able to login with valid email and password
    Given User is on Login page
    When User enters Login data
      | E-Mail Address   | jonjon@testmail.test |
      | Password         | TestPass_1           |
    And User clicks Login button
    Then User is redirected to User personal page
    And Link "Edit your account information" is available
    And Blocks are presented:
      | My Account  |
      | My Orders   |