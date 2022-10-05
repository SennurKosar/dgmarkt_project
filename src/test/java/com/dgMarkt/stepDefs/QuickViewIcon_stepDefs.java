package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.category.SubCategoryPage;
import io.cucumber.java.en.*;

import static com.dgMarkt.utilities.BrowserUtils.verifyElementDisplayed;
import static org.junit.Assert.assertTrue;

public class QuickViewIcon_stepDefs {

    SubCategoryPage subCategoryPage = new SubCategoryPage();


    @When("the user hovers from {string} over the product {string}")
    public void the_user_hovers_from_over_the_product(String subCategory, String productName) {
        subCategoryPage.hoverProduct_met(subCategory, productName);

    }

    @Then("Verify that the quick view icon is visible.")
    public void verify_that_the_quick_view_icon_is_visible() {
        verifyElementDisplayed( subCategoryPage.quickViewBtn);

    }


    @And("the user clicks quick view button")
    public void the_user_clicks_quick_view_button() {
        subCategoryPage.quickViewBtn.click();

    }

    @Then("verify that the user can browse the product {string}")
    public void verify_that_the_user_can_browse_the_product(String productName) {
        String actualText = subCategoryPage.textOfProductcode_met(productName);
        assertTrue(actualText.equalsIgnoreCase(productName));
    }

    @And("the user clicks {string} icon from the quick view popup.")
    public void the_user_clicks_icon_from_the_quick_view_popup(String buttonName) {
        subCategoryPage.clickButtonOnTheViewIcon(buttonName);

    }

    @Then("verify that the user can add the product {string} to their {string}")
    public void verify_that_the_user_can_add_the_product_to_their(String productName, String pageName) {
        assertTrue(subCategoryPage.verifyProductOnThePageList(productName, pageName));

    }

    @When("the user enters {string} from the quick view popup")
    public void the_user_enters_the_number_of_product_from_the_quick_view_popup(String numberProduct) {
        subCategoryPage.productNumberInput_met(numberProduct);
    }

    @Then("verify that there are {string} of this product {string} to their {string}")
    public void verify_that_there_are_of_this_product_to_their(String numberProduct,String productName,  String pageName) {
        assertTrue(subCategoryPage.verifyProductNumber_met(numberProduct, productName, pageName));
    }
}
