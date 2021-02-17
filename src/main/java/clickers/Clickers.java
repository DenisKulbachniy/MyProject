package clickers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waiters.Waiter;

public class Clickers extends Waiter {
    Waiter wait;

    public Clickers(WebDriver driver) {
        super(driver);
    }

    public void clickButtonWithStaleReferenceElementException(WebElement element) {
        staleReferenceElementExceptionCatchWaitClick(element);
        element.click();
    }
}