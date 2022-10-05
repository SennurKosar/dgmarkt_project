package com.dgMarkt.stepDefs;


import com.dgMarkt.pages.LoginPanel;
import com.dgMarkt.pages.category.ShoppingCartPage;
import com.dgMarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class CartIconFunction_stepDefs {

    LoginPanel loginPanel = new LoginPanel();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Given("The user should be able to hover the Category and then click to {string}")
    public void theUserShouldBeAbleToHoverTheAndThenClickTo(String text) {

        loginPanel.categoryMenuM(text);

        String expectedResult = "Health & Beauty";
        String actualResult = shoppingCartPage.healthAndBeautyPage.getText();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @When("The user should be able to hover over the first product and then click it to the add to cart button.")
    public void theUserShouldBeAbleToHoverOverTheFirstProductAndThenClickItToTheAddToCartButton() {

        shoppingCartPage.addToCartClick(1); // the user click on first product

        String expectedResult = "Success: You have added BaByliss 3663U - Hair rollers to your shopping cart!";
        String actualResult = shoppingCartPage.productPopupText.getText().split("×")[0].trim();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Then("The user should be able to click the cart button and then see the selected product")
    public void theUserShouldBeAbleToClickTheCartButtonAboveAndThenSeeTheSelectedProduct() {

        loginPanel.shopping_cart_loc.click();

        String expectedResult = "BaByliss 3663U - Hair rollers";
        String actualResult = shoppingCartPage.productPopup("BaByliss 3663U - Hair rollers").getText();
        System.out.println("expectedResult = " + expectedResult);
        System.out.println("actualResult = " + actualResult);
        Assert.assertEquals(expectedResult, actualResult);


    }

    @And("The user should be able to click on the Cart Symbol button and then click on View Cart button from pop-up.")
    public void theUserShouldBeAbleToClickOnTheCartSymbolButtonAndThenClickOnViewCartButtonFromPopUp() {

        shoppingCartPage.cartPopupButtons("View Cart");

        String expectedUrl = "https://dgmarkt.com/index.php?route=checkout/cart";
        String actualUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);

    }
}
