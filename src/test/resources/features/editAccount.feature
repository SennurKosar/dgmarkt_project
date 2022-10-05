@DGMARA-8
Feature: As a user, I should be able to  update the user information by clicking the Edit Account tab under the My Account module.

  Background:
    Given the user should be able to login with "userEmailForEdit" and "userPasswordForEdit"

  @DGMARA-49
  Scenario: Verify that the user can update their account information.
    Given the user clicks myAccount and edit account button
    When The user enters new firstname in "firstname" field
    And The user enters new lastname in "lastname" field
    And The user enters new email in "email" field
    And The user enters new telephonenumber in "telephone" field
    And The user clicks Continue Button
    Then Verify that the user received a success alert


  @DGMARA-51
  Scenario Outline: Verify that the error message is displayed when the user incorrectly fills in or does not fill in the required field.
    Given the user clicks myAccount and edit account button
    When The user enters "<firstname>" in "firstname" field
    And The user enters "<lastname>" in "lastname" field
    And The user enters "<email>" in "email" field
    And The user enters "<telephone>" in "telephone" field
    And The user clicks Continue Button
    Then Verify that the user received an error message

    Examples:
      | firstname                         | lastname                          | email                | telephone                         |
      |                                   | emir                              | zehraemir1@gmail.com | 2222222                           |
      | 123456789012345678901234567890123 | emir                              | zehraemir1@gmail.com | 2222222                           |
      | zehra                             |                                   | zehraemir1@gmail.com | 2222222                           |
      | zehra                             | 123456789012345678901234567890123 | zehraemir1@gmail.com | 2222222                           |
      | zehra                             | emir                              |                      | 2222222                           |
      | zehra                             | emir                              | zehraemir@gmail      | 2222222                           |
      | zehra                             | emir                              | zehraemirgmail.com   | 2222222                           |
      | zehra                             | emir                              | zehraemir1@gmail.com | 123456789012345678901234567890123 |










