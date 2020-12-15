package com.issi.constants;

public class FrameworkConstants {
    /*
        private oonstructor got created for not to create an object for this class
     */
    private FrameworkConstants() {

    }
    /*
    we are not going to change the path of driver executables its fixed
    so we stored their path in a string and made it as private and final
    and private variables we can create a getter method an can access through it
    so created getter method for it.
     */

    private static final String url = "https://admin-demo.nopcommerce.com/login";
    private static final String excelTestDataPath = System.getProperty("user.dir") + "/src/test/resources/TestData/TestDataFile.xlsx";
    private static final String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/DriverExecutables/chromedriver.exe";
    private static final String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/DriverExecutables/geckodriver";
    private static final String ieDriverPath = System.getProperty("user.dir") + "/src/test/resources/DriverExecutables/IEDriverServer";

    private static final String extentSparkOutputPath = System.getProperty("user.dir") + "/TestOutput/index.html";
    private static final String extenSparkFailedOutputPath = "TestOutput/test_failure-index.html";
    private static final String sparkConfigFilePath = System.getProperty("user.dir") + "/src/main/resources/spark-config.xml";

    public static final long time = 30;
    public static String getUrl() {
        return url;
    }

    public static String getExcelTestDataPath() {
        return excelTestDataPath;
    }

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getFirefoxDriverPath() {
        return firefoxDriverPath;
    }

    public static String getIEDriverPath() {
        return ieDriverPath;
    }

    public static String getSparkConfigFilePath() {
        return sparkConfigFilePath;
    }

    public static String getExtentSparkOutputPath() {
        return extentSparkOutputPath;
    }

    public static String getFailedSparkOutput() {
        return extenSparkFailedOutputPath;
    }


}
