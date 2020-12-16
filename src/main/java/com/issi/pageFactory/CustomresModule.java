package com.issi.pageFactory;

import com.issi.Base.BaseClass;
import com.issi.constants.FrameworkConstants;
import com.issi.utilities.ExcelUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomresModule extends BaseClass {
    public CustomresModule(WebDriver driver) {
        excel = new ExcelUtilities(FrameworkConstants.getExcelTestDataPath());
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#']//span[contains(text(),'Customers')]")
    static WebElement CustomersMenu;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//span[contains(text(),'Customers')]")
    static WebElement customerMenuItem;

    @FindBy(xpath = "//a[@class='btn bg-blue']")
    static WebElement addButton;

    @FindBy(xpath = "//input[@name='Email']")
    static WebElement Email_text;

    @FindBy(xpath = "//input[@id='Password']")
    static WebElement Password_text;

    @FindBy(xpath = "//input[@id='FirstName']")
    static WebElement FirstName_text;

    @FindBy(xpath = "//input[@name='LastName']")
    static WebElement LastName_text;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    static WebElement Gender_male;

    @FindBy(xpath = "//input[@id='Gender_Female']")
    static WebElement Gender_female;

    @FindBy(xpath = "//input[@name='DateOfBirth']")
    static WebElement DOB_date;

    @FindBy(xpath = "//input[@id='Company']")
    static WebElement Company_name_text;

    @FindBy(xpath = "//input[@name='IsTaxExempt']")
    static WebElement is_tax_empty_chbox;

    @FindBy(xpath = "//*[@id=\"customer-info\"]/div[2]/div[1]/div[9]/div[2]/div/div[1]/div")
    static WebElement newsletterlist;

    @FindBy(xpath = "//li[contains(text(),'Your store name')]")
    static WebElement NewsletterOption;

    @FindBy(xpath = "//li[contains(text(),'Test store 2')]")
    static WebElement TestStory2Option;

    @FindBy(xpath = "//*[@id=\"customer-info\"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div")
    static WebElement Customer_role_drpdn;


    static By AlreadySelected_custrole = By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[contains(text(),'Registered')]");
    static By Administrators_option = By.xpath("//li[contains(text(),'Administrators')]");
    static By ForumModerators_option = By.xpath("//li[contains(text(),'Forum Moderators')]");
    static By Guest_option = By.xpath("//li[contains(text(),'Guests')]");
    static By Vendors_option = By.xpath("//li[contains(text(),'Vendors')]");

    @FindBy(how = How.XPATH, using = "//select[@name='VendorId']")
    static WebElement Manager_of_vendor;

    static By Vendor_1 = By.xpath("//option[contains(text(),'Vendor 1')]");
    static By Vendor_2 = By.xpath("//option[contains(text(),'Vendor 2')]");

    @FindBy(how = How.XPATH, using = "//input[@name='Active']")
    static WebElement Active_chbox;

    @FindBy(how = How.XPATH, using = "//textarea[@id='AdminComment']")
    static WebElement Admin_comment;

    @FindBy(how = How.XPATH, using = "//button[@name='save']")
    static WebElement save_button;

    @FindBy(xpath = "//a[@href='/logout']")
    static WebElement logout_link;


    //action methods

    public static void clickOnCustomersMenu() {
        clickOn(CustomersMenu);
        test.info("Clicked on customers menu");
    }

    public static void clickOnCustomerMenuItem() {
        clickOn(customerMenuItem);
        test.info("Clicked on customers sub menu item");
    }

    public static void clickOnAddNew() {
        clickOn(addButton);
        test.info("Clicked on add new button");
    }

    public static void enterEmail() {
        String emailData = excel.getCellData("CustomerInfo", "Email", 2);
        enterText(Email_text, emailData);
        test.info("Email has been entered as " + emailData);
    }

    public static void enterPassword() {
        String passwordData = excel.getCellData("CustomerInfo", "Password", 2);
        enterText(Password_text, passwordData);
        test.info("Password has been entered as " + passwordData);
    }

    public static void enterFristName() {
        String firstname = excel.getCellData("CustomerInfo", "FirstName", 2);
        enterText(FirstName_text, firstname);
        test.info(" first name has been entered as " + firstname);

    }

    public static void enterLastName() {
        String lastname = excel.getCellData("CustomerInfo", "LastName", 2);
        enterText(LastName_text, lastname);
        test.info("Last name has been entered as " + lastname);

    }

    public static void selectGender() {
        String gender = excel.getCellData("CustomerInfo", "Gender", 2);
        if (gender.equalsIgnoreCase("Male")) {
            clickOn(Gender_male);
            test.info("Gender has been selected as " + gender);
        } else if (gender.equalsIgnoreCase("Female")) {
            clickOn(Gender_female);
            test.info("Gender has been selected as " + gender);
        }

    }

    public static void enterDOB() {
        String dob = excel.getCellData("CustomerInfo", "DateOfBirth", 2);
        enterText(DOB_date, dob);
        test.info("DateOfBirth has been selected as " + dob);
    }

    public static void enterCompanyName() {
        String companyname = excel.getCellData("CustomerInfo", "CompanyName", 2);
        enterText(Company_name_text, companyname);
        test.info("Company name has been entered as " + companyname);
    }

    public static void clickOnIstaxEmpty() {
        clickOn(is_tax_empty_chbox);
        test.info("is tax empty check box clicked");
    }

    public static void cickOnNewsLetter() throws InterruptedException {
        clickOn(newsletterlist);
        Thread.sleep(2000);
        String newsletter = excel.getCellData("CustomerInfo", "NewsLetter", 2);
        if (newsletter.equalsIgnoreCase("your store name")) {
            clickOn(NewsletterOption);
            test.info("News Letter has been selected as " + newsletter);
        } else if (newsletter.equalsIgnoreCase(" test story 2")) {
            clickOn(TestStory2Option);
            test.info("News Letter has been selected as " + newsletter);
        }
    }

    public static void selectCustomerRole() throws InterruptedException {


        String role = excel.getCellData("CustomerInfo", "CustomerRole", 2);
        WebElement role_option = null;
        if (!role.equals("Vendors")) {
            getElement(driver, AlreadySelected_custrole);

        }
        clickOn(Customer_role_drpdn);
        Thread.sleep(2000);
        if (role.equals("Administrators")) {
            role_option = getElement(driver, Administrators_option);
            clickOn(role_option);
            test.info("customer role has been selected as "+role);
        } else if (role.equals("Forum Moderators")) {
            role_option = getElement(driver, ForumModerators_option);
            clickOn(role_option);
            test.info("customer role has been selected as "+role);
        } else if (role.equals("Guests")) {
            role_option = getElement(driver, Guest_option);
            clickOn(role_option);
            test.info("customer role has been selected as "+role);
        }
    }


    public static void selectVendor() {
        String vendorID = excel.getCellData("CustomerInfo", "ManagerOfVendor", 2);
        Select vendor = new Select(Manager_of_vendor);

        if (vendorID.equals("Vendor 1")) {
            vendor.selectByVisibleText("Vendor 1");
        } else if (vendorID.equals("Vendor 2")) {
            vendor.selectByVisibleText("Vendor 2");
        }


    }

    public static void activeChbxStatus() {
        boolean status = Active_chbox.isSelected();
       // System.out.println("Active staus is" + status);
        test.info("Activation status of 'Active' check box is "+status);
    }

    public static void addAdminComments() {
        String comments = "This is demo on adding a new customer";
        enterText(Admin_comment, comments);
        test.info("comments has been added as => "+ comments);
    }

    public static void clickOnSaveBtn() {
        clickOn(save_button);
        test.info("Clicked on save button");

    }

    public static void click_onLogout() {
        clickOn(logout_link);
        test.info("clicked on logOut link");

    }

}
