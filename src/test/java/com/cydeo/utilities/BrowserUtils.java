package com.cydeo.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserUtils {



    /**
     * A method to pause the thread certain seconds
     * @param seconds
     */
    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static List<String> getElementsText(List<WebElement> elements) {


        List<String> elementsText=new ArrayList<>();

        for (WebElement element : elements) {
            elementsText.add( element.getText());
        }

        return elementsText;
    }


    public static List<String> getElementsTextWithStream(List<WebElement> elements) {

        return elements.stream().map(x->x.getText()).collect(Collectors.toList());
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Waits for alertIsPresent
     *
     */
    public static void waitForAlertIsPresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}


