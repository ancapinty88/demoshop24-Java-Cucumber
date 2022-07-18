Feature: User can successfully update My Account info

  Scenario: User successfully edits account info
    Given User is on Login page
    Given User is logged in
    When User clicks Edit Account link
    And User enters First Name "Petras"
    And User enters Last Name "Petraitis"
    # will skip email changing so that we could keep logging in with original email (jonjon@testmail.test)
    # when running WITH email, go to "And Data is entered" - rows referring to email should not be commented
    # And User enters E-Mail "pp@testmail.test"
    And User enters Telephone "1234567890"
    And User clicks Continue button
    Then User is redirected to User personal page
    And A message is displayed
      | Success Update  |
    And User clicks Edit Account link
    And Data is entered
      | First Name  | Petras           |
      | Last Name   | Petraitis        |
    #  | E-Mail      | pp@testmail.test |
      | Telephone   | 1234567890       |