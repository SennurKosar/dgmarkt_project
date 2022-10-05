@DGMAR_7
Feature: As a user, I should be able to manage the cart by clicking the cart icon

  Background: The user should be able to enter valid email and password
    Given the user should be able to login with valid credentials
    When The user should be able to hover the Category and then click to "Health & Beauty"
    Then The user should be able to hover over the first product and then click it to the add to cart button.
    Then The user should be able to click the cart button and then see the selected product
    And The user should be able to click on the Cart Symbol button and then click on Checkout button from pop-up.

  Scenario Outline: The user should be able to enter the empty info and can be see the error messages
    When The user should be able to enter empty "<First Name>","<Last Name>","<Company>","<Address 1>","<Address 2>","<City>","<Post Code>","<Country>","<RegionState>" and then click on Continue button
    And The user should be able to see the error text
      | First Name must be between 1 and 32 characters! |
      | Last Name must be between 1 and 32 characters!  |
      | Address 1 must be between 3 and 128 characters! |
      | City must be between 2 and 128 characters!      |
      | Please select a country!                        |
      | Please select a region / state!                 |

    Examples:
      | First Name | Last Name | Company | Address 1 | Address 2 | City | Post Code | Country               | RegionState           |
      |            |           |         |           |           |      |           | --- Please Select --- | --- Please Select --- |


  Scenario Outline: The user should be able to not click radio button and can be see the error message
    When The user should be able to enter "<First Name>","<Last Name>","<Company>","<Address 1>","<Address 2>","<City>","<Post Code>","<Country>","<RegionState>" and then click on Continue button
    And The user should be able to click radio button (the user select I want to use an existing address) and then click on Continue button
    And The user should be able to control Is the radio button clicked and then enter the text in the comment and click on Continue button.
    And The user should be able to control Is the radio button clicked and enter the text in the comment then not click on select button (I have read and agree to the Terms & Conditions) click on Continue button.
    Examples:
      | First Name | Last Name | Company | Address 1           | Address 2           | City    | Post Code | Country | RegionState |
      | Hans       | Kaan      | Private | Hamburger Strasse 4 | Hamburger Strasse 5 | Hamburg | 012345    | Germany | Hamburg     |