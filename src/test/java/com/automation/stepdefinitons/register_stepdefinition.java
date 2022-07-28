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
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class register_stepdefinition {

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

        page.name.sendKeys(faker.name().firstName());
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
}
