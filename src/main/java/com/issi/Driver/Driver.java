package com.issi.Driver;

import com.issi.Base.BaseClass;
import com.issi.constants.FrameworkConstants;
import com.issi.pageFactory.HomePage;
import com.issi.pageFactory.LoginPage;
import com.issi.utilities.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.issi.pageFactory.HomePage.click_onLogout;
import static com.issi.pageFactory.LoginPage.*;


public class Driver extends BaseClass {


    public static void initDriver(String browser) {

        if (Objects.isNull(driver)) {   // if driver object is null
              /*
                 chrome Browser will run in 'incognito' mode,
                 Incognito Mode is an online privacy feature
                 that prevents your browsing history from being stored
                */
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");

            // Based on 'browser' value, Browser will startup.

            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxDriverPath());
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", FrameworkConstants.getIEDriverPath());
                driver = new InternetExplorerDriver();
            } else {
                Assert.fail(MessageFormat.format("Wrong Browser: {0}", browser));
            }

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(FrameworkConstants.time, TimeUnit.SECONDS);

            openUrl(driver, FrameworkConstants.getUrl());
        }

    }

    public static void quiteDriver() {
        if (Objects.nonNull(driver)) {
            closeBrowser(driver);
            driver = null;
        }
    }

    public static void initLogin(){
        logpg = new LoginPage(driver);
        enterEmailId();
        enterPassword();
        clickOnLoginbtn();

    }
    public static void initLogOut(){
        hmpg = new HomePage(driver);
        click_onLogout();

    }
}
