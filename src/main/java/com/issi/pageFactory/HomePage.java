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

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        excel = new ExcelUtilities(FrameworkConstants.getExcelTestDataPath());
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.XPATH,using = "//a[@href='#']//span[contains(text(),'Customers')]")
    static WebElement CustomersMenu;

    @FindBy(how = How.XPATH,using ="//a[@href='/Admin/Customer/List']//span[contains(text(),'Customers')]")
    static WebElement customerMenuItem;

    @FindBy(how = How.XPATH,using ="//a[@class='btn bg-blue']")
    static WebElement addButton;

    @FindBy(how= How.XPATH, using ="//input[@name='Email']")
    static WebElement Email_text;

    @FindBy(how=How.XPATH,using ="//input[@id='Password']")
    static WebElement Password_text;

    @FindBy(how= How.XPATH,using ="//input[@id='FirstName']")
    static WebElement FirstName_text;

    @FindBy(how= How.XPATH,using ="//input[@name='LastName']")
    static WebElement LastName_text;

    @FindBy(how= How.XPATH,using ="//input[@id='Gender_Male']")
    static WebElement Gender_male;

    @FindBy(how= How.XPATH,using ="//input[@id='Gender_Female']")
    static WebElement Gender_female;

    @FindBy(how= How.XPATH,using ="//input[@name='DateOfBirth']")
    static WebElement DOB_date;

    @FindBy(how= How.XPATH,using ="//input[@id='Company']")
    static WebElement Company_name_text;

    @FindBy(how= How.XPATH,using ="//input[@name='IsTaxExempt']")
    static WebElement is_tax_empty_chbox;

    @FindBy(how= How.XPATH,using ="(//div[@class='k-multiselect-wrap k-floatwrap' and @role='listbox'])[1]")
    static WebElement Newsletter_chbox;

    @FindBy(how= How.XPATH,using ="//li[contains(text(),'Test store 2')]")
    static WebElement Test_store2_chbox;

    @FindBy(how= How.XPATH,using ="//div[@class='k-multiselect-wrap k-floatwrap']")
    static WebElement Customer_role_drpdn;


    static By AlreadySelected_custrole = By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[contains(text(),'Registered')]");
    static By Administrators_option = By.xpath("//li[contains(text(),'Administrators')]");
    static By ForumModerators_option  = By.xpath("//li[contains(text(),'Forum Moderators')]");
    static By Guest_option = By.xpath("//li[contains(text(),'Guests')]");
    static By Vendors_option = By.xpath("//li[contains(text(),'Vendors')]");

    @FindBy(how=How.XPATH,using="//select[@name='VendorId']")
    static WebElement Manager_of_vendor;

    static By Vendor_1 = By.xpath("//option[contains(text(),'Vendor 1')]");
    static By Vendor_2 = By.xpath("//option[contains(text(),'Vendor 2')]");

    @FindBy(how=How.XPATH,using="//input[@name='Active']")
    static WebElement Active_chbox;

    @FindBy(how=How.XPATH,using="//textarea[@id='AdminComment']")
    static WebElement Admin_comment;

    @FindBy(how=How.XPATH, using ="//button[@name='save']")
    static WebElement save_button;

    @FindBy(xpath = "//a[@href='/logout']")
    static WebElement logout_link;

    //Elements of Delete Customer

    //action methods

    public static void clickCustomersMenu()  {

        clickOn(CustomersMenu);
    }

    public static void clickCustomerMenuItem() {
        clickOn(customerMenuItem);
    }

    public static void clickOnAddbutton() {
        clickOn(addButton);
    }

    public static void Enter_email(String string) {
        enterText(Email_text, string);
    }

    public static void Enter_password(String string) {
        enterText(Password_text, string);
    }

    public static void Enter_Frist_Name(String string) {
        enterText(FirstName_text, string);
    }

    public static void Enter_Last_Name(String string) {
        enterText(LastName_text, string);
    }

    public static void select_gender(String gender) {
        if(gender.equalsIgnoreCase("Male"))
            clickOn(Gender_male);
        else if(gender.equalsIgnoreCase("Female"))
            clickOn(Gender_female);
    }

    public static void Enter_DOB(String date) {
        enterText(DOB_date, date);
    }

    public static void Enter_company_name(String compname) {
        enterText(Company_name_text, compname);
    }

    public static void clickOn_is_taxempty() {
        clickOn(is_tax_empty_chbox);
    }

    public static void cickOn_Newsletter() {
        clickOn(Newsletter_chbox);
        clickOn(Test_store2_chbox);
    }

    public static void select_customerRole(String role) {
        WebElement role_option = null;
        if(!role.equals("Vendors")) {
            getElement(driver, AlreadySelected_custrole);

        }

        clickOn(Customer_role_drpdn);

        if(role.equals("Administrators")) {
            role_option = getElement(driver, Administrators_option);
        }
        else if(role.equals("Forum Moderators")){
            role_option = getElement(driver,ForumModerators_option );
        }
        else if(role.equals("Guests")) {
            role_option = getElement(driver, Guest_option);
        }

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", role_option);
    }


    public static void select_vendor(String vendorID) {
        Select vendor = new Select(Manager_of_vendor);

        if(vendorID.equals("Vendor 1")) {
            vendor.selectByVisibleText("Vendor 1");
        }
        else if(vendorID.equals("Vendor 2")) {
            vendor.selectByVisibleText("Vendor 2");
        }


    }

    public static void activeChbx_status() {
        boolean status = Active_chbox.isSelected();
        System.out.println("Active staus is" + status);
    }

    public static void AddAdmin_comments(String string) {
        enterText(Admin_comment, string);
    }

    public static void click_save() {
        clickOn(save_button);
    }

    public static void click_onLogout(){
        clickOn(logout_link);

    }

}
