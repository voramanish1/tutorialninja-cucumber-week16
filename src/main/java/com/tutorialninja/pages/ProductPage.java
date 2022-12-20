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

import java.util.List;

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());
    public ProductPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement productTextHPLP3065;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calenderButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker-days']//table//th[@class='picker-switch']")
    WebElement monthYearText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']/div[1]//table//th[normalize-space()='›']")
    WebElement nextButtonOfCalender;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']//table//td")
    List<WebElement> dayText;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement quantityField;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement getSuccessText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartButton;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;
    //******************************Desktop**********************//

    //2.5 Verify the Text "HP LP3065"
    public String getProductHPLP3065(){
        log.info("Verify the Text \"HP LP3065\" " +productTextHPLP3065.toString());
        return getTextFromElement(productTextHPLP3065);
    }
    //2.6 Select Delivery Date "2022-11-30"
    public void selectDate(String year,String month, String date) {
        clickOnElement(calenderButton);
        log.info("Select "+year+month+date+"to date field "+calenderButton.toString());
        while (true) {
            String monthAndYear = monthYearText.getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButtonOfCalender);
            }
        }
        List<WebElement> allDates = dayText;
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    //2.7.Enter Qty "1” using Select class.
    public void addQuantityForProduct(String text){
        sendTextToElement(quantityField,text);
        log.info("Enter Qty"+text+ "to quantity field "+quantityField.toString());
    }
    //2.8 Click on “Add to Cart” button
    public void clickOnAddToCartButton(){
        mouseHoverToElementAndClick(addToCartButton);
        log.info("Clicking on Login Button " + addToCartButton.toString());
    }

    //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    public String getSuccessText(){
        log.info("Verify the Message “Success: You have added HP LP3065 to your shopping cart!” " + getSuccessText.toString());
        return getTextFromElement(getSuccessText);
    }

    //2.10 Click on link “shopping cart” display into success message
    public void clickOnShoppingCartButton(){
        mouseHoverToElementAndClick(shoppingCartButton);
        log.info("Click on link “shopping cart” display into success message " + shoppingCartButton.toString());
    }

    //****************************************Laptop***********************//
   //Verify text MacBook
    public String getProductMacBookText(){
        log.info("Verify text MacBook " + macBookText.toString());
        return getTextFromElement(macBookText);
    }
}
