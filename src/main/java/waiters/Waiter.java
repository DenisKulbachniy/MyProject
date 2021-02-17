package waiters;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiter {
    private final WebDriverWait webDriverWait;
    private final FluentWait<WebDriver> fluentWait;

    public Waiter(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 5);
        fluentWait = initFluentWait(driver);
    }

    public WebElement untilVisible(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visibilityOfAllElementsForListOfWebElements(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void toBeClickableWait(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void textToBePresentInElementWaiter(WebElement element, String text) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public FluentWait<WebDriver> initFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    public void visibilityOfAllElementsFluentWait(List<WebElement> elements) {
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement elementToBeClickableWait(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public boolean staleReferenceElementExceptionCatchWaitClick(WebElement element) {
        boolean result = false;
        int attempt = 0;
        while (attempt < 5) {
            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(element));
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
        return result;
    }

    public boolean staleReferenceElementExceptionCatchForListWait(List<WebElement> elements) {
        boolean result = false;
        int attempt = 0;
        while (attempt < 5) {
            try {
                webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
        return result;
    }
}
