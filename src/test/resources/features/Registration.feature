Feature: Registration

  #QESDEMO-2743
Background: User is on "Register Account" page
  Given open home page
  And check that navigation header bar is visible with following icons: valuta, contact, my account, wish list, shopping cart, checkout
  And click on My account icon on the navigation header bar
  And Click on Register option from My account menu
  Then user is redirected to Register Account page

  #QESDEMO-2744
Scenario Outline: User is able to register a new account
  Then Fill all input fields in register account page "<FirstName>" "<LastName>" "<Email>""<Telephone>" "<Password>" "<PasswordConfirm>" "<Subscribe>":
  And  Click on I have read and agree to the Privacy Policy checkbox
  Then Click the Continue button
  Then Assert and check the page

  Examples:
    | FirstName | LastName |  Email              | Telephone | Password   | PasswordConfirm | Subscribe |
    | Ank       | Pin      |  ank@gmail33.com    | 145265542 | 1Password7 | 1Password7      | No        |
    | Mar       | Leo      |  mar@gmail1.com     | 458255588 | 123#Pass   | 123#Pass        | Yes       |
    | Ion       | Dan      |  dan@gmail1.com     | 458678988 | Pass#12    | Pass#12         | No        |

  #QESDEMO-2753
Scenario Outline: E-mail address field validation
  Then Fill all input fields in register account page, existing email address "<FirstName>" "<LastName>" "<Email>""<Telephone>" "<Password>" "<PasswordConfirm>" "<Subscribe>":
  #but fill e-mail input field with an existing e-mail address in the Register Account page
  And Click on I have read and agree to the Privacy Policy checkbox
  Then Click the Continue button
  Then Check warning message
  Examples:
    | FirstName | LastName |  Email              | Telephone | Password   | PasswordConfirm | Subscribe |
    | Ank       | Pin      |  ank@gmail33.com    | 145265542 | 1Password7 | 1Password7      | No        |

#QESDEMO-2752
  Scenario Outline: Unsuccessful registration - password less than 4 characters
  Then Fill all input fields in register account page "<FirstName>" "<LastName>" "<Email>""<Telephone>" "<Password>" "<PasswordConfirm>" "<Subscribe>":
#Password length == 3
  And Click on I have read and agree to the Privacy Policy checkbox
  Then Click the Continue button
  Examples:
    | FirstName | LastName  |  Email               | Telephone   | Password | PasswordConfirm | Subscribe |
    | Din       | Dong      |  din@gmail33.com     | 145265542   | P1#      | P1#             | No        |

#QESDEMO-2742
Scenario Outline: Unsuccessful registration - empty mandatory fields
  Then Fill all input fields in register account page "<FirstName>" "<LastName>" "<Email>""<Telephone>" "<Password>" "<PasswordConfirm>" "<Subscribe>":
  #And  Click on I have read and agree to the Privacy Policy checkbox
  Then 	Click the Continue button
  Examples:
    | FirstName | LastName | Email | Telephone | Password | PasswordConfirm | Subscribe |
    |           |          |       |           |          |                 |           |

