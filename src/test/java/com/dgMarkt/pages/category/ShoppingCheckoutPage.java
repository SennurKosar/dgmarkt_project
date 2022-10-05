package com.dgMarkt.pages.category;

import com.dgMarkt.pages.BasePage;
import static com.dgMarkt.utilities.BrowserUtils.*;
import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoppingCheckoutPage extends BasePage {

    @FindBy(name = "agree")
    public WebElement agreeCheckbox;

    @FindBy(name = "comment")
    public List<WebElement> commentArea;

    @FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
    public WebElement orderSuccessText;

    @FindBy(xpath = "//div[@class='text-danger']")
    public List<WebElement> errorMessagesList;

    @FindBy(xpath = "//input[@type='text']")
    public List<WebElement> inputList;

    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    public WebElement agreeError;


    public String deliveryTexts(String containsText) {
        waitFor(2);
        return Driver.get().findElement(By.xpath("//p[contains(text(),'" + containsText + "')]")).getText();
    }

    public WebElement details(String detail) {
        waitFor(2);
        return Driver.get().findElement(By.id(detail));
    }

    public WebElement continueButtons(String id) {
        WebElement element = Driver.get().findElement(By.id(id));
        waitFor(2);
        return element;
    }

    public void enterTheInputs(String id, String firstName, String lastName, String company, String address_1, String address_2, String city, String pastCode, String country, String regionState) throws NoSuchElementException {
        try {
            if (!Driver.get().findElement(By.id(id)).isDisplayed()) {
                for (int i = 1; i < 8; i++) {

                    switch (i) {
                        case 1 -> inputList.get(i).sendKeys(firstName);
                        case 2 -> inputList.get(i).sendKeys(lastName);
                        case 3 -> inputList.get(i).sendKeys(company);
                        case 4 -> inputList.get(i).sendKeys(address_1);
                        case 5 -> inputList.get(i).sendKeys(address_2);
                        case 6 -> inputList.get(i).sendKeys(city);
                        default -> inputList.get(i).sendKeys(pastCode);
                    }
                    new Select(details("input-payment-country")).selectByVisibleText(country);
                    details("input-payment-zone").sendKeys(regionState);
                }
            }else {
                continueButtons("button-payment-address").click();
            }

        }catch (NoSuchElementException noSuchElementException){
            for (int i = 1; i < 8; i++) {

                switch (i) {
                    case 1 -> inputList.get(i).sendKeys(firstName);
                    case 2 -> inputList.get(i).sendKeys(lastName);
                    case 3 -> inputList.get(i).sendKeys(company);
                    case 4 -> inputList.get(i).sendKeys(address_1);
                    case 5 -> inputList.get(i).sendKeys(address_2);
                    case 6 -> inputList.get(i).sendKeys(city);
                    default -> inputList.get(i).sendKeys(pastCode);
                }
                new Select(details("input-payment-country")).selectByVisibleText(country);
                details("input-payment-zone").sendKeys(regionState);
            }
            continueButtons("button-payment-address").click();
        }
    }

    public WebElement radioButtons(String value) {
        return Driver.get().findElement(By.xpath("//*[@value='" + value + "']"));
    }

}
