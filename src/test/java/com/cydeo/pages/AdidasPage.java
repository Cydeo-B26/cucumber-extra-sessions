package com.cydeo.pages;



import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdidasPage {
    public AdidasPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement purchasePrice;

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addCart;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeLink;

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cart;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeButton;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "card")
    public WebElement card;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmation;

    @FindBy(xpath = "//button[@class=\"confirm btn btn-lg btn-primary\"]")
    public WebElement OK;

    @FindBy(xpath = "//a[@class='hrefch']")
    public List<WebElement> products;



    public void clickCategory(String category){

        Driver.getDriver().findElement(By.xpath("//a[.='" + category + "']")).click();
        BrowserUtils.waitFor(2);

    }


    public String getProductPrice(String product){


        String actualPrice = Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='" + product + "']/../../h5")).getText();
        // $790

        return actualPrice.substring(1);



    }




}
