package com.dgMarkt.pages.myAccount;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Logout extends BasePage {

    @FindBy(xpath = "//div[@class='logout-success'] ")
    public WebElement logoutSuccsessMessage;

    @FindBy(xpath = "(//button[@class='button']//span[text()='Continue'])[2]")
    public WebElement logoutContinueBtn;

    @FindBy(xpath = "//a[text()='Register']/../../li")
    public List<WebElement> myAccountMenu;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    public WebElement myAccountTab;


    public void verifyLogout(){
        String actualtext =logoutSuccsessMessage.getText();
        String expectedtext= "You have been logged off your account. It is now safe to leave the computer.";
        Assert.assertTrue(actualtext.contains(expectedtext));

        logoutContinueBtn.click();


    }

    public void verifyNoLogin(){
        BrowserUtils.waitFor(2);
        myAccountTab.click();
        Assert.assertFalse("There is no re-Login function", BrowserUtils.getElementsText(myAccountMenu).contains("re-Login"));

    }



}



