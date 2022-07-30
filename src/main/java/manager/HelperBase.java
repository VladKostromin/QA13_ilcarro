package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver webDriver;

    public HelperBase(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void type(By locator, String text) {
        if(text != null) {
            WebElement e = webDriver.findElement(locator);
            e.click();
            e.clear();
            e.sendKeys(text);
        }
    }
    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        webDriver.findElement(locator).click();
    }
}
