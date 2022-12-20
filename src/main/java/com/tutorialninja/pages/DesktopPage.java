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

public class DesktopPage extends Utility {
    private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());
    public DesktopPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement clickOnSortBy;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList1;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement productTextHPLP3065;

    //1.3 Verify the text ‘Desktops’
    public String getDesktopText() {
        log.info("Verify the text ‘Desktops’" +desktopText.toString());
        return getTextFromElement(desktopText);
    }

   // Click on sort by position
    public void clickOnSortByPosition() {
        clickOnElement(clickOnSortBy);
        log.info("Click on sort by position " + clickOnSortBy.toString());
    }
    //1.4 Verify product sorted Z-A
    public ArrayList expectedList() {

        // Get all the products name and stored into array list
        List<WebElement> products = productsList1;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        // Sort By Reverse order
       // Collections.reverse(originalProductsName);
        return originalProductsName;
    }

    public ArrayList getSortedProductList() {
        // Get all the products name and stored into array list
        Collections.reverse(expectedList());
        List<WebElement> products = productsList;


        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        return afterSortByZToAProductsName;
    }

    //1.3 Select option product sorted by name Z -A
    public void selectProductSorted(String text) {
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
        log.info("Select option product sorted by " +text+ "from sort by options "+clickOnSortBy.toString());
    }

    //2.4 click the Product HPLP3065
    public void clickOnProductHPLP3065(String productName) {
        clickOnElement(productTextHPLP3065);
        log.info("Clicking on "+productName+ productTextHPLP3065.toString());
    }
}

