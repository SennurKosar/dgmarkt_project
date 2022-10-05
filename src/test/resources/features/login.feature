
@DGMARA-1
Feature:  As a user, I should be able to login with valid credential

@DGMARA-81
  Scenario: The user can log in by entering the correct information

    Given the user navigates to "My Account" module "Login" tab
    When the user enters valid "newUser1@gmail.com" and "12345" credentials
    Then the user should be able to login


  @DGMARA-83
  Scenario Outline: The user can not login with invalid credential
    Given the user navigates to "My Account" module "Login" tab
    When the user enters valid "<Email>" and "<Password>" credentials
    Then the user can see warning message and can not login
    Examples:
      | Email     | Password |
      | 1eg@eg.com |          |
      | 2eg@eg.com | 123      |
      | 3e@eg.com  | 12345    |
      | 4egeg.com  | 12345    |
      | 6e@g.com   | 12345    |
      | 7egeg.     | 12345    |
      |      ee     | 12345    |

