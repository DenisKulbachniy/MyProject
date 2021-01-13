package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;
    private final String BASEURI = "https://rozetka.com.ua/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(BASEURI);
    }
}
