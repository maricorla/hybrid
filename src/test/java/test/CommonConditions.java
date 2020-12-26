package test;

import driver.DriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CommonConditions {
    protected WebDriver driver;
    protected static final String USER_NAME = "maricorla";
    protected static final String USER_PASSWORD = "Corlatti2005377";

    @BeforeMethod
    public void setup() {
        driver = DriverSingleton.getDriver();

    }
    @AfterMethod
    public void teardown() {
        DriverSingleton.closeDriver();
    }
}
