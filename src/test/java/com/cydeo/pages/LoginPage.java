package com.cydeo.pages;


import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = " //input[@id='prependedInput'] ")
    private WebElement userNameField;

    @FindBy(xpath = " //input[@id='prependedInput2'] ")
    private WebElement passwordField;

    @FindBy(xpath = " //button[@id='_submit'] ")
    public WebElement loginButton;


    public void login(String username,String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void loginDynamic(String userType) {

        userType= userType.replace(" ", "_");

        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");


        login(username,password);
    }
}
