package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import service.UserCreator;

import java.util.Random;

import static util.StringUtils.generateRandomRepositoryNameWithPostfixLength;

public class RepositoryManagementTests extends CommonConditions{

    protected static final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
    protected static final String REPOSITORY_DESCRIPTION = "auto-generated test repo";


    @Test(priority = 1)
    public void oneCanCreateProject(){
        String expectedRepositoryName = generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        String createdRepositoryName = new LoginPage(driver)
                .openPage()
                .login(UserCreator.withCredentialsFromProperty())
                .openPage()
                .createNewRepository(expectedRepositoryName, REPOSITORY_DESCRIPTION)
                .getCurrentRepositoryName();

        Assert.assertEquals(createdRepositoryName,expectedRepositoryName);

    }

    @Test(priority = 2)
    public void newProjectsAreEmpty()
    {
        String testRepositoryName = generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        boolean isCurrentRepositoryEmpty = new LoginPage(driver)
                .openPage()
                .login(UserCreator.withCredentialsFromProperty())
                .openPage()
                .createNewRepository(testRepositoryName, REPOSITORY_DESCRIPTION)
                .isCurrentRepositoryEmpty();

        Assert.assertTrue(isCurrentRepositoryEmpty, "newly created repository is not empty");
    }


}

