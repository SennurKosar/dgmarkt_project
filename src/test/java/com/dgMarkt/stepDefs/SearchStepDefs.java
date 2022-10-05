package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.SearchBtn;
import com.dgMarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.dgMarkt.utilities.BrowserUtils.clickWithJS;
import static com.dgMarkt.utilities.BrowserUtils.waitFor;

public class SearchStepDefs{

    SearchBtn searchBtn = new SearchBtn();

    @When("The user is on the {string} page and click on search button without user login and enters product {string}")
    public void the_user_is_on_the_page_and_click_on_search_button_without_user_login_and_enters_product(String page, String productName) {

        searchBtn.navigateToPages(page);
        waitFor(2);
        searchBtn.search_Btn_loc.click();
        searchBtn.inputTextSearchBtn_loc.sendKeys(productName);

        waitFor(3);

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(Driver.get().findElement(By.xpath("//*[text()='"+productName+"']"))).perform();
        clickWithJS(Driver.get().findElement(By.xpath("//*[text()='"+productName+"']")));
        waitFor(3);

    }

    @Then("Product {string} is displayed")
    public void product_is_displayed(String productName) {

        Driver.get().findElement(By.xpath("(//*[text()='"+productName+"'])[3]")).isDisplayed();
    }

    @When("The user is on the {string} category and click on search button without user login and enters product {string}")
    public void the_user_is_on_the_category_and_click_on_search_button_without_user_login_and_enters_product(String category, String productName) {

        searchBtn.categoryMenuM(category);
        waitFor(3);
        searchBtn.search_Btn_loc.click();
        searchBtn.inputTextSearchBtn_loc.sendKeys(productName);

        waitFor(3);

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(Driver.get().findElement(By.xpath("//*[text()='"+productName+"']"))).perform();

        clickWithJS(Driver.get().findElement(By.xpath("//*[text()='"+productName+"']")));

        waitFor(2);

    }


    @When("The user is on the {string} page and click on search button without user login and enters invalid product {string}")
    public void theUserIsOnThePageAndClickOnSearchButtonWithoutUserLoginAndEntersInvalidProduct(String category, String productName) {

        searchBtn.categoryMenuM(category);
        waitFor(3);
        searchBtn.search_Btn_loc.click();
        searchBtn.inputTextSearchBtn_loc.sendKeys(productName);
        waitFor(3);

    }

    @Then("{string} is displayed")
    public void isDisplayed(String message) {

        Driver.get().findElement(By.xpath("//p[text()='There are no products to list in this category.']")).isDisplayed();

    }
}
