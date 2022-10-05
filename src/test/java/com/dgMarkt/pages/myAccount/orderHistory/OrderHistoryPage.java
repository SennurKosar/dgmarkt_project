package com.dgMarkt.pages.myAccount.orderHistory;

import com.dgMarkt.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends BasePage {

    @FindBy(xpath = "//table[contains(@class,'table-hover')]/tbody/tr[1]/td[1]")// first row first data
    public WebElement firstRowOrderID;

    @FindBy(xpath = "//table[contains(@class,'table-hover')]/tbody/tr[1]/td[7]") //first row 7. data
    public WebElement firstRowViewIcon;

    @FindBy(css = ".fa.fa-eye")
    public WebElement view;
}
