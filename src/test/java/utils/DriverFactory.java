package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverFactory {
    private static WebDriver driver;
    private final static String DRIVER_PATH = "src/test/resources/";

    public static WebDriver getDriver(Browser browser) {
        File file;
        switch (browser){
            case CHROME:
                file = new File(DRIVER_PATH + "chromedriver");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                file = new File(DRIVER_PATH + "geckodriver");
                System.setProperty("webdriver.firefox.driver", file.getAbsolutePath());
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
