package com.dgMarkt.pages;

import com.dgMarkt.utilities.BrowserUtils;
import com.dgMarkt.utilities.ConfigurationReader;
import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//span[text()='Currency']")
    public WebElement currency;

    @FindBy(xpath = "//span[text()='Category']")
    public WebElement category;

    @FindBy(css = "#input-email")
    public WebElement loginEmail;

    @FindBy(css = "#input-password")
    public WebElement loginPassword;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginButton;

    @FindBy(css = "div.alert.alert-success")
    public WebElement loginSuccessText;

    @FindBy(xpath = "//div[@class='dropdown-toggle search-button']")
    public WebElement search_Btn_loc;

    @FindBy(xpath = "//a[@id='wishlist-total']")
    public WebElement wish_btn_loc;

    @FindBy(xpath = "//div[@class='btn-group btn-block']")
    public WebElement shopping_cart_loc;

    @FindBy(css = ".fa.fa-shopping-cart")
    public WebElement view_cart_loc;

    @FindBy(css = ".fa.fa-share")
    public WebElement checkout_cart_loc;

    /**
     * (from configuration properties)
     */


    public void loginM() {
        navigateTo("My Account", "Login");
        loginEmail.sendKeys(ConfigurationReader.get("userEmail"));
        BrowserUtils.waitFor(1);
        loginPassword.sendKeys(ConfigurationReader.get("userPassword"));
        BrowserUtils.waitFor(1);
        loginButton.click();
    }

    /**
     * Configuration proferties teki degismeli durumlarda kullanilan login metodu
     * @param email
     * @param password
     */
    public void loginM(String email,String password){
        navigateTo("My Account", "Login");
        loginEmail.sendKeys(ConfigurationReader.get(email));
        BrowserUtils.waitFor(1);
        loginPassword.sendKeys(ConfigurationReader.get(password));
        BrowserUtils.waitFor(1);
        loginButton.click();

    }

    /**
     * Feature Type:And the user navigates to "My Account" menu "Order History" tab
     * navigateTo("My Account","Order History")
     *
     * @param module
     * @param tab
     */
    public void navigateTo(String module, String tab) {
    BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//span[text()='" + module + "']")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[text()='" + tab + "']")).click();
        BrowserUtils.waitFor(1);
    }

    public void navigateTo(String module) {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//span[text()='" + module + "']")).click();
        BrowserUtils.waitFor(1);
    }

    public void navigateToPages(String pageName){

        Driver.get().findElement(By.xpath("(//span[text()='"+pageName+"'])[2]")).click();

    }

    /**
     * Feature Type:Then verify that the user is on the "Order Information" page
     *
     * @param pageName
     */
    public String textOnThePagesM(String pageName) {
        String text = Driver.get().findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='"+pageName+"']")).getText();
        return text;
    }

    /**
     * Feature Type: And the user can select from Category menu "Health & Beauty" tab
     *
     * @param tab first letter must be capitalized
     */
    public void categoryMenuM(String tab) {

        BrowserUtils.waitFor(3);
        BrowserUtils.hover(category);
        BrowserUtils.waitFor(3);
        BrowserUtils.hover(Driver.get().findElement(By.xpath("//a[text()='Health & Beauty']")));
        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//a[text()='" + tab + "']")));
    }

    @FindBy(xpath = "(//a[text()='My Account'])[1]")
    public WebElement myAccountSecond;

    @FindBy(xpath = "//a[text()='Password']")
    public WebElement passwordForChange;

    @FindBy(css = "#input-password")
    public WebElement inputPassword;

    @FindBy(css = "#input-confirm")
    public WebElement inputConfirm;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[text()=' Success: Your password has been successfully updated.']")
    public WebElement changePswrdVrfyMsg;

    @FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
    public WebElement changePswrdErrorVrfyMsg;





}
