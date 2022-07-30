package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
    public void fillLoginForm(User data) {
        type(By.id("email"), data.getEmail());
        type(By.id("password"), data.getPassword());
    }

    public void submitLogin() {
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public boolean isLogged() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[.=' Logout ']"))));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))) {
            webDriver.findElement(By.xpath("//button[text()='Ok']")).click();
        }
    }

    public boolean isElementPresent(By locator) {
        return webDriver.findElement(locator).isDisplayed();
    }

    public void logout() {
        webDriver.findElement(By.xpath("//a[.=' Logout ']")).click();
    }

    public void clearInputs() {
        List<WebElement> elements = webDriver.findElements(By.xpath("//input"));
        for (WebElement e : elements) {
            e.clear();
        }
    }

    public void backSpace(By locator) {
        webDriver.findElement(locator).sendKeys(Keys.BACK_SPACE);
    }
}
