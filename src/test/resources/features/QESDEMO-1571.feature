Feature: Validate E-Mail field, incorrect input

  Scenario:
    Given User is on Register Account page
    Then Email field type=email

  Scenario Outline: E-Mail field does not accept invalid values
    Given User is on Register Account page
    When User enters E-Mail "<Email>"
    And User clicks Continue button
    Then Email tooltip is displayed
    Examples:
      | Email                 |
      | abc123@testmail,test  |
      | @testmail.test        |
      | abc123@testmail       |
      | abc123@               |
      | abc,123@testmail.test |
      | 123.testmail.test     |
      | 123test               |

# Third example (abc123@testmail) has a different outcome. Should be the same - defect