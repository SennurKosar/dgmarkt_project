@DGMARA-21
Feature:  As a user, I should be able to add the product on wish list by clicking the Add to Wish List icon

  Background:
    Given the user should be able to login with valid credentials

  @DGMARA-58
  Scenario Outline:  when the user hovers over the product, they can see the Add to Wish List icon.
    When the user hovers from "<subCategory>" over the product "<productName>"
    Then Verify that the Add to Wish List icon is visible

    Examples:
      | subCategory     | productName                           |
      | Health & Beauty | BaByliss 3663U - Hair rollers         |
      | Televisions     | Cello C1920FS 19\" LED-backlit LCD TV |
      | TV Accessories  | Belkin adapter cable                  |
      | Networking      | ASUS PCE-AC51 - network adapter       |

  @DGMARA-59
  Scenario Outline: the user can add products to their wish list, When the user clicks Add to Wish List icon,
    When the user hovers from "<subCategory>" over the product "<productName>"
    And the user clicks Add to Wish List icon
    Then verify that the user can add the product "<productName>" to their "wish list"

    Examples:
      | subCategory     | productName                           |
      | Health & Beauty | BaByliss 3663U - Hair rollers         |
      | Televisions     | Cello C1920FS 19\" LED-backlit LCD TV |
      | TV Accessories  | Belkin adapter cable                  |
      | Networking      | ASUS PCE-AC51 - network adapter       |

