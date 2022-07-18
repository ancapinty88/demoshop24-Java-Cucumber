Feature: Editable user information form has mandatory fields

  Scenario: Edit Account form has four required fields
    Given User is on Login page
    Given User is logged in
    When User clicks Edit Account link
    And User deletes value from field
      | First Name |
      | Last Name  |
      | E-Mail     |
      | Telephone  |
    And User clicks Continue button
    Then A message is displayed
      | First Name |
      | Last Name  |
      | E-Mail     |
      | Telephone  |

    # fails because telephone message should say "7-32" but it actually says "3-32"