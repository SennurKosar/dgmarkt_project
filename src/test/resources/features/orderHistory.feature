@DGMARA-12
Feature: As a user, I should be able to  see and modify  order history  by clicking the Order History tab under the My Account module.


  Background:
    Given the user should be able to login with valid credentials

  @DGMARA-36
  Scenario: Verify that the user can see the order history by clicking the Order History tab.
    When the user navigates to "My Account" menu "Order History" tab
    Then verify that the user is on the "Order History" page

  @DGMARA-41
  Scenario: Verify that the user can access the order detail by clicking the view icon
    When the user navigates to "My Account" menu "Order History" tab
    And the user clicks first view icon
    Then verify that the user is on the "Order Information" page
    Then verify that  the id number of the purchased product is correct

  @DGMARA-42
  Scenario: Verify that the user can re-order an item from their order history
    When the user navigates to "My Account" menu "Order History" tab
    And the user clicks first view icon
    And the user clicks Reorder icon
    Then verify that success message and the product is in the "shopping cart"

  @DGMARA-43
  Scenario: Verify that the user can return an item from their order history
    When the user navigates to "My Account" menu "Order History" tab
    And the user clicks first view icon
    And the user clicks Return icon
    Then verify that the id number and product name of the purchased product is correct
    When the user complete the form on the product returns page and clicks submit button
    Then the user should be able to see return request message

  @DGMARA-56
  Scenario: Verify that the user can see the returned product on the product returns page
    When the user navigates to "My Account" menu "Order History" tab
    And the user clicks first view icon
    When the user clicks return tab
    Then verify that the user is on the "Product Returns" page
    Then verify that the id number of the returned product is correct

  @DGMARA-57
  Scenario: Verify that the user can access the return details by clicking the view icon
    When the user navigates to "My Account" menu "Order History" tab
    And the user clicks first view icon
    And the user clicks return tab
    When the user clicks view button on the product returns page
    Then verify that the user is on the "Return Information" page
    Then verify that the returned product name is correct




