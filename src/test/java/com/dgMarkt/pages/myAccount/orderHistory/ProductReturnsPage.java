package com.dgMarkt.pages.myAccount.orderHistory;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductReturnsPage extends BasePage {

    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement returnSubmit;
    @FindBy(xpath = "//input[@id='input-order-id']")
    public WebElement orderID_ReturnsForm;


    @FindBy(xpath = "//input[@id='input-product']")
    public WebElement productName_ReturnsForm;

  @FindBy(xpath = "(//a[text()='Returns'])[1]")
    public WebElement returnsTab;

  @FindBy(xpath = "(//table[contains(@class,'table-hover')]/tbody/tr[1])[1]/td[4]")
    public  WebElement returnOrderID;

  @FindBy(xpath = "//tbody/tr/td[4]")
  public List<WebElement> returnedOrderIDs_List;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/a")
    public  WebElement returnView;

    public void productReturnsOrderForm(){
        int reasonNum=new Random().nextInt(5)+1;
        Driver.get().findElement(By.xpath("//input[@value='"+reasonNum+"']")).click();
        int openedNum=new Random().nextInt(2);
        Driver.get().findElement(By.xpath("//input[@value='"+openedNum+"'][@name='opened']")).click();
        returnSubmit.click();
    }

}
