package com.tutorialninja.cucumber.steps;

import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.ProductPage;
import com.tutorialninja.pages.ShoppingCartPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DesktopPageSteps {

    @And("^I click on show all desktops$")
    public void iClickOnShowAllDesktops() {
        new HomePage().clickOnShowAllDesktop();
    }

    @And("^I select currency \"([^\"]*)\"$")
    public void iSelectCurrency(String currency) {
        new HomePage().clickOnCurrency(currency);
    }

    @And("^I click on sort by position$")
    public void iClickOnSortByPosition() {
        new DesktopPage().clickOnSortByPosition();
    }

    @And("^I select product sort by \"([^\"]*)\"$")
    public void iSelectProductSortBy(String text) {
        new DesktopPage().selectProductSorted(text);
    }

    @Then("^I should see product arrange in alphabetical order successfully$")
    public void iShouldSeeProductArrangeInAlphabeticalOrderSuccessfully() {
        Assert.assertEquals("Products not sorted as expected.", new DesktopPage().expectedList(), new DesktopPage().getSortedProductList());
    }


    @And("^I select product \"([^\"]*)\"$")
    public void iSelectProduct(String productName) {
        new DesktopPage().clickOnProductHPLP3065(productName);
    }

    @Then("^I should navigate to \"([^\"]*)\" product page$")
    public void iShouldNavigateToProductPage(String productName) {
        Assert.assertEquals("HP LP3065 Product not display", productName, new ProductPage().getProductHPLP3065());

    }

    @And("^I select date \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void iSelectDate(String year, String month, String date) {
        new ProductPage().selectDate(year, month, date);
    }

    @And("^I add quantity \"([^\"]*)\" for product$")
    public void iAddQuantityForProduct(String quantity) {
        new ProductPage().addQuantityForProduct(quantity);
    }

    @And("^I click on add to cart button$")
    public void iClickOnAddToCartButton() throws InterruptedException {
        Thread.sleep(500);
        new ProductPage().clickOnAddToCartButton();
    }

    @Then("^I should see product added successfully message$")
    public void iShouldSeeProductAddedSuccessfullyMessage() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue("Product not added to cart", new ProductPage().getSuccessText().contains("Success: You have added HP LP3065 to your shopping cart!"));
    }

    @And("^I click on shopping cart button$")
    public void iClickOnShoppingCartButton() throws InterruptedException {
        Thread.sleep(500);
        new ProductPage().clickOnShoppingCartButton();
    }

    @Then("^I should see shopping cart text$")
    public void iShouldSeeShoppingCartText() {
        Assert.assertTrue("Shopping cart page not opened", new ShoppingCartPage().getShoppingCartText().contains("Shopping Cart"));
    }

    @And("^I should see \"([^\"]*)\" product name$")
    public void iShouldSeeProductName(String productName) {
        Assert.assertEquals("Product name not matched", "HP LP3065", new ShoppingCartPage().getProductText());

    }

    @And("^I should see \"([^\"]*)\" delivery date$")
    public void iShouldSeeDeliveryDate(String deliveryDate) {
        Assert.assertTrue("Delivery date not matched", new ShoppingCartPage().getDeliveryDateOfProduct().contains("2022-11-30"));

    }

    @And("^I should see \"([^\"]*)\" model name$")
    public void iShouldSeeModelName(String modelName) {
        Assert.assertEquals("Model not matched", "Product 21", new ShoppingCartPage().getProductModel());
    }

    @And("^I should see total price$")
    public void iShouldSeeTotalPrice() {
        Assert.assertEquals("Total not matched", "£74.73", new ShoppingCartPage().getTotalPrice());
    }
}
