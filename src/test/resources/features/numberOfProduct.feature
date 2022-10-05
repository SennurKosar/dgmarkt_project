@DGMARA-18
Feature:Changing the number of products seen on the sub category page

  @DGMARA-55
  Scenario Outline:As a user I should be able to change the number of products seen on the page

    Given the user navigates to "My Account" module "Login" tab
    When the user enters valid "vv@gmail.com" and "Test123!" credentials
    And the user select the category "<subCategory>"
    Then the user can click show tab then the user see default number 12 of products in the sub category page
    Then the user should be able to see the same number of products according to "<selectShowTab>"
    Examples:
      | subCategory     | selectShowTab |
      | Health & Beauty | 25            |
      | Televisions     | 50            |
      | Networking      | 75            |
      | TV Accessories  | 100           |














