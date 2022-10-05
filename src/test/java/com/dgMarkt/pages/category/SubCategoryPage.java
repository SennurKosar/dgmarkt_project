package com.dgMarkt.pages.category;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

import static com.dgMarkt.utilities.BrowserUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubCategoryPage extends BasePage {

    @FindBy(xpath = "//*[@class='button-wishlist']")
    public WebElement addToWishListIcon;

    @FindBy(xpath = "//*[@class='button-quickview']")
    public WebElement quickViewBtn;

    @FindBy(xpath = "//input[@id='input-quantity']")
    public WebElement inputProductNumber;

    /**
     * the user hovers from "Health & Beauty" over the product "BaByliss 3663U - Hair rollers"
     *
     * @param subCategory
     * @param productName
     */
    public void hoverProduct_met(String subCategory, String productName) {
        categoryMenuM(subCategory);
        waitFor(2);
        WebElement productLoc = Driver.get().findElement(By.xpath("//div[@class='product-item']//img[@title='" + productName + "']"));
        scrollToElement(productLoc);
        hover(productLoc);
        waitForVisibility(quickViewBtn, 3);
    }

    public String textOfProductcode_met(String productName) {
        WebElement productCode_loc = Driver.get().findElement(By.xpath("//span[normalize-space()='" + productName + "']"));
        return productCode_loc.getText();
    }

    public void clickProduct(String productName, String category) {
        categoryMenuM(category);
        waitFor(2);
        WebElement productLoc = Driver.get().findElement(By.xpath("//div[@class='product-item']//img[@title='" + productName + "']"));
        scrollToElement(productLoc);
        productLoc.click();

        /**
         * the user clicks the icons from the quick view popup.
         * @param buttonName buttonName options: Add to Cart
         *                   buttonName options: Add to Wish List
         *                   buttonName options: Compare this Product
         */
    }

    public void clickButtonOnTheViewIcon(String buttonName) {
        WebElement buttonLoc = Driver.get().findElement(By.xpath("//button[text()='" + buttonName + "']"));
        buttonLoc.click();
        waitFor(2);
    }

    /**
     * ürünün shopping cart veya wish liste veya product comparisona eklenip eklenmedigini kontrol eder
     * Feature Type:Then verify that the user can add the product "<productName>" to their "<pageName>"
     *
     * @param productName
     * @param pageName
     * @return
     */
    public boolean verifyProductOnThePageList(String productName, String pageName) {
        WebElement pageLoc = Driver.get().findElement(By.xpath("//a[text()='" + pageName + "']"));
        pageLoc.click();
        String actualText = Driver.get().findElement(By.xpath("//td[text()='" + productName + "']")).getText();
        return actualText.equalsIgnoreCase(productName);
    }

    public void productNumberInput_met(String numberProduct) {
        inputProductNumber.clear();
        inputProductNumber.sendKeys(numberProduct);
        clickButtonOnTheViewIcon("Add to Cart");
    }

    //********************Slider****************///
    @FindBy(xpath = "(//div[@id='slider-price']//span)[1]")
    public WebElement priceRight_loc;

    @FindBy(xpath = "(//div[@id='slider-price']//span)[2]")
    public WebElement priceLeft_loc;
    @FindBy(xpath = "//select[@id='input-sort']")
    public WebElement sort_by_loc;
    @FindBy(xpath = "//select[@id='input-sort']//option")
    public List<WebElement> sort_list_loc;
    @FindBy(xpath = "//select[@id='input-limit']")
    public WebElement show_Loc;
    @FindBy(xpath = "//select[@id='input-limit']//option")
    public List<WebElement> show_List_loc;
    @FindBy(xpath = "//div[@class='box-price']//p")
    public List<WebElement> box_price_list_loc;

    public void priceslider_mth(String currency, int down, int top) throws InterruptedException {
        int start = 0;
        int finish = 0;
        waitForClickablility(priceRight_loc, 5);

        if (currency.equalsIgnoreCase("$ US Dollar")) {
            start = 102;
            finish = 485;
        } else if (currency.equalsIgnoreCase("£ Pound Sterling")) {
            start = 63;
            finish = 297;
        } else if (currency.equalsIgnoreCase("€ Euro ")) {
            start = 81;
            finish = 381;
        }

        for (int i = start; i < down; i++) {
            Thread.sleep(500);
            priceRight_loc.sendKeys(Keys.ARROW_RIGHT);
        }

        for (int i = finish; i > top; i--) {
            Thread.sleep(500);
            priceLeft_loc.sendKeys(Keys.ARROW_LEFT);
        }
    }

    public void verify_Slider(String currency, int down, int top) {
        waitFor(1);
        sort_by_loc.click();
        waitFor(1);
        for (WebElement sort : sort_list_loc) {
            if (sort.getText().equalsIgnoreCase("Price (Low > High)")) {
                sort.click();
            }
        }
        waitFor(1);
        show_Loc.click();
        waitFor(1);
        for (WebElement show : show_List_loc) {
            if (show.getText().equalsIgnoreCase("100")) {
                show.click();
            }
        }
        String down_String = box_price_list_loc.get(0).getText().trim().replace(currency, "");
        double down_double = Double.parseDouble(down_String);
        waitFor(2);
        scrollToElement(box_price_list_loc.get(box_price_list_loc.size() - 1));
        waitFor(1);
        String top_String = box_price_list_loc.get(box_price_list_loc.size() - 1).getText().trim().replace(currency, "");
        double top_double = Double.parseDouble(top_String);

        assertTrue(down_double > down && top_double < top);
    }
    //********************Slider****************///

    //***************Compare Icon***************//

    @FindBy (xpath = "//*[@class='button-compare']")
    public WebElement compareBtn;
    @FindBy( css = ".alert.alert-fix.alert-success.alert-dismissible")
    public  WebElement successAlertCompare;
    //***************Compare Icon***************//


//**********  SortBy   ******************

    @FindBy(className = "form-control")
    public WebElement defaultButton;

    @FindBy(xpath = "//div[@class='product-item']")
    public List<WebElement> productList;

    @FindBy(xpath = "//p[@class='price']")
    public List<WebElement> priceList;

    public boolean sorting_Metod(String sortTab) {

        Select select = new Select(defaultButton);
        select.selectByVisibleText(sortTab);
        waitFor(1);
        boolean verify = false;

        List<String> productNames = getElementsText(productList);   // product isimlerini sakladigimiz orjinal list
        List<String> sortedProductNames = getElementsText(productList);  // p. nameleri siralayip sakladigimiz list

        Collections.sort(sortedProductNames);

        ///////////////////////

        List<String> productPrices = getElementsText(priceList);  // fiyatlarin textini kismini sakladigimiz list
        List<String> sortedProductPrices = getElementsText(priceList);  // fiyatlarin siralanmis halinin listesi

        Collections.sort(sortedProductPrices);

        if (sortTab.equals("Name (A - Z)") || sortTab.equals("Model (A - Z)")) {
            verify = sortedProductNames.equals(productNames);
        } else if (sortTab.equals("Name (Z - A)") || sortTab.equals("Model (Z - A)")) {
            Collections.reverse(sortedProductNames);
            verify = productNames.equals(sortedProductNames);
        } else if (sortTab.equals("Price (Low > High)")) {
            verify = sortedProductPrices.equals(productPrices);
        } else if (sortTab.equals("Price (High > Low)")) {
            Collections.reverse(sortedProductPrices);
            verify = sortedProductPrices.equals(productPrices);
        } else {
            verify = true;
        }
        return verify;
    }


    //**************** number of products on the sub category Page *************************
    public void verifyingProductCurrency(String selectedCurrency) {
        assertTrue(Driver.get().findElement(By.cssSelector(".price")).getText().contains(selectedCurrency));
        waitFor(1);
    }

    public void verifyDefaultNumberShowTab(int defaultNumber) {
        WebElement selectShow = Driver.get().findElement(By.xpath("//select[@id='input-limit']"));
        Select select = new Select(selectShow);
        hover(selectShow);
        String actual = select.getFirstSelectedOption().getText();
        String expected = String.valueOf(defaultNumber);
        assertEquals(expected, actual);

    }

    public void verifyingReplaceShowTab(String selectShowTab) {
        WebElement selectShow = Driver.get().findElement(By.xpath("//select[@id='input-limit']"));
        Select select = new Select(selectShow);
        hover(selectShow);

        List<WebElement> showElements = select.getOptions();
        //scrollToElement();
        switch (selectShowTab) {
            case "25":

                select.selectByVisibleText(showElements.get(1).getText());
                waitFor(2);
                assertEquals(Integer.parseInt(selectShowTab), productList.size());

                break;
            case "50":

                select.selectByVisibleText(showElements.get(2).getText());
                waitFor(2);
                assertEquals(Integer.parseInt(selectShowTab), productList.size());

                break;
            case "75":

                select.selectByVisibleText(showElements.get(3).getText());
                waitFor(2);
                assertEquals(Integer.parseInt(selectShowTab), productList.size());
                break;
            case "100":

                select.selectByVisibleText(showElements.get(4).getText());
                waitFor(2);
                assertTrue(Integer.parseInt(selectShowTab) >= productList.size());//urun sayisi 100 den az oldugu icin assert farkli
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + selectShowTab);
        }
    }


