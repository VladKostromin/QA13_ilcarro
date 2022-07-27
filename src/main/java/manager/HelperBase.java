package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
