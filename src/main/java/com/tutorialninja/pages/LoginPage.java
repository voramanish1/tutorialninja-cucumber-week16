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

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement clickOnLogin;
    @CacheLookup
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountText;

    //2.3 Verify the text “Returning Customer”.
    public String getReturningCustomerTextFromLoginPage(){
        log.info("Verify the text “Returning Customer” " + returningCustomerText.toString());
        return getTextFromElement(returningCustomerText);
    }

    //4.3 Enter Email address
    public void enterEmail(String email){
        sendTextToElement(emailField,email);
        log.info("Enter email"+email+ "to email field "+emailField.toString());
    }

    //4.5 Enter Password
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
       log.info("Enter password"+password+ "to password field "+passwordField.toString());
    }

    //4.6 Click on Login button
    public  void clickOnLoginButton(){
        clickOnElement(clickOnLogin);
        log.info("Clicking on Login Button " + clickOnLogin.toString());
    }

    //4.7 Verify text “My Account”
    public String getMyAccountText(){
        log.info("Verify text “My Account”" + myAccountText.toString());
        return getTextFromElement(myAccountText);
    }
}
