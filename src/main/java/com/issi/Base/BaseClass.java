package com.issi.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.issi.Driver.Driver;
import com.issi.pageFactory.CustomresModule;
import com.issi.pageFactory.LoginPage;
import com.issi.report.SendEmailWithAttachment;
import com.issi.utilities.ExcelUtilities;
import com.issi.utilities.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends GenericMethods{

    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentSparkReporter sparkFailed;
    public static WebDriver driver;
    public static ExcelUtilities excel;
    public static ExtentTest test;
    public static SendEmailWithAttachment sendMail;


    //Objects of PageFactory
    public static LoginPage logpg;
    public static CustomresModule cm;

    @BeforeClass
    public void setupBrowser(){
        Driver.initDriver("chrome");
    }

    @BeforeMethod
    public void setupLogin() {
        Driver.initLogin();
    }


    @AfterMethod
    public void tearDownlogin() {
        Driver.initLogOut();
    }

    @AfterClass
    public void tearDownBrowser(){
        Driver.quiteDriver();
    }

}
