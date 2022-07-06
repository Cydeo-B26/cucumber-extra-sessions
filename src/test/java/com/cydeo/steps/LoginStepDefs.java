package com.cydeo.steps;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefs {

    LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));

    }
    @When("user enters the driver information")
    public void user_enters_the_driver_information() {
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

        loginPage.login(username,password);

    }
    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";


        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("user enters the sales manager information")
    public void user_enters_the_sales_manager_information() {
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");

     loginPage.login(username,password);



    }

    @When("user enters the store manager information")
    public void user_enters_the_store_manager_information() {
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");

        loginPage.login(username,password);
    }

    @When("user enters the {string} information")
    public void user_enters_the_information(String userType) {

        loginPage.loginDynamic(userType);



    }
}
