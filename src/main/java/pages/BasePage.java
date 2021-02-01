package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public void openHomePage() {
        driver.get(Constants.BASEURI);
    }
}
