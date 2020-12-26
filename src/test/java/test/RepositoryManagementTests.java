package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

import java.util.Random;

public class RepositoryManagementTests extends CommonConditions{

    protected static final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
    protected static final String REPOSITORY_DESCRIPTION = "auto-generated test repo";
    private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    @Test(priority = 1)
    public void oneCanCreateProject(){
        String expectedRepositoryName = generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        String createdRepositoryName = new LoginPage(driver)
                .openPage()
                .login(USER_NAME, USER_PASSWORD)
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
                .login(USER_NAME, USER_PASSWORD)
                .openPage()
                .createNewRepository(testRepositoryName, REPOSITORY_DESCRIPTION)
                .isCurrentRepositoryEmpty();

        Assert.assertTrue(isCurrentRepositoryEmpty, "newly created repository is not empty");
    }

    private String getRandomString(int stringLength)
    {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++)
        {
            stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }

    private String generateRandomRepositoryNameWithPostfixLength(int postfixLength){
        return "testRepo_".concat(getRandomString(postfixLength));
    }
}

