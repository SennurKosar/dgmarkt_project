package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.myAccount.EditPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class editAccountStepDefs {
    EditPage editPage = new EditPage();


    @Given("the user clicks myAccount and edit account button")
    public void theUserClicksMyAccountAndEditAccountButton() {
        editPage.myAccountBtn.click();
        editPage.editAccountBtn.click();
    }



    @And("The user enters new firstname in {string} field")
    public void theUserEntersNewFirstnameInField(String firstNameField) {
        editPage.editFirstName(firstNameField);
    }

    @And("The user enters new lastname in {string} field")
    public void theUserEntersNewLastnameInField(String lastNameField) {
        editPage.editLastName(lastNameField);
    }

    @And("The user enters new email in {string} field")
    public void theUserEntersNewEmailInField(String emailField) {
        editPage.editEmail(emailField);
    }

    @And("The user enters new telephonenumber in {string} field")
    public void theUserEntersNewTelephonenumberInField(String telephoneField) {
        editPage.editTelephone(telephoneField);
    }

    @When("The user enters {string} in {string} field")
    public void theUserEntersInField(String newInput, String field) {
        editPage.editInformation(newInput, field);
    }


    @Then("The user clicks Continue Button")
    public void the_user_clicks_Continue_Button() {

        editPage.continueBtnEditInfo.click();
       // WebElement email = Driver.get().findElement(By.xpath("//input[@type='email']"));
       // System.out.println(email.getAttribute("validationMessage"));


    }

    @Then("Verify that the user received a success alert")
    public void verify_that_the_user_received_a_success_alert() {
        Assert.assertTrue(editPage.successAlert.isDisplayed());

    }


    @And("Verify that the user received an error message")
    public void verifyThatTheUserReceivedAnErrorMessage() {
        editPage.verifyErrorMessageForEdit();


    }

    @Given("the user should be able to login with {string} and {string}")
    public void theUserShouldBeAbleToLoginWithAnd(String useremail, String password) {
        editPage.loginM(useremail,password);

    }


}
