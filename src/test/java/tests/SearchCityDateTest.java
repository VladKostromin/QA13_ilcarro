package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCityDateTest extends TestBase {

    @Test
    public void rowDatePicker() {
        app.getUser().cityDateInput("Tel-Aviv", "8/28/2022 - 8/31/2022");
        app.getUser().yallaButton();
    }

    @Test
    public void datePickerUsingDateThisMonth() {
        app.getUser().cityDateInputWithDatePicker("Tel-Aviv","28 8 2022","31 8 2022");
        app.getUser().yallaButton();
    }



}
