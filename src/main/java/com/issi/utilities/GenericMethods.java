package com.issi.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GenericMethods {

    /**+
     *  it will launch the url
     * @param driver - driver reference
     * @param url  - url you want to launch
     */
    public static void openUrl(WebDriver driver,String url) {
        driver.get(url);
    }

    /**
     * page title validation
     * @param driver - webdriver instance
     * @param titleExpected - expected title in string
     */
    public static String pageTitleValidation(WebDriver driver,String titleExpected){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,titleExpected);
        return actualTitle;
    }

    /**+
     * to close complete window
     * @param driver - driver reference
     */
    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }

    /**
     * to close open window
     * @param driver
     */
    public static void closeWindow(WebDriver driver) {

        driver.close();
    }

    /**
     * clear the text present in textfield based on element
     * @param element - Text field identified
     */
    public static void clearText(WebElement element)
    {
        try
        {
          // element.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            element.clear();
        }
        catch(NoSuchElementException e)
        {
            System.out.println("clould not clear.got an exception");
            throw e;
        }
    }

    /**
     * clear text field based on element identified using 'By'  class
     * @param driver - webdriver instance
     * @param xpath - xpath for the text field
     */
    public static void clearText(WebDriver driver,By xpath)
    {
        try
        {
            driver.findElement(xpath).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
           // element.clear();
        }
        catch(NoSuchElementException e)
        {
            System.out.println("clould not clear.got an exception");
            throw e;
        }
    }

    /**
     * a method to clear text and enter a new value
     * @param element- element identified
     * @param value - String value that you want to set
     */
    public static void clearAndSetText(WebElement element,String value){
        try {
            element.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            Thread.sleep(3000);
            element.sendKeys(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * a replacement method for 'sendkeys()'
     * @param element - element identified
     * @param text - String value that you want to set
     */
    public static void enterText(WebElement element, String text) {

        try{
            if (text == "enter")
                element.sendKeys(Keys.ENTER);
            else
                element.sendKeys(text);
        }
        catch(ElementNotVisibleException e)
        {
            System.out.println("Got an element not visible exception");
            throw e;
        }

    }

    /**
     * Enter text using javascript executor
     * @param driver - webdriver interface
     * @param idvalue - element locator (id) value
     * @param text - text you want to enter
     */
    public static void enterTextJS(WebDriver driver,String idvalue,String text){
        try{
            ((JavascriptExecutor)driver).executeScript("document.getElementById('"+idvalue+"').value='"+text+"'");
        }
        catch(ElementNotVisibleException e)
        {
            System.out.println("Got an element not visible exception");
            throw e;
        }
    }

    /**
     * performing click operation using javascriptExecutor on element identified using By class
     * @param driver - webdriver instance
     * @param xpath - xpath of an element
     * @return - on successful click it will return true
     * @throws Exception - Exception on failure
     */

    public static boolean clickUsingJS(WebDriver driver, By xpath) throws Exception {

        try {
            WebElement ele = driver.findElement(xpath);
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",ele);
            return true;
        } catch(ElementClickInterceptedException e)
        {
            System.out.println("unable to click on element Got an click intercept exception");
            throw e;
        }
    }

    /**
     * performing click operation using javascriptExecutor on webelement identified
     * @param driver - webdriver instance
     * @param element - element identified
     * @return - on successful click it will return true
     * @throws Exception - exception on failure
     */
    public static boolean clickUsingJS(WebDriver driver,WebElement element) throws Exception {

        try {
            //WebElement ele = driver.findElement(xpath);
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
            return true;
        } catch(ElementClickInterceptedException e)
        {
            System.out.println("unable to click on element Got an click intercept exception");
            throw e;
        }
    }

    /**
     * generic method for click operation with our using JavaScript
     * @param element - element to be clicked
     * @return - on successful click operation it will return true
     */
    public static boolean clickOn(WebElement element){
        try
        {
            element.click();
            return true;
        }
        catch(ElementClickInterceptedException e)
        {
            System.out.println("unable to click on element Got an click intercept exception");
            throw e;
        }
    }

    /**+
     * taking screen shot
     * @param driver - driver instance
     * System.getProperty("user.dir") - it is the way to get current working directory
     * System.getProperty("user.home") - is a way to get home directory of current user
     */
    public static void captureScreenShot(WebDriver driver){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * generic/replacement method for '.findElement()' method
     * @param driver - webdriver instance
     * @param xpath - Xpath of an element
     * @return - it returns a webelement
     */
    public static WebElement getElement(WebDriver driver, By xpath) {

        try {
            WebElement element = driver.findElement(xpath);
            return element;

        } catch (ElementNotVisibleException e) {
            System.out.println("coudnot find the element.Element Not visible exception");
            throw e;
        }

    }

    /**
     * generic/replacement method for '.findElements()' method
     * @param driver - webdriver instance
     * @param xpath - xpath of an element
     * @return - returns a list of webelements
     */
    public static List<WebElement> getElements(WebDriver driver, By xpath) {

        try {
            List<WebElement> element = driver.findElements(xpath);
            return element;

        } catch (ElementNotVisibleException e) {
            System.out.println("coudnot find the element.Element Not visible exception");
            throw e;
        }

    }

    /**
     * generic method for Explicit wait
     * @param driver - web driver instance
     * @param timeOutInSeconds - wait time in seconds
     * @param element - target element
     */
    public static void waitForelement(WebDriver driver,long timeOutInSeconds,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }


    /**
     * Scrolling page based on element
     * @param driver - webdriver instance
     * @param element -target element
     */
    public static void scrollToElement(WebDriver driver,WebElement element){
        try {
            waitForelement(driver,30,element);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Action class methods



}
