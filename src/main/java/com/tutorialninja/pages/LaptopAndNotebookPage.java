package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNotebookPage extends Utility {
    private static final Logger log = LogManager.getLogger(LaptopAndNotebookPage.class.getName());
    public LaptopAndNotebookPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNotebookText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement clickOnSortBy;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productPriceList;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productPriceList1;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement productMacBook;

    //2.3 Verify the text ‘Laptops & Notebooks’
    public String getLaptopAndNotebookText() {
        log.info("Verify the text ‘Laptops & Notebooks’ " + laptopAndNotebookText.toString());
        return getTextFromElement(laptopAndNotebookText);
    }


    public void clickOnSortByPosition() {
        clickOnElement(clickOnSortBy);
        log.info("Clicking on Login Button " + clickOnSortBy.toString());
    }

    //1.3 Select Price(High>Low) option from drop down
    public void selectProductSortedPriceHighToLow(String text) {
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
        log.info("Select " + text + " option from drop down" + clickOnSortBy.toString());

    }

    // verify Product sorted  price High to low
    public List<Double> priceHighToLow() {

        // Get all the products price and stored into array list
        List<WebElement> products = productPriceList1;
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        log.info("Verify Product sorted  price High to low " + productPriceList1.toString());
        return originalProductsPrice;
    }

    public List<Double> getPriceHighToLow() {
        // Get all the products price and stored into array list
        Collections.sort(priceHighToLow(), Collections.reverseOrder());
        List<WebElement> products = productPriceList;
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return afterSortByPrice;
    }


    //2.4 Select product MacBook
    public void clickOnProductMacBook(String productName) {
        clickOnElement(productMacBook);
        log.info("Select "+productName+  productMacBook.toString());
    }
}
