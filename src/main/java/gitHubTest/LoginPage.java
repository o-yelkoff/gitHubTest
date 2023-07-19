package gitHubTest;

import helpers.Level;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.logColorPrinter.printColorMessage;

public class LoginPage extends BasePage{
    private By logoLocator = By.className("header-logo");
    private By loginFieldLocator = By.id("login_field");
    private By passwordFieldLocator = By.id("password");
    private By signInButtonLocator = By.xpath("//input[@value=\"Sign in\"]");
    private By errorTextLocator = By.xpath("//div[contains(text(), 'Incorrect username or password.')]");
    private final static String PAGETITLE = "Login Page";

    public LoginPage(WebDriver driver) {
        super(driver, PAGETITLE);
    }

    public WebElement getLogo() {
        return driver.findElement(logoLocator);
    }

    public LoginPage validateErrorMessage(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, driver.findElement(errorTextLocator).getText());
        return this;
    }

    public MainPage loginSuccessful(String login, String password) {
        driver.findElement(loginFieldLocator).sendKeys(login);
        driver.findElement(passwordFieldLocator).sendKeys(password);
        driver.findElement(signInButtonLocator).click();
        logger.info("Successful authorization");
        printColorMessage("User successfully  log in", logger, Level.DEBUG);
        return new MainPage(driver);
    }

    public LoginPage loginFailed(String login, String password) {
        driver.findElement(loginFieldLocator).sendKeys(login);
        driver.findElement(passwordFieldLocator).sendKeys(password);
        driver.findElement(signInButtonLocator).click();
        printColorMessage("User successfully  log out", logger, Level.DEBUG);
        return this;
    }
}
