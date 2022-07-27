package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void initLogin() {
        webDriver.findElement(By.xpath("//a[text()=' Log in ']")).click();
    }
    public void fillLoginForm(String email, String password) {
       type(By.id("email"), email);
       type(By.id("password"), password);
    }
    public void submitLogin() {
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public boolean isLogged() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//h1[text()='Logged in']"))));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
