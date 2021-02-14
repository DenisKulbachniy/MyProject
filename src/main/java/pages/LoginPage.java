package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = ".//input[@id='auth_email']")
    public WebElement loginField;

    @FindBy(xpath = ".//input[@id='auth_pass']")
    public WebElement passwordField;

    @FindBy(xpath = ".//rz-user/button[contains(@class, 'header__button')]")
    public WebElement enterToAccountLink;

    @FindBy(xpath = ".//p[contains(@class, 'user-name')]")
    public WebElement userLink;

    @FindBy(xpath = ".//button[contains(text(),'Войти')]")
    public WebElement enterButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}


