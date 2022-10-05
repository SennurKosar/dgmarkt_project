package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.category.SubCategoryPage;
import com.dgMarkt.pages.myAccount.orderHistory.OrderHistoryPage;
import com.dgMarkt.pages.myAccount.orderHistory.OrderInformationPage;
import com.dgMarkt.pages.myAccount.orderHistory.ProductReturnsPage;
import com.dgMarkt.pages.myAccount.orderHistory.ReturnInformationPage;
import com.dgMarkt.utilities.Driver;
import io.cucumber.java.en.*;
import static com.dgMarkt.utilities.BrowserUtils.*;
import static org.junit.Assert.*;

public class OrderHistory_StepDefs {
    String firstRowOrderId;
    String expectedProductName;

    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
    OrderInformationPage orderInfoPage = new OrderInformationPage();
    ProductReturnsPage returnsPage = new ProductReturnsPage();
    ReturnInformationPage returnInfoPage = new ReturnInformationPage();


    @When("the user navigates to {string} menu {string} tab")
    public void the_user_navigates_to_menu_tab(String menu, String tab) {
        orderHistoryPage.navigateTo(menu, tab);
    }

    @Then("verify that the user is on the {string} page")
    public void verify_that_the_user_is_on_the_page(String pageName) {
        assertEquals(pageName, orderHistoryPage.textOnThePagesM(pageName));
    }

    @When("the user clicks first view icon")
    public void the_user_clicks_first_view_icon() {
        firstRowOrderId = orderHistoryPage.firstRowOrderID.getText();
        orderHistoryPage.firstRowViewIcon.click();
        expectedProductName = orderInfoPage.orderInfoProductName.getText();
    }

    @Then("verify that  the id number of the purchased product is correct")
    public void verify_that_the_id_number_of_the_purchased_product_is_correct() {
        assertTrue(orderInfoPage.orderInfoOrderID.getText().contains(firstRowOrderId));
    }

    @When("the user clicks Reorder icon")
    public void the_user_clicks_Reorder_icon() {
        orderInfoPage.reOrderButton.click();
    }


    @Then("verify that success message and the product is in the {string}")
    public void verify_that_success_message_and_the_product_is_in_the(String shoppingCart) {
        assertTrue(orderInfoPage.successReorderMessage.getText().contains("Success: You have added "));
        new SubCategoryPage().verifyProductOnThePageList(expectedProductName, shoppingCart);
    }

    @When("the user clicks Return icon")
    public void the_user_clicks_Return_icon() {
        orderInfoPage.returnButton.click();
        scrollToElement(returnsPage.orderID_ReturnsForm);
    }

    @Then("verify that the id number and product name of the purchased product is correct")
    public void verify_that_the_id_number_and_product_name_of_the_purchased_product_is_correct() {
        assertEquals(firstRowOrderId.substring(1), returnsPage.orderID_ReturnsForm.getAttribute("value"));
        assertEquals(expectedProductName, returnsPage.productName_ReturnsForm.getAttribute("value"));
    }

    @When("the user complete the form on the product returns page and clicks submit button")
    public void the_user_complete_the_form_on_the_product_returns_page_and_clicks_submit_button() {
        returnsPage.productReturnsOrderForm();
    }

    @Then("the user should be able to see return request message")
    public void the_user_should_be_able_to_see_return_request_message() {
        assertTrue(Driver.get().getCurrentUrl().contains("success"));
    }

    @When("the user clicks return tab")
    public void the_user_clicks_return_tab() {
        scrollToElement(orderHistoryPage.firstRowOrderID);
        returnsPage.returnsTab.click();
    }

    @Then("verify that the id number of the returned product is correct")
    public void verify_that_the_id_number_of_the_returned_product_is_correct() {
        scrollToElement(returnsPage.returnsTab);
        assertTrue(getElementsText(returnsPage.returnedOrderIDs_List).contains(firstRowOrderId.substring(1)));
    }

    @When("the user clicks view button on the product returns page")
    public void the_user_clicks_view_button_on_the_product_returns_page() {
        returnsPage.returnView.click();
    }

    @Then("verify that the returned product name is correct")
    public void verify_that_the_returned_product_name_is_correct() {
        assertEquals(expectedProductName, returnInfoPage.returnInfoProductName.getText());
    }

    @Then("the user should be able to see on the order details the product information as returned")
    public void the_user_should_be_able_to_see_on_the_order_details_the_product_information_as_returned() {
        scrollToElement(orderInfoPage.orderInfoOrderID);
    }


}
