package com.cydeo.steps;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.VyTrackHomePage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DatatablesStepDefs {

    VyTrackHomePage vyTrackHomePage=new VyTrackHomePage();


    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedModules) {

        BrowserUtils.waitFor(3);

        List<String> actualModulesName = BrowserUtils.getElementsText(vyTrackHomePage.allModules);


        Assert.assertEquals(expectedModules,actualModulesName);



    }

    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {

        String username = credentials.get("username");
        String password = credentials.get("password");

        new LoginPage().login(username,password);

        BrowserUtils.waitFor(3);


    }
    @Then("user should be able to see folllowing information")
    public void user_should_be_able_to_see_folllowing_information(Map<String,String> userInfo) {


        String actualUserInfo = vyTrackHomePage.username.getText();


        String expectedUserInfo = userInfo.get("firstname") + " " + userInfo.get("lastname");


        Assert.assertEquals(expectedUserInfo,actualUserInfo);

    }



    @Then("User should be able to see following names in their groups")
    public void user_should_be_able_to_see_following_names_in_their_groups(Map<String,List<String>> mapOfList) {

        List<String> group1 = mapOfList.get("Group1");
        System.out.println(group1);

        System.out.println("============");

        List<String> group2 = mapOfList.get("Group2");
        System.out.println(group2);

        System.out.println("============");

        List<String> group3 = mapOfList.get("Group3");
        System.out.println(group3);
    }
}
