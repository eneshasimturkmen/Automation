package com.automation.stepdefinitons;

import com.automation.pages.BasePage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.github.javafaker.Faker;
import com.github.javafaker.Faker.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class register_stepdefinition {

    String firstName;

    BasePage page = new BasePage();
    Faker faker = new Faker();

    @Given("User navigate to homepage")
    public void user_navigate_to_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));


    }
    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {

        assertEquals(ConfigurationReader.getProperty("url"),Driver.getDriver().getCurrentUrl());


    }
    @When("User clicks on Signup button")
    public void user_clicks_on_signup_button() {

        page.signupBtn.click();
    }



    @Then("Verify New User Signup! visible")
    public void verify_new_user_signup_visible() {
        assertTrue(page.messageOne.isDisplayed());
        //System.out.println("page.messageOne.getText() = " + page.messageOne.getText());


    }

    @When("user enter name and email address")
    public void userEnterNameAndEmailAddress() {

        firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);
        page.name.sendKeys(firstName);
        page.emailaddress.sendKeys(faker.internet().emailAddress());

    }

    @And("user clicks SignUp button")
    public void userClicksSignUpButton() {

        page.newSignUpButton.click();
    }

    @Then("verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {

        Assert.assertTrue("Message is not displayed",page.enterAccountmessage.isDisplayed());

    }

    @And("fill details following information")
    public void fillDetailsFollowingInformation() {

        page.title.click();

        page.passwordBox.sendKeys(faker.internet().password());

        /*
        List<WebElement> days = page.days;
        List<String> day = new ArrayList<>();

        for (WebElement each : days) {
            day.add(each.getText());
        }

         */

        Select day = new Select(page.days);
        //There are 3 methods to select options
        day.selectByVisibleText("17");
        /*
        day.selectByIndex(5);
        day.selectByValue("5");
         */
        Select month  = new Select(page.months);
        month.selectByVisibleText("February");
        Select year = new Select(page.years);
        year.selectByVisibleText("1996");

    }


    @And("user select checkboxone")
    public void userSelectCheckboxone() {

        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)");
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(page.newslettercheckbox));
        page.newslettercheckbox.click();


    }

    @And("user select checkboxtwo")
    public void userSelectCheckboxtwo() {

        page.optincheckbox.click();

    }

    @And("user fill following details")
    public void userFillFollowingDetails(Map<String,String> informationTable) {


        page.firstname.sendKeys(informationTable.get("FirstName"));
        page.lastname.sendKeys(informationTable.get("LastName"));
        page.company.sendKeys(informationTable.get("Company"));
        page.addressOne.sendKeys(informationTable.get("Address"));
        page.addressTwo.sendKeys(informationTable.get("Address2"));
        page.state.sendKeys(informationTable.get("State"));
        page.city.sendKeys(informationTable.get("City"));
        page.zipcode.sendKeys(informationTable.get("ZipCode"));
        page.mobile_number.sendKeys(informationTable.get("MobileNumber"));


    }


    @And("user clicks on create account button")
    public void userClicksOnCreateAccountButton() {


        page.createButton.click();

    }

    @Then("verify Account Created is visible")
    public void verifyAccountCreatedIsVisible() {

        assertTrue(page.accountcreatedTitle.isDisplayed());

    }

    @And("user clicks on Continue button")
    public void userClicksOnContinueButton() {

        page.continueButton.click();

    }

    @Then("Verify that {string} is visible")
    public void verifyThatLoggedInAsUsernameIsVisible(String message) {



        message = "Logged in as " + firstName;
        System.out.println("page.loggedMessage.getText() = " + page.LoggenMessage.getText());
        assertTrue(page.LoggenMessage.getText().equalsIgnoreCase(message));
    }

    @And("user clicks on Delete Account button")
    public void userClicksOnDeleteAccountButton() {

        page.deleteAccountButton.click();


    }

}
