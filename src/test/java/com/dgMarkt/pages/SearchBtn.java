package com.dgMarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBtn extends BasePage{

    @FindBy(xpath = "//button[@id='btn-search-category']")
    public WebElement searchBtn_loc;

    @FindBy(xpath = "//input[@id='text-search']")
    public WebElement inputTextSearchBtn_loc;



}
