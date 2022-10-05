package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.category.PopularTagPage;
import com.dgMarkt.pages.category.SubCategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import static com.dgMarkt.utilities.BrowserUtils.waitFor;

public class PopularTags_stepDefs {

    SubCategoryPage subCatpage = new SubCategoryPage();
    PopularTagPage popularTagPage = new PopularTagPage();
    Select subCat;

    @When("the user should be able to see header as {string}")
    public void the_user_should_be_able_to_see_header_as(String header) {

        Assert.assertTrue(subCatpage.getSubCategoryHeader(header).isDisplayed());

    }

    @When("the user should see Popular Tags and select {string} in Popular Tags")
    public void the_user_should_see_Popular_Tags_and_select_in_Popular_Tags(String tag) {
        subCatpage.clickPopularTag(tag);
    }


    @When("the user should see Search page and header as {string}")
    public void the_user_should_see_Search_page_and_header_as(String header) {

        Assert.assertTrue(subCatpage.getSubCategoryHeader(header).isDisplayed());
        waitFor(2);

    }

    @When("the user should see {string} as default option")
    public void the_user_should_see_as_default_option(String selectedOption) {

        popularTagPage.verifyDefaultOption(selectedOption);

    }

    @When("the user clicks Search button")
    public void the_user_clicks_Search_button() {
        popularTagPage.clickSearchButton();
    }

    @Then("verify that the user should be able to see message {string}")
    public void verify_that_the_user_should_be_able_to_see_message(String expectedMessage) {

        popularTagPage.verifyNoProductMessage(expectedMessage);
    }


    @When("the user selects {string}")
    public void the_user_selects(String subCatOption) {
        popularTagPage.selectOption(subCatOption);

    }

    @And("the user clicks Search in product descriptions option")
    public void theUserClicksSearchInProductDescriptionsOption() {

        popularTagPage.clickDescription();
    }


    @Then("the user should be able to see message start with {string}")
    public void the_user_should_be_able_to_see_message_start_with(String expectedMessage) {

        popularTagPage.verifyProductMessage(expectedMessage);
    }



}
