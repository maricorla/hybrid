package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private final String PAGE_URL = "https://github.com/login";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement buttonSignin;


    public LoginPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Login page open");
        return this;
    }

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public MainPage login(User user){
        inputLogin.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        buttonSignin.click();
        logger.info("Login performed");
        return new MainPage(driver);
    }


}
