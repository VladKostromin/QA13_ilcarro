package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationPositiveTest() {
        Random random = new Random();
        int i = random.nextInt(999);
        User user = new User().withName("John")
                .withLastname("Doe")
                .withEmail("john" + i + "@gmail.com")
                .withPassword("$Doe12345");
        logger.info("RegPosTest starts with: " + user.toString());
        app.getUser().signUp();
        app.getUser().fillRegistrationForm(user);
        app.getUser().checkPolicy();
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isRegistered());
    }

    @Test
    public void registrationNegativeTest() {
        Random random = new Random();
        int i = random.nextInt(999);
        User user = new User().withName("John")
                .withLastname("Doe")
                .withEmail("john" + i + "@gmail.com")
                .withPassword("doe12345");
        logger.info("RegNegTest starts with: " + user.toString());
        app.getUser().signUp();
        app.getUser().fillRegistrationForm(user);
        app.getUser().checkPolicy();
//        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isRegistered());
    }
}
