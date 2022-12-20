package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenuTabs;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopTab;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNotebookTab;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;
    @CacheLookup
    @FindBy(linkText = "Show All Desktops")
    WebElement showAllDesktopTab;
    @CacheLookup
    @FindBy(linkText = "Show All Laptops & Notebooks")
    WebElement showAllLaptopAndNotebookTab;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList1;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
    List<WebElement> myAccountOptions;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;



    //This method will check whatever parameter is passed it click on it
    public void selectMenu(String menu){


        List<WebElement> topMenuList = topMenuTabs;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenuTabs;
        }
        log.info("Click "+menu+ "from hompage top menubar  "+topMenuTabs.toString());
    }

    // 1.1 Mouse hover on “Desktops” Tab and click
    public void navigateToDesktopPage(){
        mouseHoverToElementAndClick(desktopTab);
        log.info("Mouse hover on “Desktops” Tab and click " + desktopTab.toString());
    }

    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    public void navigateToLaptopAndNotebooksPage(){
        mouseHoverToElementAndClick(laptopAndNotebookTab);
        log.info("Mouse hover on “Laptops & Notebooks” Tab and click " + laptopAndNotebookTab.toString());
    }

    // 3.1 Mouse hover on “Components” Tab and click
    public void navigateToComponentsPage(){
        mouseHoverToElementAndClick(componentsTab);
        log.info(" Mouse hover on “Components” Tab and click " + componentsTab.toString());

    }

    //Click on Show All Desktop tab
    public void clickOnShowAllDesktop(){
        clickOnElement(showAllDesktopTab);
        log.info("Click on Show All Desktop tab " +showAllDesktopTab.toString());
    }

    //Click on Show All LaptopAndNotebook Tab
    public void clickOnShowAllLaptopAndNoteBook(){
        clickOnElement(showAllLaptopAndNotebookTab);
        log.info("Click on Show All LaptopAndNotebook Tab " + showAllLaptopAndNotebookTab.toString());
    }

    //This method will select currency from drop down
    public void clickOnCurrency(String text) {

        clickOnElement(currencyLink);
        log.info("Clicking on Currency on top of page " + currencyLink.toString());
        List<WebElement> currencyList = currencyList1;
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase(text)) {
                e.click();
                break;
            }
        }
        log.info("Select "+text+ " from currency drop down list "+currencyList1.toString());
    }

    //This method will select options from myAccount options drop down
    public void selectMyAccountOptions(String option) {

        List<WebElement> myAccountList = myAccountOptions;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = myAccountOptions;
        }
        log.info("Select "+option+ "from myAccount drop down list "+myAccountOptions.toString());
    }


    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully
    //1.1 Click on My Account Link.
    public void clickOnMyAccountLink(){
        Reporter.log("Clicking on My Account Link " +myAccountLink.toString());
        clickOnElement(myAccountLink);

    }

}

