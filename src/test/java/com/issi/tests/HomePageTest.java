package com.issi.tests;

import com.issi.Base.BaseClass;
import com.issi.pageFactory.HomePage;
import org.testng.annotations.Test;
import static com.issi.pageFactory.HomePage.*;

public class HomePageTest extends BaseClass {
    @Test
    public void homePageTest(){
        hmpg = new HomePage(driver);




    }

}
