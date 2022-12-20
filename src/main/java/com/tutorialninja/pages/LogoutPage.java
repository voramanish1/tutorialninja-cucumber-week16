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

public class LogoutPage extends Utility {
    private static final Logger log = LogManager.getLogger(LogoutPage.class.getName());
    public LogoutPage(){
        PageFactory.initElements(driver, this);
    }
    //3.16 Verify the text “Account Logout”
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Account Logout']")
    WebElement getLogoutText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement clickContinueButton;
    public String getAccountLogoutText(){
        //Verify text "Account Logout"
        log.info("Verify text \"Account Logout\" " + getLogoutText.toString());
        return getTextFromElement(getLogoutText);
    }
    //3.17 Click on Continue button
    public void clickOnContinueButton(){
        clickOnElement(clickContinueButton);
        log.info("Clicking on Continue Button " + clickContinueButton.toString());

    }
}
