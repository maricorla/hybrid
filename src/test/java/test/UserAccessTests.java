package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

public class UserAccessTests extends CommonConditions{


    @Test
    public void oneCanLoginGit() {
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(USER_NAME, USER_PASSWORD)
                .getLoggedInIserName();

        Assert.assertEquals(loggedInUserName,USER_NAME);

    }
}