//**************** number of products on the sub category Page*************************

//*************************popular tags on the sub category page****************************

    public WebElement getSubCategoryHeader(String header) {

        WebElement subCategoryHeader = Driver.get().findElement(By.xpath("//h1[text()='" + header + "']"));
        waitFor(1);

        return subCategoryHeader;
    }

    public void clickPopularTag(String tag) {
        WebElement popularTag = Driver.get().findElement(By.xpath("//a[text()='" + tag + "']"));
        scrollToElement(popularTag);
        waitForVisibility(popularTag, 3);
        clickWithJS(popularTag);

    }





    /**
     * bir üründen birden fazla adet shopping cart a eklenip eklenmedigini verify eder
     * @param numberProduct
     * @param productName
     * @param pageName
     * @return
     */
    public boolean verifyProductNumber_met(String numberProduct,String productName, String pageName){
        boolean verify = false;
        WebElement pageLoc = Driver.get().findElement(By.xpath("//a[text()='" + pageName + "']"));
        pageLoc.click();

        String number = Driver.get().findElement(By.xpath("//td[text()='" + productName + "']/../td[4]/div/input")).getAttribute("value");
        int actualNumber = Integer.parseInt(number);
        int expectedNumber = Integer.parseInt(numberProduct);

        if (actualNumber>=expectedNumber){
            verify=true;
        }
        System.out.println("verify = " + verify);
        return verify;
    }
}

