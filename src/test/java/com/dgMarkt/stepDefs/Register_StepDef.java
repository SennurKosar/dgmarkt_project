package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.myAccount.RegisterPage;
import io.cucumber.java.en.*;
import static com.dgMarkt.utilities.BrowserUtils.waitFor;

public class Register_StepDef {

    RegisterPage registerPage = new RegisterPage();

    @Given("The user click myAccount and select register")
    public void theUserClickMyAccountAndSelectRegister()  {registerPage.clickMyAccountAndSelectRegister();}

    @Then("The user should see {string} page")
    public void theUserShouldSeePage(String expectedText) {registerPage.theUserShoulBeSeePage(expectedText);}

    @When("The user enters valid {string} , {string} , {string}, {string} ,{string} , {string}")
    public void the_user_enters_valid(String FirstName, String LastName, String email, String telephone, String password, String confirm) {

        registerPage.fillAForm(FirstName, LastName, email, telephone, password, confirm);

    }

    @When("The user click Yes Button on Subscribe box")
    public void the_user_click_Yes_Button_on_Subscribe_box() {registerPage.yes_btn_loc.click();}

    @When("The user click on Privacy Policy Box")
    public void the_user_click_on_Privacy_Policy_Box() {registerPage.privacy_Policy_loc.click();}

    @When("The user click on Continue button")
    public void the_user_click_on_Continue_button() {
        registerPage.continue_Btn_loc.click();
        waitFor(3);
    }

    @Then("Verify that the user can be register mit valid Credentials")
    public void verify_that_the_user_can_be_register_mit_valid_Credentials() {

        registerPage.theUserCanBeRegisterMitValidCredentials();
    }

    @Then("The user click on second Continue button")
    public void the_user_click_on_second_Continue_button() {
        registerPage.continue2_Btn_loc.click();
    }

    @Then("Verify that the user can be see his Account Page")
    public void verify_that_the_user_can_be_see_his_Account_Page() {registerPage.theUserCanBeSeeHisAccountPage();}

    @Then("Verify that The user should be able to see {string} and can not be register")
    public void theUserShouldBeAbleTo(String message) {
        registerPage.theUserShouldBeAbleToSeeWarnungMsgCanNotBeRegister(message);
    }
}
