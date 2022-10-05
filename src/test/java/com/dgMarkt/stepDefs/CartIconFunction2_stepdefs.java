package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.category.ShoppingCartPage;
import com.dgMarkt.pages.category.ShoppingCheckoutPage;
import com.dgMarkt.utilities.BrowserUtils;
import com.dgMarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartIconFunction2_stepdefs {
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    ShoppingCheckoutPage checkoutPage = new ShoppingCheckoutPage();

    @Then("The user should be able to enter {string},{string},{string},{string},{string},{string},{string},{string},{string} and then click on Continue button")
    public void theUserShouldBeAbleToEnterAndThenClickOnContinueButton(String firstName, String lastName, String company, String address_1, String address_2, String city, String pastCode, String country, String regionState) {

        checkoutPage.enterTheInputs("payment-existing", firstName, lastName, company, address_1, address_2, city, pastCode, country, regionState);
        BrowserUtils.waitFor(4);
    }

    @And("The user should be able to click radio button \\(the user select I want to use an existing address) and then click on Continue button")
    public void theUserShouldBeAbleToClickRadioButtonTheUserSelectIWantToUseAnExistingAddressAndThenClickOnContinueButton() {

        Assert.assertTrue(checkoutPage.continueButtons("button-shipping-address").isDisplayed());
        checkoutPage.continueButtons("button-shipping-address").click();

        String expectedResult = "Please select the preferred shipping method to use on this order.";
        String actualResult = checkoutPage.deliveryTexts("shipping");
        System.out.println("actualResult = " + actualResult);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @And("The user should be able to control Is the radio button clicked and then enter the text in the comment and click on Continue button.")
    public void theUserShouldBeAbleToControlIsTheRadioButtonClickedAndThenEnterTheTextInTheCommentAndClickOnContinueButton() {

        Assert.assertTrue(checkoutPage.radioButtons("flat.flat").isSelected());

        checkoutPage.commentArea.get(0).sendKeys("very good!");

        checkoutPage.continueButtons("button-shipping-method").click();

        String expectedResult = "Please select the preferred payment method to use on this order.";
        String actualResult = checkoutPage.deliveryTexts("payment");
        System.out.println("actualResult = " + actualResult);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @And("The user should be able to control Is the radio button clicked and enter the text in the comment then click on select button \\(I have read and agree to the Terms & Conditions) click on Continue button.")
    public void theUserShouldBeAbleToControlIsTheRadioButtonClickedAndEnterTheTextInTheCommentThenClickOnSelectButtonIHaveReadAndAgreeToTheTermsConditionsClickOnContinueButton() {

        Assert.assertTrue(checkoutPage.radioButtons("cod").isSelected());

        checkoutPage.commentArea.get(1).sendKeys("very nice!");

        BrowserUtils.clickWithJS(checkoutPage.agreeCheckbox);

        checkoutPage.continueButtons("button-payment-method").click();


        Assert.assertTrue(checkoutPage.continueButtons("button-confirm").isDisplayed());
    }

    @And("The user should be able to click on Continue button")
    public void theUserShouldBeAbleToClickOnContinueButton() {

        checkoutPage.continueButtons("button-confirm").click();

        String expectedText = "Your Order Has Been Placed!";
        String actualText = checkoutPage.orderSuccessText.getText();

        Assert.assertEquals(expectedText, actualText);
    }

    @Then("The user should be able to click on the Cart Symbol button and see that the cart is empty.")
    public void theUserShouldBeAbleToClickOnTheCartSymbolButtonAndSeeThatTheCartIsEmpty() {

        checkoutPage.shopping_cart_loc.click();

        String expectedText = "Your shopping cart is empty!";
        String actualText = checkoutPage.deliveryTexts("Your shopping cart is empty!");

        Assert.assertEquals(expectedText, actualText);
    }

    @And("The user should be able to click on the Cart Symbol button and then click on Checkout button from pop-up.")
    public void theUserShouldBeAbleToClickOnTheCartSymbolButtonAndThenClickOnCheckoutButtonFromPopUp() {
        shoppingCartPage.cartPopupButtons("Checkout");

        String expectedUrl = "https://dgmarkt.com/index.php?route=checkout/checkout";
        String actualUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
