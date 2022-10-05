package com.dgMarkt.pages;

import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dgMarkt.utilities.BrowserUtils.waitFor;
import static org.junit.Assert.*;


public class MyWishListPage extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='wish list']")
    public WebElement wishListTab;

    public void addProductToWishList() {
        waitFor(1);
        Driver.get().findElement(By.xpath("//button[@title='Add to Wish List']")).click();
        waitFor(1);

    }

    public void verifyWishListCurrency(String product, String currency, String price) {
        wishListTab.click();
        WebElement priceText = Driver.get().findElement(By.xpath("//div[normalize-space()='" + price + "']"));
        String productPrice = priceText.getText();
        switch (currency) {
            case "$":
                assertTrue(productPrice.contains("$"));
                break;
            case "€":
                assertTrue(productPrice.contains("€"));
                break;
            case "£":
                assertTrue(productPrice.contains("£"));
                break;
        }
        waitFor(1);
    }

    public void addProductToCartFromWishList(String product) {
        WebElement addToCart = Driver.get().findElement(By.xpath("(//table//tbody//tr//td/a[text()='" + product + "']/../..)//td[6]"));
        addToCart.click();


    }

}
