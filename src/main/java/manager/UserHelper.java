package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))) {
            webDriver.findElement(By.xpath("//button[text()='Ok']")).click();
        }
    }

    public void login(User user) {

        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();
        pause(1000);

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

    public void signUp() {
        webDriver.findElement(By.xpath("//*[text()=' Sign up ']")).click();
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastname());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
//        WebElement element = webDriver.findElement(By.xpath("//input[@id='terms-of-use']"));
//        Actions a = new Actions(webDriver);
//        a.moveToElement(element).click().build().perform();

    }

    public void fillRegistrationFormWithJsScript(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastname());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public boolean isRegistered() {
        WebElement element = new WebDriverWait(webDriver, 20)
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//div[@class='dialog-container']"))));
        return element.getText().contains("Registered");
    }

    public void cityDateInput(String city, String date) {
        type(By.cssSelector("input#city"), city);
        WebElement element = webDriver.findElement(By.cssSelector("input#city"));
        webDriver.findElements(By.xpath("//div[@class='pac-item']")).get(0).click();
        element.click();
        webDriver.findElement(By.cssSelector("input#dates")).sendKeys(date);
    }
    public void yallaButton() {
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
    }

    public void cityDateInputWithDatePicker(String city, String dateFrom, String dateTo) {
        type(By.cssSelector("input#city"), city);
        WebElement element = webDriver.findElement(By.cssSelector("input#city"));
        webDriver.findElements(By.xpath("//div[@class='pac-item']")).get(0).click();
        element.click();

        webDriver.findElement(By.cssSelector("input#dates")).click();
        String[] splitter = dateFrom.split(" ");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Integer.parseInt(splitter[1]) - 1);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLLL", Locale.ENGLISH);
        String monthFrom = dateFormat.format(date);

        webDriver.findElement(By.id("dates"));
        click(By.xpath("//button[@aria-label='Choose month and year']"));
        click(By.xpath("//*[.=' " + splitter[2] + " ']"));
        click(By.xpath("//*[starts-with(@aria-label, '" + monthFrom + "')]"));
        click(By.xpath("//*[.=' " + splitter[0] + " ']"));

        splitter = dateTo.split(" ");
        calendar.set(Calendar.MONTH, Integer.parseInt(splitter[1]) - 1);
        date = calendar.getTime();
        String monthTo = dateFormat.format(date);

        click(By.xpath("//button[@aria-label='Choose month and year']"));
        click(By.xpath("//*[.=' " + splitter[2] + " ']"));
        click(By.xpath("//*[starts-with(@aria-label, '" + monthTo + "')]"));
        click(By.xpath("//*[.=' " + splitter[0] + " ']"));
    }
}
