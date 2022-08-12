package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

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
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        app.stop();
    }
}
