package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.CheckoutPage;
import com.dgMarkt.pages.MyWishListPage;
import com.dgMarkt.pages.category.ShoppingCartPage;
import com.dgMarkt.pages.category.SubCategoryPage;
import com.dgMarkt.pages.myAccount.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class CurrencyFunc_stepDefs {
    LoginPage loginPage = new LoginPage();
    SubCategoryPage subCategoryPage = new SubCategoryPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    MyWishListPage myWishListPage = new MyWishListPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @When("the user should be able to select a {string} module {string}")
    public void theUserShouldBeAbleToSelectAModule(String CurrencyModule, String currencyType) {

        loginPage.navigateTo(CurrencyModule, currencyType);
    }


    @And("the user should be able select a {string} from any {string}")
    public void theUserShouldBeAbleSelectAFromAny(String category, String productName) {

        subCategoryPage.clickProduct(category, productName);
    }


    @Then("the user should be able to see the {string} under the product")
    public void theUserShouldBeAbleToSeeTheSelectedUnderTheProduct(String selectedCurrency) {

        subCategoryPage.verifyingProductCurrency(selectedCurrency);
    }


    @And("the user should be able to add the product into the wish list")
    public void theUserShouldBeAbleToAddTheProductIntoTheWishList() {

        myWishListPage.addProductToWishList();
    }

    @Then("the user should be able to see the {string} with selected {string} and {string}in the wish list")
    public void theUserShouldBeAbleToSeeTheWithSelectedAndInTheWishList(String product, String currency, String price) {

        myWishListPage.verifyWishListCurrency(product, currency, price);

    }

    @Then("the user should be able to {string} from the {string} add to chart then can see the product with {string}")
    public void theUserShouldBeAbleToFromTheAddToChartThenCanSeeTheProductWith(String product, String category, String selectedCurrency) {
        myWishListPage.addProductToCartFromWishList(product);
        shoppingCartPage.verifyingCurrencyInTheCart(product,category, selectedCurrency);
    }

    @When("the user can click checkout button and start purchase steps")
    public void the_user_can_click_checkout_button_and_start_purchase_steps() {

        shoppingCartPage.clickCheckoutBtn();
    }

    @When("the user should be able to complete Billing details,Delivery details, Delivery methods")
    public void the_user_should_be_able_to_complete_Billing_details_Delivery_details_Delivery_methods() {

        checkoutPage.billingAndDeliveryDetails();
    }

    @Then("the user verify that the flat rate has {string}")
    public void theUserVerifyThatTheFlatRateHas(String currency) {

        checkoutPage.verifyingFlatRate(currency);
    }

    @When("the user can copmlete payment method")
    public void the_user_copmlete_payment_method() {

        checkoutPage.copmletePayment();
    }


    @Then("the user should be able to see {string} with {string} and {string} in the confirm order step")
    public void theUserShouldBeAbleToSeeWithAndInTheConfirmOrderStep(String product, String currency, String price) {

        checkoutPage.verifyingConfirOrderCurrency(product, currency);
    }


}
