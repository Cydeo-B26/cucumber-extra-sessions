package com.cydeo.steps;

import com.cydeo.pages.AdidasPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AdidasStepDefs {
    AdidasPage adidasPage=new AdidasPage();
    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("adidasUrl"));


    }
    @Then("User should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String,String>> productDetails) {

        for (Map<String, String> productDetail : productDetails) {

            System.out.println("====== Product Details====");

            System.out.println(productDetail.get("Category"));

            adidasPage.clickCategory(productDetail.get("Category"));  // click category

            System.out.println(productDetail.get("Product"));

            String actualPrice = adidasPage.getProductPrice(productDetail.get("Product")); // get me product price


            // get me expectedPrice

            System.out.println(productDetail.get("expectedPrice"));
            String expectedPrice = productDetail.get("expectedPrice");


            Assert.assertEquals(expectedPrice,actualPrice);
        }

    }



    @Then("User should be able to see expected prices in following products with listOflist")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist(List<List<String>> productDetails) {


        for (List<String> productDetail : productDetails) {
            System.out.println(" ======== Product Details ======== ");
            System.out.println(productDetail.get(0));  //  Category


            // click category
            adidasPage.clickCategory(productDetail.get(0));

            // get product price
            String actualPrice = adidasPage.getProductPrice(productDetail.get(1));


            System.out.println(productDetail.get(1));  // Product


            // get me expectedPrice
            String expectedPrice = productDetail.get(2);
            System.out.println(productDetail.get(2));  // price


            Assert.assertEquals(expectedPrice,actualPrice);
        }
    }

}
