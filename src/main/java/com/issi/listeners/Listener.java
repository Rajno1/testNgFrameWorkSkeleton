package com.issi.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.issi.Base.BaseClass;
import com.issi.constants.FrameworkConstants;
import com.issi.report.ExtentReport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Listener extends BaseClass implements ITestListener {


    public String getBase64(){
        /*
        we are using Base64 string image because, we can see the image with out
        any need of external files.
        */
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

    }
//    public String getScreenshotAsBase64() throws IOException {
//        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String path = System.getProperty("user.dir")+"./Screenshots/image.png";
//        FileUtils.copyFile(source,new File(path));
//        /**
//         * in above line we have captured the screenshotpath
//         * now we are converting screenshot from image to Base64
//         * 1.convert the path into byte[]
//         * 2.convering byter[] in string where we can directly return
//         * now it will return 'Base64 string' not png file
//         */
//        byte[] imagebytes = IOUtils.toByteArray(new FileInputStream(path));
//        return Base64.getEncoder().encodeToString(imagebytes);
//    }

    @Override
    public void onTestStart(ITestResult result) {
      test = extent.createTest(result.getMethod().getMethodName(),
               " "+result.getMethod().getMethodName()+" : Testcase has been initiated successfully")
               .assignAuthor("Rajasekhar").assignCategory("Functional").assignDevice("chrome");;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,MarkupHelper.createLabel(""+result.getMethod().getMethodName()+" : Test is successful", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,MarkupHelper.createLabel(""+result.getMethod().getMethodName()+" : Test was failed miserably", ExtentColor.RED));
        test.log(Status.FAIL,result.getThrowable());
        test.log(Status.FAIL,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64(),"Screen shot on Filure").build());
        // adding screenshot for failed test case
        // test.addScreenCaptureFromPath(getBase64(),"Screen shot on Test Failure");
    //  test.pass("Screen shot on Test Failure", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());


//        try {
//                extent.flush();
//                Desktop.getDesktop().browse(new File(FrameworkConstants.getFailedSparkOutput()).toURI());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,MarkupHelper.createLabel(""+result.getMethod().getMethodName()+" : Test was skipped", ExtentColor.AMBER));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        // initiating Extent Report
        extent = ExtentReport.initReport();
        test = extent.createTest("initiated login","login functionality has been initiate");
    }

    @Override
    public void onFinish(ITestContext context) {
        // After test execution
        try {
            extent.flush();
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentSparkOutputPath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
