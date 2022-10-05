package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.category.SubCategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class NumberOfProduct_stepDefs {

    SubCategoryPage subCategoryPage = new SubCategoryPage();

    @And("the user select the category {string}")
    public void theUserSelectTheCategory(String category) {

        subCategoryPage.categoryMenuM(category);

    }

    @Then("the user can click show tab then the user see default number {int} of products in the sub category page")
    public void theUserCanClickShowTabThenTheUserSeeDefaultNumberOfProductsInTheSubCategoryPage(int defaultNumber) {
        subCategoryPage.verifyDefaultNumberShowTab(defaultNumber);
    }

    @Then("the user should be able to see the same number of products according to {string}")
    public void theUserShouldBeAbleToSeeTheSameNumberOfProductsAccordingTo(String selectShowTab) {
        subCategoryPage.verifyingReplaceShowTab(selectShowTab);
    }
}