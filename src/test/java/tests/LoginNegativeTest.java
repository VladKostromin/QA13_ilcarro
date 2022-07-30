package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTest extends TestBase{

    @Test
    public void emailWrongFormatNegativeTest() {
        User data = new User().withEmail("1234$gmail.com").withPassword("Qaz923923");
        app.getUser().initLogin();
        app.getUser().fillLoginForm(data);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()=\"It'snot look like email\"]")));
    }

    @Test
    public void emailIsRequiredNegativeTest() {
        User data = new User().withEmail("").withPassword("Qaz923923");
        app.getUser().initLogin();
        app.getUser().fillLoginForm(data);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()=' Email is required ']")));
    }


    @Test
    public void passwordIsRequiredNegativeTest() {
        User data = new User().withEmail("1234@gmail.com").withPassword(" ");
        app.getUser().initLogin();
        app.getUser().fillLoginForm(data);
        app.getUser().backSpace(By.id("password"));
        app.getUser().click(By.id("email"));
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()=' Password is required ']")));
    }
}
