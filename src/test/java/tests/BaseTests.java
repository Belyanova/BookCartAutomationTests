package tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;
import steps.GeneralSteps;
import utils.DriverFactory;
import utils.PropertyReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class BaseTests {
    private static WebDriver driver;
    GeneralSteps generalSteps;
    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(PropertyReader.getURL());
        generalSteps = new GeneralSteps();
    }

    @AfterMethod
    public void afterTestMethod(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenShotOnFailure(testResult);
            restartBrowserIfTestFailure(testResult);
        }
    }

    private void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotName = "errorScreenshots/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg";
            FileUtils.copyFile(scrFile, new File("./target/" + screenshotName));
            InputStream is = new FileInputStream("./target/" + screenshotName);
            Allure.addAttachment("Screenshot", is);
        }
    }

    private void restartBrowserIfTestFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            tearDown();
            setUp();}
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
