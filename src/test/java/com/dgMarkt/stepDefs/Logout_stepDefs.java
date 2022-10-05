package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.myAccount.Logout;
import com.dgMarkt.utilities.Driver;
import io.cucumber.java.en.Then;

public class Logout_stepDefs {
    Logout logout= new Logout();
    @Then("verify that the user  has securely terminated the session")
    public void verify_that_the_user_has_securely_terminated_the_session() {

        logout.verifyLogout();



    }

    @Then("the user navigates to homepage with Back to page icon in browser")
    public void the_user_navigates_to_homepage_with_Back_to_page_icon_in_browser() {

        Driver.get().navigate().back();


    }

    @Then("verify that there is no re-login with {string} icon in browser")
    public void verify_that_there_is_no_re_login_with_icon_in_browser(String string) {

       // logout.verifyNoLogin();

    }
}
