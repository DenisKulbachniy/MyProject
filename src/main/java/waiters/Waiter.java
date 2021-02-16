package waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiter {
    private final WebDriverWait webDriverWait;

    public Waiter(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 15);
    }

    public WebElement untilVisible(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visibilityOfAllElementsForListOfWebElements(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}

