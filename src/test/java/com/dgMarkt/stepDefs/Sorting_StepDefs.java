package com.dgMarkt.stepDefs;


import com.dgMarkt.pages.category.SubCategoryPage;
import com.dgMarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.dgMarkt.utilities.BrowserUtils.*;
import static org.junit.Assert.*;

public class Sorting_StepDefs {

    SubCategoryPage subCategoryPage = new SubCategoryPage();
    Driver driver;

    @And("the user hovers over the Category button and sees {string} button and clicks")
    public void the_user_hovers_over_the_Category_button_and_sees_button_and_clicks(String categoryName) {
        subCategoryPage.categoryMenuM(categoryName);

    }

    @When("the user clicks dropbox menu next to Sort by button")
    public void the_user_clicks_dropbox_menu_next_to_Sort_by_button() {
        waitFor(1);
        subCategoryPage.defaultButton.click();

    }

    @Then("the user should be able to see {string} in dropbox menu")
    public void the_user_should_be_able_to_see_in_dropbox_menu(String tab) {
        waitFor(1);
        String sortButtonText = subCategoryPage.defaultButton.getText();
        System.out.println("sortButtonText = " + sortButtonText);
        assertTrue(sortButtonText.contains(tab));

    }

    @And("the user should be able to sort the products by clicking {string}")
    public void the_user_should_be_able_to_sort_the_products_by_clicking(String clickingTab) {

        assertTrue(subCategoryPage.sorting_Metod(clickingTab));


    }




}
