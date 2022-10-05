@DGMARA-9
Feature: My Account-User can Change password

  Background: As a user
    Given the user should be able to login with "changeUserEmail" and "changeUserPassword"
    And the user clicks again the My Account in the upper right corner
    And the user chooses My Account button under the My Account in the upper right corner
    And the user clicks the Password option on the right and scrolls down the page
    And the user enters new password into Password box
  @DGMARA-38
    Scenario: As a user, I should be verify that the user can change the password
      When  the user enters same password into Password Confirm box
      And the user clicks the Continue button
      Then the user verifies the message " Success: Your password has been successfully updated."

  @DGMARA-39
  Scenario: As a user, I should be verify that the user can not change the password
    When the user enters different password into Password Confirm box
    And the user clicks the Continue button
    Then the user verifies the error message "Password confirmation does not match password!"


    #Given the user should be able to login with valid credentials
    #      And the user clicks again the My Account in the upper right corner
    #      And the user chooses My Account button under the My Account in the upper right corner
    #      And the user clicks the Password option on the right and scrolls down the page
    #      And the user enters new password into Password box
    #      And  the user enters same password into Password Confirm box


