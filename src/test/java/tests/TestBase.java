package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    ApplicationManager app = new ApplicationManager();


    @BeforeSuite
    public void appSetup() {
        app.inti();
    }


    @AfterSuite
    public void tearDown() {
//        app.stop();
    }
}
