package com.dgMarkt.pages.homePage;

import com.dgMarkt.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "#cart")
    public WebElement cartBtn;
}
