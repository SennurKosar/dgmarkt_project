@DGMARA-19
Feature: As a user i should be able to navigate to popular tags.

  Background:

    Given the user should be able to login with valid credentials

  @DGMARA-46
  Scenario Outline: The user should confirm the message 'There are no products matching your search criteria'
  when they cannot find the product they are looking for in popular products.

    When the user hovers over the Category button and sees "<subCategory>" button and clicks
    And the user should be able to see header as "<Header>"
    And the user should see Popular Tags and select "<product>" in Popular Tags
    And the user should see Search page and header as "<Search-product>"
    And the user should see "All Categories" as default option
    And the user clicks Search button
    Then verify that the user should be able to see message "There is no product that matches the search criteria."


    Examples:
      | subCategory     | Header          | product   | Search-product     |
      | Health & Beauty | Health & Beauty | Amazon    | Search - Amazon    |
      | Televisions     | Televisions     | Apple     | Search - Apple     |
      | TV Accessories  | TV Accessories  | IPhone    | Search - IPhone    |
      | Networking      | Networking      | Headphone | Search - Headphone |
      | Televisions     | Televisions     | Bluetooth | Search - Bluetooth |
      | TV Accessories  | TV Accessories  | Speaker   | Search - Speaker   |


  @DGMARA-48
  Scenario Outline: User should see products they are looking for in popular products
    When the user hovers over the Category button and sees "<subCategory>" button and clicks
    And the user should be able to see header as "<Header>"
    And the user should see Popular Tags and select "<product>" in Popular Tags
    And the user should see Search page and header as "<Search-product>"
    And the user should see "All Categories" as default option
    And the user selects "<subCategory>"
    And the user clicks Search in product descriptions option
    And the user clicks Search button
    Then the user should be able to see message start with "Showing"


    Examples:
      | subCategory     | Header          | product   | Search-product     |
      | Health & Beauty | Health & Beauty | Amazon    | Search - Amazon    |
      | Televisions     | Televisions     | Apple     | Search - Apple     |
      | TV Accessories  | TV Accessories  | IPhone    | Search - IPhone    |
      | Networking      | Networking      | Headphone | Search - Headphone |
      | Televisions     | Televisions     | Bluetooth | Search - Bluetooth |
      | TV Accessories  | TV Accessories  | Speaker   | Search - Speaker   |
      | Networking      | Networking      | Bose      | Search - Bose      |


