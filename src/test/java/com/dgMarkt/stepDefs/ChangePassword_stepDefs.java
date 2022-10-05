package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChangePassword_stepDefs extends BasePage {


    @And("the user clicks again the My Account in the upper right corner")
    public void theUserClicksAgainTheMyAccountInTheUpperRightCorner() {
        BrowserUtils.waitFor(2);
        myAccount.click();
    }

    @And("the user chooses My Account button under the My Account in the upper right corner")
    public void theUserChoosesMyAccountButtonUnderTheMyAccountInTheUpperRightCorner() {
        BrowserUtils.waitFor(1);
        myAccountSecond.click();
    }

    @And("the user clicks the Password option on the right and scrolls down the page")
    public void theUserClicksThePasswordOptionOnTheRightAndScrollsDownThePage() {
        BrowserUtils.waitFor(1);
        passwordForChange.click();
    }

    @And("the user enters new password into Password box")
    public void theUserEntersNewPasswordIntoPasswordBox() {
        BrowserUtils.waitFor(1);
        inputPassword.sendKeys("Test123456!!1");
    }

    @When("the user enters same password into Password Confirm box")
    public void theUserEntersSamePasswordIntoPasswordConfirmBox() {
        BrowserUtils.waitFor(1);
        BrowserUtils.scrollToElement(inputConfirm);
        BrowserUtils.waitFor(1);
        inputConfirm.sendKeys("Test123456!!1");
    }

    @And("the user clicks the Continue button")
    public void theUserClicksTheContinueButton() {
        BrowserUtils.scrollToElement(continueButton);
        BrowserUtils.waitFor(1);
        continueButton.click();
    }

    @Then("the user verifies the message {string}")
    public void theUserVerifiesTheMessage(String verifyMsg) {
        BrowserUtils.waitFor(2);
        Assert.assertEquals(verifyMsg,changePswrdVrfyMsg.getText());
    }

    @When("the user enters different password into Password Confirm box")
    public void theUserEntersDifferentPasswordIntoPasswordConfirmBox() {
        BrowserUtils.waitFor(1);
        BrowserUtils.scrollToElement(inputConfirm);
        BrowserUtils.waitFor(1);
        inputConfirm.sendKeys("Test12345");
    }

    @Then("the user verifies the error message {string}")
    public void theUserVerifiesTheErrorMessage(String errorVrfyMsg) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(errorVrfyMsg,changePswrdErrorVrfyMsg.getText());
    }
}
