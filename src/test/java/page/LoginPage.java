package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private final String PAGE_URL = "https://github.com/login";

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement buttonSignin;


    public LoginPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public MainPage login(String username, String password){
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSignin.click();
        return new MainPage(driver);
    }


}
