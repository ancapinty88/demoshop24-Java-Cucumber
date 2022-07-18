Feature: User cannot update his E-Mail to the one that is already registered

  Scenario: User tries to update email to the one that is already registered
    Given User is on Login page
    Given User is logged in
    When User clicks Edit Account link
    And User enters E-Mail "jj1@testmail.test"
    And User clicks Continue button
    Then A message is displayed
      | Email Already Registered  |

  # test fails because of inconsistent message:
  # during registration message is "E-Mail Address..." (capital A in address)
  # during edit account message is "E-Mail address..." (lowercase a in address)