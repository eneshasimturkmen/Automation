package com.automation.stepdefinitons;

import com.automation.pages.BasePage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.*;

public class register_stepdefinition {

    BasePage page = new BasePage();

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

        page.signUpButton.click();
    }
    @Then("Verify New User Signup! visible")
    public void verify_new_user_signup_visible() {
        assertTrue(page.messageOne.isDisplayed());
        //System.out.println("page.messageOne.getText() = " + page.messageOne.getText());


    }

    @When("user enter name and email address")
    public void userEnterNameAndEmailAddress() {

    }

    @And("user clicks SignUp button")
    public void userClicksSignUpButton() {

    }

    @Then("verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {

    }
}
