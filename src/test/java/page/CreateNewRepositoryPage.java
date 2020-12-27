package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateNewRepositoryPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "repository_name")
    private WebElement inputRepositoryName;

    @FindBy(id = "repository_description")
    private WebElement inputRepositoryDescription;

    public CreateNewRepositoryPage(WebDriver driver) {
        super(driver);
    }

    public NewRepositoryPage createNewRepository(String repositoryName, String repositoryDescription)
    {
        inputRepositoryName.sendKeys(repositoryName);
        inputRepositoryDescription.sendKeys(repositoryDescription);
        WebElement buttonCreate = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary first-in-line']")));
        buttonCreate.click();
        logger.info("Created repository with name: [" + repositoryName +"[ and description: ["
         + repositoryDescription+ "]");
        return new NewRepositoryPage(driver);
    }


}
