@DGMARA-4
Feature:Selecting the currency and completing purchase with correct currency

  @DGMARA-47
  Scenario Outline: Verifying if selected currency matches on the products all categories
    Given the user navigates to "My Account" module "Login" tab
    When the user enters valid "vv@gmail.com" and "Test123!" credentials
    When the user should be able to select a "Currency" module "<currencyType>"
    And the user should be able select a "<product>" from any "<category>"
    Then the user should be able to see the "<selectedCurrency>" under the product
    And the user should be able to add the product into the wish list
    Then the user should be able to see the "<product>" with selected "<currencyType>" and "<price>"in the wish list
    Then the user should be able to "<product>" from the "<category>" add to chart then can see the product with "<selectedCurrency>"
    When the user can click checkout button and start purchase steps
    And the user should be able to complete Billing details,Delivery details, Delivery methods
    Then the user verify that the flat rate has "<selectedCurrency>"
    When the user can copmlete payment method
    Then the user should be able to see "<product>" with "<selectedCurrency>" and "<price>" in the confirm order step

    Examples:
      | currencyType     | category        | product                               | selectedCurrency | price   |
      | € Euro           | Health & Beauty | BaByliss 3663U - Hair rollers         | €                | 133.38€ |
      | £ Pound Sterling | Televisions     | Cello C1920FS 19\" LED-backlit LCD TV | £                | £290.33 |
      | $ US Dollar      | TV Accessories  | Belkin adapter cable                  | $                | $133.00 |
      | € Euro           | Networking      | ASUS ROG STRIX GS-AX3000              | €                | 122.40€ |














