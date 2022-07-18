Feature: User can go back not updating My Account info

  Scenario: User edits account info and clicks Back button
    Given User is on Login page
    Given User is logged in
    When User clicks Edit Account link
    And User enters First Name "Jonas"
    And User enters Last Name "Jonukas"
    And User enters E-Mail "jonjon@testmail.test"
    And User enters Telephone "1234512345"
    And User clicks Continue button
    Then User is redirected to User personal page
    And A message is displayed
      | Success Update  |

