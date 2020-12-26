package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewRepositoryPage extends AbstractPage {

    @FindBy(id = "repository_name")
    private WebElement inputRepositoryName;

    @FindBy(id = "repository_description")
    private WebElement inputRepositoryDescription;

    @FindBy(id = "repository_visibility_private")
    private WebElement checkboxPrivate;


    public CreateNewRepositoryPage(WebDriver driver) {
        super(driver);
    }

    public NewRepositoryPage createNewRepository(String repositoryName, String repositoryDescription)
    {
        inputRepositoryName.sendKeys(repositoryName);
        inputRepositoryDescription.sendKeys(repositoryDescription);
        checkboxPrivate.click();
        WebElement buttonCreate = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary first-in-line']")));
        buttonCreate.click();
        return new NewRepositoryPage(driver);
    }


}
