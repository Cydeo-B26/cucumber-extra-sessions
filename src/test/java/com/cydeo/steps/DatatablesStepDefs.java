package com.cydeo.steps;

import com.cydeo.pages.VyTrackHomePage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
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
}
