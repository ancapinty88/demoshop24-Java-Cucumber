Feature: Edit Account page

  Background: User is on "My Account Page"
    Given user is on "Login" page
    Then user login with valid credentials
      | E-Mail Address   | at@xmail.com   |
      | Password         | auto12345      |
    And user clicks "Login" button
    Then user is on "MyAccount" page

  Scenario Outline: Successful update user data in "Edit Account" page
    When user is on "MyAccount" page
    And user click on "Edit Account" link in sub menu.
    Then "My Account Information" title is present on the page.
    And Page subtitle is "Your Personal Details"
    When user enter new credentials to the Edit Account form fields
      | First Name   | Last Name   | E-Mail   | Telephone   |
      | <First Name> | <Last Name> | <E-Mail> | <Telephone> |
    And user clicks "Continue" button
    Then user is back at the "My Account" page with success message "<message>"
    When user is back at My Account page I press on "Edit Account" link again
    Then user enter previous credentials
      | First Name       | automation       |
      | Last Name        | testing          |
      | E-Mail           | at@xmail.com     |
      | Telephone        | +37122334455     |
    And user clicks "Continue" button
    Examples:
      | First Name | Last Name | E-Mail                | Telephone | message                                            |
      | Lith       | Uania     | lithuania@email.com   | 5432      |Success: Your account has been successfully updated.|


  Scenario Outline: Error messages displayed when input fields are empty on "Edit Account" form submitted
    When user clear all the fields inputs
    And user clicks "Continue" button
    Then I can see "<Error message>" under the "<Input field>" input field
    Examples:
      | Error message                                 | Input field |
      |First Name must be between 1 and 32 characters!| First Name  |
      |Last Name must be between 1 and 32 characters! | Last Name   |
      |E-Mail Address does not appear to be valid!    | E-Mail      |
      |Telephone must be between 3 and 32 characters! | Telephone   |

