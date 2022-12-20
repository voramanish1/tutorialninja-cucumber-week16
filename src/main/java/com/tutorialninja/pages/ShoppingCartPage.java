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

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());
    public ShoppingCartPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productText;
    @CacheLookup
    @FindBy(xpath = "//small[contains(text(),'Delivery Date: 2022-11-30')]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//td[contains(text(),'Product 21')]")
    WebElement productDesktopModel;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']/input")
    WebElement quantityField;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement updateButton;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement updateSuccessText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutButton;

    //2.11 Verify the text "Shopping Cart"
    public String getShoppingCartText(){
        log.info(" Verify the text \"Shopping Cart\" " + shoppingCartText.toString());
        return getTextFromElement(shoppingCartText);
    }
    //2.12 Verify the Product name "HP LP3065"
    public String getProductText(){
        log.info("Verify the Product name \"HP LP3065\" " + productText.toString());
        return getTextFromElement(productText);
    }
    //2.13 Verify the Delivery Date "2022-11-30"
    public String getDeliveryDateOfProduct(){
        log.info("Verify the Delivery Date \"2022-11-30\" " + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }
    //2.14 Verify the Model "Product21"
    public String getProductModel(){
        log.info("Verify the Model \"Product21\" " + productDesktopModel.toString());
        return getTextFromElement(productDesktopModel);
    }
    //2.15 Verify the Todat "£74.73"
    public String getTotalPrice(){
        log.info("Verify the Todat \"£74.73\"" +totalPrice.toString());
        return getTextFromElement(totalPrice);
    }

    //*************************************Laptop*******************************//
    //2.11 Change Quantity "2"
    public void changeQuantityForProduct(String text){
        sendTextToElement(quantityField,text);
        log.info("Change Quantity"+text+ "to quantity field "+quantityField.toString());
    }
    //2.12 Click on “Update” Tab
    public void clickOnUpdateQuantity(){
        clickOnElement(updateButton);
        log.info(" Click on “Update” Tab " + updateButton.toString());
    }
    //2.13 Verify the message “Success: You have modified your shopping cart!”
    public String getUpdateSuccessfullyText(){
        log.info("Getting welcome back text " + updateSuccessText.toString());
        return getTextFromElement(updateSuccessText);
    }
   // 2.15 Click on “Checkout” button
    public void clickOnCheckoutButton(){
        clickOnElement(checkoutButton);
        log.info("Click on “Checkout” button " + checkoutButton.toString());

    }
}
