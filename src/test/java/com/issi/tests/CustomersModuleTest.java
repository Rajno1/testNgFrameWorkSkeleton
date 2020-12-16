package com.issi.tests;

import com.issi.Base.BaseClass;
import com.issi.pageFactory.CustomresModule;
import org.testng.annotations.Test;
import static com.issi.pageFactory.CustomresModule.*;

public class CustomersModuleTest extends BaseClass {
    @Test
    public void addNewCustomer() throws InterruptedException {
        cm = new CustomresModule(driver);
        clickOnCustomersMenu();
        clickOnCustomerMenuItem();
        clickOnAddNew();
        enterEmail();
        enterPassword();
        enterFristName();
        enterLastName();
        selectGender();
        enterDOB();
        enterCompanyName();
        clickOnIstaxEmpty();
        cickOnNewsLetter();
        selectCustomerRole();
        selectVendor();
        activeChbxStatus();
        addAdminComments();
        clickOnSaveBtn();


    }

}
