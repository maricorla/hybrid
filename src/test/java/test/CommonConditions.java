package test;

import driver.DriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import util.TestListener;

import java.util.concurrent.TimeUnit;
@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected static final String USER_NAME = "maricorla";
    protected static final String USER_PASSWORD = "Corlatti2005377";

    @BeforeSuite
    public void setEnv(){
        System.setProperty("environment", "dev");
        System.out.println("faccio partire env " + System.getProperty("environment") );
    }

    @BeforeMethod
    public void setup() {
        driver = DriverSingleton.getDriver();

    }
    @AfterMethod
    public void teardown() {
        DriverSingleton.closeDriver();
    }
}
