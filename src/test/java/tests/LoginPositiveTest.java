package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPositiveTest extends TestBase {

    @Test
    public void loginPositiveTest() {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("1234@gmail.com", "Qaz923923");
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
    }
}
