package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

     WebDriver webDriver;
     String url = "https://ilcarro-1578153671498.web.app/search";
     UserHelper user;

    public void inti() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user = new UserHelper(webDriver);
    }

    public void stop() {
        webDriver.quit();
    }

    public UserHelper getUser() {
        return user;
    }
}
