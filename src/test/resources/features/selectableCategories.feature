@DGMARA-13
Feature:Category-User can select shopping subcategory

@DGMARA-45
  Scenario Outline: As a user, I should be able to select  Sub-Category tabs under the Category Module
    Given the user should be able to login with valid credentials
    When the user clicks "<subCategory>"
    Then Then verify that the user is on the "<subCategoryPage>" page
    Examples:
      | subCategory     | subCategoryPage |
      | Health & Beauty | Health & Beauty |
      | Televisions     | Televisions     |
      | TV Accessories  | TV Accessories  |
      | Networking      | Networking      |
