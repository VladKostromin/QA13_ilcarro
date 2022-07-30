package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPositiveTest extends TestBase {

    @Test
    public void loginPositiveTestModel() {
        User data = new User().withEmail("1234@gmail.com").withPassword("Qaz923923");
        app.getUser().initLogin();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        app.getUser().clickOkButton();
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void loginPositiveTestString() {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("1234@gmail.com", "Qaz923923");
        app.getUser().submitLogin();
        app.getUser().clickOkButton();
        Assert.assertTrue(app.getUser().isLogged());
    }
}
