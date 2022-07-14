Feature: New user is able to register successfully
  # to successfully run this test change email
  Scenario Outline: New user registration
    Given User is on Register Account page
    When User enters First Name "<First Name>"
    And User enters Last Name "<Last Name>"
    And User enters E-Mail "<E-Mail>"
    And User enters Telephone "<Telephone>"
    And User enters Password "<Password>"
    And User enters Password Confirm "<Password Confirm>"
    And User selects Subscribe option "<Subscribe>"
    And User ticks Privacy Policy checkbox
    And User clicks Continue button
    Then User is redirected to confirmation page
    And Confirmation message is displayed: "Your Account Has Been Created!"
    Examples:
  | First Name | Last Name	| E-Mail	          | Telephone	| Password	| Password Confirm  | Subscribe |
  | Jonas	   | Jonaitis	| aj1@testmail.test | +371-123-456789	| TestPass_1	| TestPass_1 | yes |
  | Jonas Petras | Jonaitis Petraitis | aj@testmail.test.com | +370123456789	| abcd	| abcd | yes      |
  | Jonas-Petras | Jonaitis-Petraitis | a.jj@testmail.test | +370(123)456789	| 123456789012345abcde | 123456789012345abcde | yes |
  | J	         | J	              | ajj2@testmail.com	    | 123(456)789012345678901234567890 | Test Pass | Test Pass | no |
  | Jonas Petras Jonas Petras JonasP | Jonas Petras Jonas Petras JonasP	| ajj3@testmail.com | 1234567 | TestPass_1 | TestPass_1 | no |
