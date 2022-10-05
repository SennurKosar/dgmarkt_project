package com.dgMarkt.pages;

import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dgMarkt.utilities.BrowserUtils.scrollToElement;
import static com.dgMarkt.utilities.BrowserUtils.waitFor;
import static org.junit.Assert.*;

public class CheckoutPage extends BasePage{
    @FindBy(xpath = "//input[@id='button-payment-address']")
    public WebElement billingContinueBtn;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    public WebElement deliveryContinueBtn;

    @FindBy(xpath = "//div[@id='collapse-shipping-method']//label[1]")
    public WebElement flatRate;

    @FindBy(xpath = "(//input[@id='button-shipping-method'])[1]")
    public WebElement flatRateContinueBtn;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement agreeBtn;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    public WebElement paymentContinueBtn;

    /**
     * verify that confirm order has selected currency
     * @param product
     * @param currency
     */
    public void verifyingConfirOrderCurrency(String product, String currency){
        WebElement price = Driver.get().findElement(By.xpath("//td[@class='text-left']//a[contains(text(),'"+product+"')]//..//..//td[4]"));
        //System.out.println(price.getAttribute("innerHTML")); tag in icindeki text varsa texti
        //System.out.println(price.getAttribute("outerHTML")); tag in icindeki herseyi yazdirir
        assertTrue(price.getAttribute("innerHTML").contains(currency));
    }
    public void billingAndDeliveryDetails(){
        scrollToElement(billingContinueBtn);
        waitFor(1);
        billingContinueBtn.click();

        scrollToElement(deliveryContinueBtn);
        waitFor(1);
        deliveryContinueBtn.click();
    }

    public void verifyingFlatRate(String currency){
        waitFor(1);
        assertTrue(flatRate.getText().contains(currency));
        flatRateContinueBtn.click();
    }
    public void copmletePayment(){
        agreeBtn.click();
        paymentContinueBtn.click();
    }

}

