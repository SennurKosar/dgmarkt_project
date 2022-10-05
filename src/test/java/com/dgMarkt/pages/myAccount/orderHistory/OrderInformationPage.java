package com.dgMarkt.pages.myAccount.orderHistory;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInformationPage extends BasePage {

    @FindBy(xpath = "(//table[contains(@class,'table-hover')]/tbody/tr[1])[1]/td[1]")
    public WebElement orderInfoOrderID;

    @FindBy(xpath = "(//table[contains(@class,'table-hover')]/tbody/tr[1])[3]/td[1]")
    public WebElement orderInfoProductName;

    @FindBy(xpath = "//a[@data-original-title='Reorder']")
    public WebElement reOrderButton;

    @FindBy(xpath = "//a[@data-original-title='Return']")
    public WebElement returnButton;

    @FindBy(css = "div.alert.alert-success.alert-dismissible")
    public WebElement successReorderMessage;

    @FindBy(xpath = "(//table[contains(@class,'table-hover')]/tbody/tr[1])[3]/td[1]")
    public WebElement orderInfoStatus;

    /**
     * Bu Metot features dan gelen string seklindeki ya da senario outline
     * seklindeki product name icin kullanilabilir
     * @param name
     * @return
     */
    public String productNameM(String name){
        String text=Driver.get().findElement(By.xpath("//td[text()='"+name+"']")).getText();
        return text;
    }

}
