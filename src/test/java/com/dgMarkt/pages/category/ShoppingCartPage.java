package com.dgMarkt.pages.category;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.pages.homePage.HomePage;
import com.dgMarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dgMarkt.utilities.BrowserUtils.*;



public class ShoppingCartPage extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='container-inner']/h1")
    public WebElement healthAndBeautyPage;

    @FindBy(xpath = "//div[@class='alert alert-fix alert-success alert-dismissible']")
    public WebElement productPopupText;

    @FindBy(linkText = "BaByliss 3663U - Hair rollers")
    public WebElement shoppingCartProductText;

    /*
     * cartPopupButtons Method ile cart e tiklayip acilan popup da Checkout and View Cart her hangi birine
     parametre olarak girilince tiklamayi sagliyor
     */
    public void cartPopupButtons(String buttonName) {
        WebElement button = Driver.get().findElement(By.xpath("//strong[normalize-space()='" + buttonName + "']"));
        button.click();
        waitFor(2);
    }


    public WebElement continueAndCheckoutButton(String text) {
        return Driver.get().findElement(By.linkText(text));
    }

    /*
     * addToCartClick method ile Health & Beauty page indeki istenilen ürünleri add to card yapabiliriz.
     */
    public void addToCartClick(int number) {
        WebElement webElement = Driver.get().findElement(By.xpath("//*[@id='content']/div/div[2]/div[" + number + "]/div/div/div[2]/div/button"));
        hover(webElement);
        webElement.click();
    }


    /*
     * productPopup method : cart e tiklayip acilan popupdaki görülen product larin isimlerini locate etmeye yariyor.
     */
    public WebElement productPopup(String productName) {
        return Driver.get().findElement(By.linkText(productName));
    }

    //*************************currency***********************
    HomePage homePage=new HomePage();
    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkoutBtn;

    /**
     * verify selected currency in the cart with product name
     * @param product
     * @param currency
     */
    public void verifyingCurrencyInTheCart(String product,String category, String currency){
        waitFor(1);
        hover(homePage.cartBtn);
        homePage.cartBtn.click();

        Driver.get().findElement(By.xpath("//strong[normalize-space()='View Cart']")).click();

        waitFor(2);
        WebElement price;
        if (category.equals("Televisions")){
            String productTel=product.replace("\\","");
           price  = Driver.get().findElement(By.xpath("//td[@class='text-left']//a[contains(text(),'"+productTel+"')]/../../td[5]"));
        }else{
            scrollToElement(Driver.get().findElement(By.tagName("h2")));
            waitFor(1);
            price = Driver.get().findElement(By.xpath("//td[@class='text-left']//a[contains(text(),'"+product+"')]/../../td[5]"));
        }

        Assert.assertTrue(price.getText().contains(currency));
    }
    public void clickCheckoutBtn(){
        checkoutBtn.click();
    }

}
