package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void preCondition() {
        if(app.getUser().isLogged()) {
            app.getUser().logout();
        } else if(app.getUser().isElementPresent(By.xpath("//input"))) {
            app.getUser().clearInputs();
        }
    }


    @BeforeSuite
    public void appSetup() {
        app.inti();
    }


    @AfterSuite
    public void tearDown() {
//        app.stop();
    }
}
