Feature: EPIC-01 Registration

  Background: User is at DemoShop registration page (QESDEMO-2239)
    Given user is at DemoShop start page
    And user clicks Account icon at header top menu
    And user clicks Register at header dropdown
    Then user is redirected to Register Account page

  Scenario: New account/user registration - successful registration (QESDEMO-2248)
# Bug: the title of the Register Account page is with "!" on the page, but should be without
    When user fills in registration form with valid credentials
      | firstName       | Lady        |
      | lastName        | Bug         |
      | email           | randomEmail |
      | telephone       | 888         |
      | password        | test        |
      | passwordConfirm | test        |
    And user checks Privacy Policy checkbox
    And user clicks Continue button below Registration form
    Then user is navigated to confirmation page with title: "Your Account Has Been Created"

  Scenario Outline: Validation of the First Name field of the registration form (QESDEMO-2255)
# Bug: "a*" should not be accepted, error message should be displayed
  # (and probably not about the amount of chars, but about invalid symbols - the error text is not specified in AC)
    When user enters first name "<firstName>"
    And user clicks Continue button below Registration form
    Then first name "<firstName>" should be valid and error message "<errorMessage>" is shown if it is invalid
    Examples:
      | firstName                         | errorMessage                                    |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | First Name must be between 1 and 32 characters! |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa8  |                                                 |
      | a                                 |                                                 |
      | a*                                | First Name must be between 1 and 32 characters! |
      |                                   | First Name must be between 1 and 32 characters! |

  Scenario Outline: Telephone field in the registration form: validation (QESDEMO-2275)
# Bug1: "88a" should not be accepted, error message should be displayed
  # (and probably not about the amount of chars, but about invalid symbols - the error text is not specified in AC)
# Bug2: according to AC, lower boundary input is 7; reported to manual test mentors, advised to adjust regex to the actual site behavior
    When user enters telephone "<telephone>"
    And user clicks Continue button below Registration form
    Then telephone "<telephone>" should be valid and error message "<errorMessage>" is shown if it is invalid
    Examples:
      | telephone                         | errorMessage                                   |
      |                                   | Telephone must be between 3 and 32 characters! |
      | 88                                | Telephone must be between 3 and 32 characters! |
      | 888                               |                                                |
      | 888888888888888888888888888888888 | Telephone must be between 3 and 32 characters! |
      | 88888888888888888888888888888888  |                                                |
      | 88a                               | Telephone must be between 3 and 32 characters! |

  Scenario Outline: Registration form: Email field validation (QESDEMO-2260)
# Bug: "email@email.b" should not be accepted, error message should be displayed, but it's not
    When user enters email "<email>"
    And user clicks Continue button below Registration form
    Then email "<email>" should be valid and error message "<errorMessage>" is shown if it is invalid
    Examples:
      | email                | errorMessage                                                                     |
      | email@email.com      |                                                                                  |
      |                      | E-Mail Address does not appear to be valid!                                      |
      | .email@email.com     | E-Mail Address does not appear to be valid!                                      |
      | email..123@email.com | E-Mail Address does not appear to be valid!                                      |
      | email@email.b        | E-Mail Address does not appear to be valid!                                      |
      | email.email.com      | Please include an '@' in the email address. 'email.email.com' is missing an '@'. |
      | @email.com           | Please enter a part followed by '@'. '@email.com' is incomplete.                 |
      | email@               | Please enter a part following '@'. 'email@' is incomplete.                       |
      | email@.email.com     | '.' is used at a wrong position in '.email.com'.                                 |
      | email()@email.com    | A part followed by '@' should not contain the symbol '('.                        |
      | email@email().com    | A part following '@' should not contain the symbol '('.                          |

