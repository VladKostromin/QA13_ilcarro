package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
     EventFiringWebDriver webDriver;
     String url = "https://ilcarro-1578153671498.web.app/search";
     UserHelper user;
     CarHelper car;
     String browser;
     Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    public void inti() {
        webDriver = new EventFiringWebDriver(new ChromeDriver());
        webDriver.register(new MyListener());
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user = new UserHelper(webDriver);
        car = new CarHelper(webDriver);
    }

    public void stop() {
        webDriver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public CarHelper getCar() {
        return car;
    }
}
