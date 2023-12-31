package gitHubTest;

import helpers.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.logColorPrinter.printColorMessage;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage{
    private By signInButtonLocator = By.xpath("//a[contains(text(), \"Sign in\")]");
    private final static String PAGETITLE = "Home page";

    public HomePage(WebDriver driver) {
        super(driver, PAGETITLE);
    }

    public LoginPage goToLoginPage() {
        webDriverWait.until(elementToBeClickable(driver.findElement(signInButtonLocator)));
        driver.findElement(signInButtonLocator).click();
        printColorMessage("User is on Login page", logger, Level.DEBUG);
        return new LoginPage(driver);
    }
}
