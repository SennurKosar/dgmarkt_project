@DGMARA-17
Feature: As a user, I should be able to sort the products on my page in the category

  Background:
    Given the user should be able to login with valid credentials
    And the user hovers over the Category button and sees "Health & Beauty" button and clicks
    Then verify that the user is on the "Health & Beauty" page

  @DGMARA-64
  Scenario: Verify that the Sort By tab initially shows default
    When the user clicks dropbox menu next to Sort by button
    Then the user should be able to see "Default" in dropbox menu

  @DGMARA-66
  Scenario Outline:The user should be able to sort
    When the user clicks dropbox menu next to Sort by button
    Then the user should be able to sort the products by clicking "<Sort Tab>"

    Examples:
      | Sort Tab           |
      | Name (A - Z)       |
      | Name (Z - A)       |
      | Price (Low > High) |
      | Price (High > Low) |
      | Rating (Highest)   |
      | Rating (Lowest)    |
      | Model (A - Z)      |
      | Model (Z - A)      |