@DGMARA-20
Feature: Cat-Subcategory-Quick View icon function

  Background:
    Given the user should be able to login with valid credentials

  @DGMARA-32
  Scenario Outline: Verify that when the user hovers over the product, they can see the quick view icon.
    When the user hovers from "<subCategory>" over the product "<productName>"
    Then Verify that the quick view icon is visible.
    Examples:
      | subCategory     | productName                           |
      | Health & Beauty | BaByliss 3663U - Hair rollers         |
      | Televisions     | Cello C1920FS 19\" LED-backlit LCD TV |
      | TV Accessories  | Belkin adapter cable                  |
      | Networking      | ASUS PCE-AC51 - network adapter       |


  @DGMARA-52
  Scenario Outline: Verify that the user can browse the product when the user clicks the quick view icon
    When the user hovers from "<subCategory>" over the product "<productName>"
    And the user clicks quick view button
    Then verify that the user can browse the product "<productName>"
    Examples:
      | subCategory     | productName                           |
      | Health & Beauty | BaByliss 3663U - Hair rollers         |
      | Televisions     | Cello C1920FS 19\" LED-backlit LCD TV |
      | TV Accessories  | Belkin adapter cable                  |
      | Networking      | ASUS PCE-AC51 - network adapter       |

  @DGMARA-34
  Scenario Outline: Verify that the user can add the product to their any list when the user clicks any icon from the quick view popup
    When the user hovers from "<subCategory>" over the product "<productName>"
    And the user clicks quick view button
    And the user clicks "<buttonName>" icon from the quick view popup.
    Then verify that the user can add the product "<productName>" to their "<pageName>"
    Examples:
      | subCategory     | productName                           | buttonName           | pageName           |
      | Health & Beauty | BaByliss 3663U - Hair rollers         | Add to Wish List     | wish list          |
      | Televisions     | Cello C1920FS 19\" LED-backlit LCD TV | Compare this Product | product comparison |
      | TV Accessories  | Belkin adapter cable                  | Add to Cart          | shopping cart      |
      | Networking      | ASUS PCE-AC51 - network adapter       | Add to Cart          | shopping cart      |

  @smoke
  @DGMARA-35
  Scenario Outline: the user can increase the number of the products to add to the cart by filling the box from the quick view popup
    When the user hovers from "<subCategory>" over the product "<productName>"
    And the user clicks quick view button
    And the user enters "<numberProduct>" from the quick view popup
    And the user clicks "<buttonName>" icon from the quick view popup.
    Then verify that there are "<numberProduct>" of this product "<productName>" to their "<pageName>"
    Examples:
      | subCategory     | productName                           | numberProduct | buttonName  | pageName      |
      | Health & Beauty | BaByliss 3663U - Hair rollers         | 3             | Add to Cart | shopping cart |
      | Televisions     | Cello C1920FS 19\" LED-backlit LCD TV | 5             | Add to Cart | shopping cart |
      | TV Accessories  | Belkin adapter cable                  | 2             | Add to Cart | shopping cart |
      | Networking      | ASUS PCE-AC51 - network adapter       | 12            | Add to Cart | shopping cart |