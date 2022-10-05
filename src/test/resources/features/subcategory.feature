@DGMARA-14
Feature:The user should be able to bring the products in the price range user want on the Sub-Category Page by using the PRICE slider.

  @DGMARA-44
  Scenario Outline:The user should be able to using the Price slider
    Given the user should be able to select a "Currency" module "<currencyType>"
    When the user select the "<Category>"
    And  the user selects the "<currencyType>" between 105  and 480 by using the Price slider
    Then  Verify that the user should be able to bring the products with selected "<currency>" between 105  and 480 in the price range
    Examples:
      | Category        | currencyType     | currency |
      | Health & Beauty | $ US Dollar      | $        |
      | Health & Beauty | £ Pound Sterling | £        |
      | Health & Beauty | € Euro           | €        |
