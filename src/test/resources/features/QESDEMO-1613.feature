Feature: Validate E-Mail field, incorrect input

  Scenario:
    Given User is on Login page
    And User is logged in
    When User clicks Edit Account link
    Then Email field type=email

  Scenario:
    Given User is on Login page
    And User is logged in
    When User clicks Edit Account link
    And User enters whitespace
      | Email  |
    And User clicks Continue button
    Then Tooltip "missing eta" for email " " is displayed
  # fails because instead of tooltip, a warning is displayed - defect, inconsistent with other cases

  Scenario Outline: E-Mail field does not accept invalid values
    Given User is on Login page
    And User is logged in
    When User clicks Edit Account link
    And User enters E-Mail "<Email>"
    And User clicks Continue button
    Then Tooltip "<tooltip>" for email "<Email>" is displayed
    Examples:
      | Email                 | tooltip      |
      | abc123@testmail,test  | comma after  |
      | @testmail.test        | incorrect name   |
      | abc123@testmail       | incorrect domain   |
      | abc123@               | incorrect domain   |
      | abc,123@testmail.test | comma before |
      | 123.testmail.test     | missing eta  |
      | 123test               | missing eta  |

# Third example (abc123@testmail) has a different outcome. Should be the same - defect