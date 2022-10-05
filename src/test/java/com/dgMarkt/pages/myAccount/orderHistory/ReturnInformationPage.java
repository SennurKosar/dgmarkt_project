package com.dgMarkt.pages.myAccount.orderHistory;

import com.dgMarkt.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReturnInformationPage extends BasePage {

    @FindBy(xpath = "(//table[contains(@class,'table-hover')]/tbody/tr[1])[2]/td[1]")
    public WebElement returnInfoProductName;
}
