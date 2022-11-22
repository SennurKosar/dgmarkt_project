@smoke
@DGMARA-2
Feature: User-Log out Functionality

  @DGMARA-84
  Scenario: User-Log out Functionality
    Given the user navigates to "My Account" module "Login" tab
    When the user enters valid "newUser1@gmail.com" and "12345" credentials
    And the user navigates to "My Account" module "Logout" tab
    Then verify that the user  has securely terminated the session
    And the user navigates to homepage with Back to page icon in browser
    Then verify that there is no re-login with "Back to page" icon in browser
