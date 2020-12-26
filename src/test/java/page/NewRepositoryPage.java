package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRepositoryPage extends AbstractPage {

    @FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
    private WebElement linkCurrentRepository;

    private final By labelEmptyRepoSetupOptionLocator = By.xpath("//h3/strong[text()='Quick setup']");



    public String getCurrentRepositoryName()
    {
        return linkCurrentRepository.getText();
    }

    public NewRepositoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCurrentRepositoryEmpty()
    {
        WebElement labelEmptyRepoSetupOption = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(labelEmptyRepoSetupOptionLocator));
        return labelEmptyRepoSetupOption.isDisplayed();
    }


}
