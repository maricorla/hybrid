package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends page.AbstractPage {
    @FindBy(xpath = "//a[@class='btn btn-sm btn-primary text-white']")
    private WebElement inputLogin;

    private final By linkLoggedInUserLocator = By.xpath("//meta[@name='user-login']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewRepositoryPage openPage(){
        inputLogin.click();
        return  new CreateNewRepositoryPage(driver);
    }
    public String getLoggedInIserName(){
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
        return linkLoggedInUser.getAttribute("content");
    }



}

