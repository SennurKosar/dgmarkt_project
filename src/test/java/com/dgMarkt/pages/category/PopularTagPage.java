package com.dgMarkt.pages.category;

import com.dgMarkt.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.dgMarkt.utilities.BrowserUtils.*;

public class PopularTagPage extends BasePage {

    @FindBy(xpath = "//select[@name='category_id']")
    public WebElement defaultSubCatOption;

    @FindBy(id = "button-search")
    public WebElement searchButton;

    @FindBy(xpath = "//p[contains(text(),'There is no product')]")
    public WebElement noProductMessage;

    @FindBy(xpath = "//select[@name='category_id']")
    public WebElement selectSubCatOption;

    @FindBy(css = "#description")
    public WebElement descriptionOption;

    @FindBy(xpath = "//div[contains(text(),'Showing')]")
    public WebElement showingMessage;


    public void verifyDefaultOption(String selectedOption){
        Select subCat = new Select(defaultSubCatOption);
        String defaultText = subCat.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, defaultText);
        waitFor(2);
    }

    public void clickSearchButton() {
        clickWithJS(searchButton);
        waitFor(2);

    }

    public void verifyNoProductMessage(String expectedMessage) {
        scrollToElement(noProductMessage);
        String actualMessage = noProductMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        waitFor(2);
    }

    public void selectOption(String subCatOption) {

        Select subCat = new Select(selectSubCatOption);
        subCat.selectByVisibleText(subCatOption);
        waitFor(2);

    }

    public void clickDescription() {

        descriptionOption.click();
        waitFor(2);

    }

    public void verifyProductMessage(String expectedMessage) {

        scrollToElement(showingMessage);
        String actualMessage = showingMessage.getText();
        Assert.assertTrue(showingMessage.getText().contains(expectedMessage));
        waitFor(2);
    }
}
