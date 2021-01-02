package test;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import page.LoginPage;
import page.NewRepositoryPage;
import service.UserCreator;

import java.util.Random;

import static util.StringUtils.generateRandomRepositoryNameWithPostfixLength;

public class RepositoryManagementTests extends CommonConditions{

    protected static final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
    protected static final String REPOSITORY_DESCRIPTION = "auto-generated test repo";
    NewRepositoryPage repopage;
    String expectedRepositoryName;

    @BeforeGroups("New_page")
    public void createRepository(){
        expectedRepositoryName = generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        repopage= new LoginPage(driver)
                .openPage()
                .login(UserCreator.withCredentialsFromProperty())
                .openPage()
                .createNewRepository(expectedRepositoryName, REPOSITORY_DESCRIPTION);
    }

    @Test(groups={"New_page"})
    public void oneCanCreateProject(){
        String createdRepositoryName= repopage.getCurrentRepositoryName();
        Assert.assertEquals(createdRepositoryName,expectedRepositoryName);

    }

    @Test(groups={"New_page"})
    public void newProjectsAreEmpty()
    {
        boolean isCurrentRepositoryEmpty = repopage.isCurrentRepositoryEmpty();
        Assert.assertTrue(isCurrentRepositoryEmpty, "newly created repository is not empty");
    }


}

