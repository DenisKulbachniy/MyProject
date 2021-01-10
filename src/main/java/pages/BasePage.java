package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseURI = "https://rozetka.com.ua/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(baseURI);
    }
}
