package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import service.UserCreator;

public class UserAccessTests extends CommonConditions{


    @Test
    public void oneCanLoginGit() {
        User testUser = UserCreator.withEmptyPassword();
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .getLoggedInIserName();

        Assert.assertEquals(loggedInUserName,testUser.getUsername());

    }
}
