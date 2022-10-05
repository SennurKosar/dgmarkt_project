package com.dgMarkt.pages.myAccount;

import com.dgMarkt.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dgMarkt.utilities.BrowserUtils.waitFor;

public class LoginPage extends BasePage {
    @FindBy(css = "#input-email")
    public WebElement loginEmail;

    @FindBy(css = "#input-password")
    public WebElement loginPassword;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginButton;

    /**
     * (from feature)
     *
     * @param userEmail
     * @param password
     */

    public void login_method(String userEmail, String password) {
        loginEmail.sendKeys(userEmail);
        waitFor(1);
        loginPassword.sendKeys(password);
        waitFor(1);
        loginButton.click();
        waitFor(1);
    }

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement warningMessageLogin;
}

