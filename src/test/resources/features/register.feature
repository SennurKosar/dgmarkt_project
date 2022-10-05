@DGMARA-3
Feature:Register Function

  Background:
    Given The user click myAccount and select register
    Then  The user should see "Login or create an account" page

  #  Warning: change email before running test. Because the account has been created in the previously run tests,
  #  it cannot be registered with the same account.

  @DGMARA-26
  Scenario Outline:Register Function_positive scenario
    When The user enters valid "<firstname>" , "<lastname>" , "<email>", "<telephone>" ,"<password>" , "<confirm>"
    And  The user click Yes Button on Subscribe box
    And  The user click on Privacy Policy Box
    And  The user click on Continue button
    Then Verify that the user can be register mit valid Credentials
    Then The user click on second Continue button
    Then Verify that the user can be see his Account Page
    Examples:
      | firstname | lastname | email                 | telephone  | password  | confirm   |
      | DG        | Markt    | DG_Markt229@gmail.com | 0123654789 | Test1234! | Test1234! |
      | 123       | Markt    | DG_Markt230@gmail.com | 0123654789 | Test1234! | Test1234! |
      | DG        | 123      | DG_Markt231@gmail.com | 0123654789 | Test1234! | Test1234! |

  @DGMARA-28
  Scenario Outline:Register Function_negative scenario
    When The user enters valid "<firstname>" , "<lastname>" , "<email>", "<telephone>" ,"<password>" , "<confirm>"
    And  The user click Yes Button on Subscribe box
    And  The user click on Privacy Policy Box
    And  The user click on Continue button
    Then Verify that The user should be able to see "<Warnung Message>" and can not be register

    Examples:
      | firstname | lastname | email                 | telephone                         | password              | confirm               | Warnung Message                                |
      | DG        | Markt    |                       | 0123654789                        | Test1234!             | Test1234!             | E-Mail Address does not appear to be valid!    |
      | DG        | Markt    | @gmail.com            | 0123654789                        | Test1234!             | Test1234!             | E-Mail Address does not appear to be valid!    |
      | DG        | Markt    | DG_Marktgmail.com     | 0123654789                        | Test1234!             | Test1234!             | E-Mail Address does not appear to be valid!    |
      | DG        | Markt    | DG_Markt@.com         | 0123654789                        | Test1234!             | Test1234!             | E-Mail Address does not appear to be valid!    |
      | DG        | Markt    | DG_Markt@gmail        | 0123654789                        | Test1234!             | Test1234!             | E-Mail Address does not appear to be valid!    |
      | DG        | Markt    | DG_Markt34@gmail.com  | 0123654789                        | Test1234!             | Test1234!             | Warning: E-Mail Address is already registered! |
      | DG        | Markt    | DG_Markt34@gmail.com  |                                   | Test1234!             | Test1234!             | Telephone must be between 3 and 32 characters! |
      | DG        | Markt    | DG_Markt34@gmail.com  | 01                                | Test1234!             | Test1234!             | Telephone must be between 3 and 32 characters! |
      | DG        | Markt    | DG_Markt34@gmail.com  | 012365478965478963214785631596321 | Test1234!             | Test1234!             | Telephone must be between 3 and 32 characters! |
      | DG        | Markt    | DG_Markt34@gmail.com  | 0123654789                        |                       |                       | Password must be between 4 and 20 characters!  |
      | DG        | Markt    | DG_Markt228@gmail.com | 0123654789                        | 123456789123456789123 | 123456789123456789123 | Password must be between 4 and 20 characters!  |
      | DG        | Markt    | DG_Markt34@gmail.com  | 0123654789                        | 1                     |                       | Password must be between 4 and 20 characters!  |
      | DG        | Markt    | DG_Markt34@gmail.com  | 0123654789                        | Test12345!            | Test1234!             | Password confirmation does not match password! |
      | DG        | Markt    | DG_Markt34@gmail.com  | 0123654789                        | Test1234!             |                       | Password confirmation does not match password! |

  @DGMARA-61
  Scenario Outline:Register Function _not click on Privacy Policy Box
    When The user enters valid "<firstname>" , "<lastname>" , "<email>", "<telephone>" ,"<password>" , "<confirm>"
    And  The user click Yes Button on Subscribe box
    And  The user click on Continue button
    Then Verify that The user should be able to see "<Warnung Message>" and can not be register
    Examples:
      | firstname | lastname | email                | telephone  | password  | confirm   | Warnung Message                                |
      | DG        | Markt    | DG_Markt34@gmail.com | 0123654789 | Test1234! | Test1234! | Warning: You must agree to the Privacy Policy! |

