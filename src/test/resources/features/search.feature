#Users Story: As a user I should be able to search in the search engine.
#Acceptance Criteria :
#1- Verify that the product is displayed when the user searches for the item on the website
#2-Verify that the message "product not found" is displayed when the user searches for the item that is not on the website

@DGMARA-5
Feature:  Search Function

  @DGMARA-77
  Scenario Outline: Product is displayed when the user searches for the item on the website without login
    When The user is on the "<page>" page and click on search button without user login and enters product "<name>"
    Then Product "<name>" is displayed
    Examples:
      | page       | name                              |
      | Specials   | ASUS PCE-AX58BT - network adapter |
      | Contact Us | ASUS PCE-AX58BT - network adapter |
      | About Us   | ASUS PCE-AX58BT - network adapter |
      | Blog       | ASUS PCE-AX58BT - network adapter |

  @DGMARA-78
  Scenario Outline: Product is displayed when the user searches for the item on the website without login
    When The user is on the "<category>" category and click on search button without user login and enters product "<name>"
    Then Product "<name>" is displayed
    Examples:
      | category        | name                              |
      | Health & Beauty | ASUS PCE-AX58BT - network adapter |
      | Televisions     | ASUS PCE-AX58BT - network adapter |
      | TV Accessories  | ASUS PCE-AX58BT - network adapter |
      | Networking      | ASUS PCE-AX58BT - network adapter |

  @DGMARA-79
  Scenario Outline:  "product not found" is displayed when the user searches for the item that is not on the website
    When The user is on the "<category>" page and click on search button without user login and enters invalid product "<name>"
    Then "There are no products to list in this category." is displayed
    Examples:
      | category        | name           |
      | Health & Beauty | Iphone         |
      | Televisions     | Samsung Galaxy |
      | TV Accessories  | XXNintendo     |
      | Networking      | Playstation    |





