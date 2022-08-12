package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    public boolean isElementPresent(By locator) {
        return webDriver.findElement(locator).isDisplayed();
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void submitForm() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).submit();
    }

    public void checkPolicy() {
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        js.executeScript("document.querySelector('#terms-of-use').click()\n");

        Actions actions = new Actions(webDriver);
        WebElement container = webDriver.findElement(By.className("checkbox-container"));
        Rectangle rectangle = container.getRect();
        int x = rectangle.getX() + 5;
        int y = rectangle.getY() + rectangle.getHeight() * 1/4;
        actions.moveByOffset(x, y).click().perform();

    }
}
