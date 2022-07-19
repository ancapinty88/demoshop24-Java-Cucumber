Feature: User can go back not updating My Account info

  Scenario: User edits account info and clicks Back button
    Given User is on Login page
    Given User is logged in
    When User clicks Edit Account link
    And User enters First Name "Petras"
    And User enters Last Name "Petraitis"
    And User enters E-Mail "pp@testmail.test"
    And User enters Telephone "1234567890"
    And User clicks Back button
    Then User is redirected to User personal page
    And User clicks Edit Account link
    And Data is not entered
      | First Name  | Petras           |
      | Last Name   | Petraitis        |
      | E-Mail      | pp@testmail.test |
      | Telephone   | 1234567890       |
