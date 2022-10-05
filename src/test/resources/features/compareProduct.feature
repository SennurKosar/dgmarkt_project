@DGMARA-22
Feature: As a user, I should be able to compare the product by clicking the Compare this Product icon.

  @DGMARA-53
  Scenario Outline: Verify that when the user hovers over the product, they can see the Compare this Product icon.
    When the user hovers from "<subCategory>" over the product "<productName>"
    Then verify that the user should be able to see Compare icon

    Examples:
      | subCategory     | productName                           |
      | Health & Beauty | BaByliss 3663U - Hair rollers         |
      | Televisions     | Cello C1920FS 19\" LED-backlit LCD TV |
      | TV Accessories  | Belkin adapter cable                  |
      | Networking      | ASUS PCE-AC51 - network adapter       |




  @DGMARA-54
  Scenario: Verify that the user can add products to the comparison list when the user clicks the Compare This Product icon.
    When the user hovers from "Health & Beauty" over the product "BaByliss 3663U - Hair rollers"
    And the user clicks Compare this icon
    And the user sees Success alert
    And the user clicks "product comparison" on the success alert
    Then verify that user should be see "BaByliss 3663U - Hair rollers" in the comparison list