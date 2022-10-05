#@DGMAR_7
Feature: As a user, I should be able to manage the cart by clicking the cart icon

  Background: The user should be able to enter valid email and password
    Given the user should be able to login with valid credentials

  Scenario: The user should be able to see the products added to the cart by clicking the cart icon and access the cart from the view cart button
    When The user should be able to hover the Category and then click to "Health & Beauty"
    Then The user should be able to hover over the first product and then click it to the add to cart button.
    Then The user should be able to click the cart button and then see the selected product
    And The user should be able to click on the Cart Symbol button and then click on View Cart button from pop-up.