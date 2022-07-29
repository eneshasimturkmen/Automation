package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Signup / Login")
    public WebElement signupBtn;


    @FindBy(xpath = "//h2[.='New User Signup!']")
    public WebElement messageOne;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailaddress;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement newSignUpButton;


    @FindBy(xpath = "//b[.='Enter Account Information']")
    public WebElement enterAccountmessage;

    @FindBy(id = "id_gender1")
    public WebElement title;

    @FindBy(id = "password")
    public  WebElement passwordBox;


    @FindBy(xpath = "//select[@id = 'days']")
    public WebElement days;

    @FindBy(xpath = "//select[@id = 'months']")
    public WebElement months;

    @FindBy(xpath = "//select[@id = 'years']")
    public WebElement years;

    @FindBy(id = "newsletter")
    public WebElement newslettercheckbox;

    @FindBy(id = "optin")
    public WebElement optincheckbox;

    @FindBy(id = "first_name")
    public WebElement firstname;
    
    @FindBy(id = "last_name")
    public WebElement lastname;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement addressOne;

    @FindBy(id = "address2")
    public WebElement addressTwo;
    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobile_number;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(xpath = "(//button[@class='btn btn-default'])[1]")
    public WebElement createButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement continueButton;


    @FindBy(xpath = "//h2[@class=\"title text-center\"]")
    public WebElement accountcreatedTitle;

    @FindBy(xpath = "//li[10]")
    public WebElement LoggenInAsText;

    @FindBy(linkText = "Delete Account")
    public WebElement deleteAccountButton;














}
