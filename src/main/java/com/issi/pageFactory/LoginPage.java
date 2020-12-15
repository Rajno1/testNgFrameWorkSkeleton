package com.issi.pageFactory;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.issi.Base.BaseClass;
import com.issi.constants.FrameworkConstants;
import com.issi.utilities.ExcelUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseClass{

    public LoginPage(WebDriver driver) {
         excel = new ExcelUtilities(FrameworkConstants.getExcelTestDataPath());
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='Email']")
    static WebElement emailField;

    @FindBy(xpath = "//input[@id='Password']")
    static WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    static WebElement loginButton;

    //action methods of webelements
    public static void enterEmailId(){
        clearText(emailField);
        test.info("cleared the previous data present in email field");
        String username = excel.getCellData("loginDetails","emailid",2);
        enterText(emailField,username);
        test.info("user name has been entered as -> "+ username +"");

    }

    public static void enterPassword(){
        clearText(passwordField);
        test.info("cleared the previous data present in password field");
        String password = excel.getCellData("loginDetails","password",2);
        enterText(passwordField,password);
        test.info("password has been entered as -> "+password+"");

    }
    public static void clickOnLoginbtn(){
        clickOn(loginButton);
        test.info("clicked on login button");

        /* After clicking on login button using - pageTitleValidation() method we are validating
        here home page title. only after validation it will print "Login in successful"
         */
        String pageTitle = pageTitleValidation(driver,"Dashboard / nopCommerce administration");
        test.info("After clicking on login button - HomePage title => "+pageTitle+" has been varified ");
        test.log(Status.PASS, MarkupHelper.createLabel("Login is successful ", ExtentColor.GREEN));

    }

}
