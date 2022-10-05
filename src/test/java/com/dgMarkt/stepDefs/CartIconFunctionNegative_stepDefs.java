package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.category.ShoppingCheckoutPage;
import com.dgMarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CartIconFunctionNegative_stepDefs {
    ShoppingCheckoutPage checkoutPage = new ShoppingCheckoutPage();

    @Then("The user should be able to enter empty {string},{string},{string},{string},{string},{string},{string},{string},{string} and then click on Continue button")
    public void theUserShouldBeAbleToEnterAndThenClickOnContinueButton(String firstName, String lastName, String company, String address_1, String address_2, String city, String pastCode, String country, String regionState) {
        checkoutPage.enterTheInputs("payment-existing", firstName, lastName, company, address_1, address_2, city, pastCode, country, regionState);
        BrowserUtils.waitFor(3);
    }

    @And("The user should be able to see the error text")
    public void theUserShouldBeAbleToSeeTheErrorText(List<String> expectedList) {
        Assert.assertEquals(expectedList, BrowserUtils.getElementsText(checkoutPage.errorMessagesList));
    }

    @And("The user should be able to control Is the radio button clicked and enter the text in the comment then not click on select button \\(I have read and agree to the Terms & Conditions) click on Continue button.")
    public void theUserShouldBeAbleToControlIsTheRadioButtonClickedAndEnterTheTextInTheCommentThenNotClickOnSelectButtonIHaveReadAndAgreeToTheTermsConditionsClickOnContinueButton() {

        Assert.assertTrue(checkoutPage.radioButtons("cod").isSelected());

        checkoutPage.commentArea.get(1).sendKeys("very nice!");

        checkoutPage.continueButtons("button-payment-method").click();

        String expectedText = "Warning: You must agree to the Terms & Conditions!";
        String actualText = checkoutPage.agreeError.getText().split("×")[0].trim();

        Assert.assertEquals(expectedText, actualText);
    }
}
