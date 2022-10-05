#@DGMAR_7
Feature: As a user, I should be able to manage the cart by clicking the cart icon

  Background: The user should be able to enter valid email and password
    Given the user should be able to login with valid credentials
    When The user should be able to hover the Category and then click to "Health & Beauty"
    Then The user should be able to hover over the first product and then click it to the add to cart button.
    Then The user should be able to click the cart button and then see the selected product
    And The user should be able to click on the Cart Symbol button and then click on Checkout button from pop-up.


  Scenario Outline: The user should be able to go to the Checkout page from the cart icon and complete the checkout
    When The user should be able to enter "<First Name>","<Last Name>","<Company>","<Address 1>","<Address 2>","<City>","<Post Code>","<Country>","<RegionState>" and then click on Continue button
    And The user should be able to click radio button (the user select I want to use an existing address) and then click on Continue button
    And The user should be able to control Is the radio button clicked and then enter the text in the comment and click on Continue button.
    And The user should be able to control Is the radio button clicked and enter the text in the comment then click on select button (I have read and agree to the Terms & Conditions) click on Continue button.
    Then The user should be able to click on Continue button
    And The user should be able to click on the Cart Symbol button and see that the cart is empty.
    Examples:
      | First Name | Last Name | Company | Address 1           | Address 2           | City    | Post Code | Country | RegionState |
      | Hans       | Kaan      | Private | Hamburger Strasse 4 | Hamburger Strasse 5 | Hamburg | 012345    | Germany | Hamburg     |
