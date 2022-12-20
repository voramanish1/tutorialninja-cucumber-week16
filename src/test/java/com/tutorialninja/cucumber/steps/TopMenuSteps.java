package com.tutorialninja.cucumber.steps;

import com.tutorialninja.pages.ComponentsPage;
import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopAndNotebookPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TopMenuSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
    }

    @When("^I mouse hover and click on desktop tab$")
    public void iMouseHoverAndClickOnDesktopTab() {
        new HomePage().navigateToDesktopPage();
    }

    @And("^I select menu \"([^\"]*)\"$")
    public void iSelectMenu(String menu) {
        new HomePage().selectMenu(menu);

    }

    @Then("^I should navigate to desktop page successfully$")
    public void iShouldNavigateToDesktopPageSuccessfully() {
        Assert.assertEquals("Not navigate to Desktop page","Desktops", new DesktopPage().getDesktopText());
    }

    @When("^I mouse hover and click on laptop and notebook tab$")
    public void iMouseHoverAndClickOnLaptopAndNotebookTab() {
        new HomePage().navigateToLaptopAndNotebooksPage();
    }

    @Then("^I should navigate to laptop and notebook page successfully$")
    public void iShouldNavigateToLaptopAndNotebookPageSuccessfully() {
        Assert.assertEquals("Not navigate to Laptops and Notebooks page","Laptops & Notebooks",new LaptopAndNotebookPage().getLaptopAndNotebookText());
    }

    @When("^I mouse hover and click on component tab$")
    public void iMouseHoverAndClickOnComponentTab() {
        new HomePage().navigateToComponentsPage();
    }

    @Then("^I should navigate to component page successfully$")
    public void iShouldNavigateToComponentPageSuccessfully() {
        Assert.assertEquals("Not navigate to Components page","Components",new ComponentsPage().getComponentText());
    }
}
