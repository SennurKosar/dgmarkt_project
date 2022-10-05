package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectableCategories_StepDefs extends BasePage {

    @When("the user clicks {string}")
    public void theUserClicks(String subCategory) {
        categoryMenuM(subCategory);
    }

    @Then("Then verify that the user is on the {string} page")
    public void thenVerifyThatTheUserIsOnThePage(String subCategoryPage) {
        textOnThePagesM(subCategoryPage);
    }
}
