package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.LoginPanel;
import com.dgMarkt.pages.myAccount.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class Login_stepDefs {

    LoginPanel loginPanel = new LoginPanel();
    LoginPage loginPage =new LoginPage();

    @Given("the user navigates to {string} module {string} tab")
    public void theUserNavigatesToModuleTab(String module, String tab) {
    loginPanel.navigateTo(module,tab);

    }



    @When("the user enters valid {string} and {string} credentials")
    public void the_user_enters_valid_and_credentials(String userEmail, String password) {
    loginPage.login_method(userEmail, password);
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        // String actualResult=popup.loginSuccessText.getText().split("×")[0].trim();
        String actualResult= loginPanel.loginSuccessText.getText().substring(0,34);

        assertEquals("login succesfully text","Congratulation! Login Successfully",actualResult);


    }


    @Given("the user should be able to login with valid credentials")
    public void theUserShouldBeAbleToLoginWithValidCredentials() {
        loginPage.loginM();
    }

    @Then("the user can see warning message and can not login")
    public void the_user_can_see_warning_message_and_can_not_login() {
        String actualtext = loginPage.warningMessageLogin.getText();
        String expectedresult= "Warning: No match for E-Mail Address and/or Password.";
        assertTrue(actualtext.contains(expectedresult));


    }

}
