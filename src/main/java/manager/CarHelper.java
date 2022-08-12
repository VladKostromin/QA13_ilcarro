package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase {
    public CarHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void openCarForm() {
        click(By.id("1"));
    }

    public boolean isCarFormPresent() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2"), "some details"));
    }

    public void typeLocation(String text) {
        type(By.xpath("//input[@id='pickUpPlace']"), text);
        click(By.xpath("//div[@class='pac-item'][1]"));
    }

    public void select(By locator, String option) {
        new Select(webDriver.findElement(locator)).selectByValue(option);
    }

    public void fillCarForm(Car car) {
        if(isCarFormPresent()) {
            typeLocation(car.getAddress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());
            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());
            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getClasS());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNumber());
            type(By.id("price"), car.getDistanceInclude());
            type(By.id("distance"), car.getFuelConsumption());
            type(By.xpath("//input[@class='feature-input ng-star-inserted']"), car.getTypeFeature());
            type(By.id("about"), car.getAbout());
        }
    }

    public void attachPhoto() {
        webDriver.findElement(By.id("photos")).sendKeys("/Users/user/Tools/WhatsApp Image 2022-06-20 at 11.51.49.jpeg");
    }
}
