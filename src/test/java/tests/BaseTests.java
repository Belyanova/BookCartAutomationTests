package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import steps.GeneralSteps;
import utils.DriverFactory;
import utils.PropertyReader;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PropertyReader.getURL());
        generalSteps = new GeneralSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
