package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.category.SubCategoryPage;
import com.dgMarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.dgMarkt.utilities.BrowserUtils.verifyElementDisplayed;

public class CompareIconStepDefs {
    SubCategoryPage subCategoryPage = new SubCategoryPage();

    @Then("verify that the user should be able to see Compare icon")
    public void verify_that_the_user_should_be_able_to_see_Compare_icon() {
        verifyElementDisplayed(subCategoryPage.compareBtn);
    }


    @And("the user clicks Compare this icon")
    public void theUserClicksCompareThisIcon() {
        subCategoryPage.compareBtn.click();
    }

    @And("the user sees Success alert")
    public void theUserSeesSuccessAlert() {
        verifyElementDisplayed(subCategoryPage.successAlertCompare);
    }

    @And("the user clicks {string} on the success alert")
    public void theUserClicksOnTheSuccessAlert(String comparison) {
        WebElement comparisonElement= Driver.get().findElement(By.xpath("//a[.='"+comparison+"']"));
        comparisonElement.click();
    }

    @Then("verify that user should be see {string} in the comparison list")
    public void verifyThatUserShouldBeSeeInTheComparisonList(String product) {
        WebElement productElement= Driver.get().findElement(By.xpath("//a[.='"+product+"']"));
        verifyElementDisplayed(productElement);
    }


}
