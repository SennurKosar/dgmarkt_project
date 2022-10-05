package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.category.SubCategoryPage;
import io.cucumber.java.en.Then;
import static com.dgMarkt.utilities.BrowserUtils.*;

public class QuickWishListIcon_StepDefs {
    SubCategoryPage subCategoryPage=new SubCategoryPage();

    @Then("Verify that the Add to Wish List icon is visible")
    public void verify_that_the_Add_to_Wish_List_icon_is_visible() {
       verifyElementDisplayed(subCategoryPage.addToWishListIcon);
    }
    @Then("the user clicks Add to Wish List icon")
    public void the_user_clicks_Add_to_Wish_List_icon() {
        subCategoryPage.addToWishListIcon.click();
    }
}
