package gitHubTest;

import helpers.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.logColorPrinter.printColorMessage;
import static org.testng.Assert.assertTrue;

public class ProfileForm extends BasePage{
    By signOutLocator = By.xpath("//span[contains(text(), 'Sign out')]/parent::a");
    By profileLogoLocator = By.className("avatar circle");
    By yourRepositButtonLocator = By.xpath("//span[contains(text(), \"Your repositories\")]/parent::a");
    private final static String PAGETITLE = "Profile Form Page";

    public ProfileForm(WebDriver driver) {
        super(driver, PAGETITLE);
    }

    public SignOutPage signOutFromGitHub() {
       assertTrue(driver.findElement(signOutLocator).isDisplayed());
        driver.findElement(signOutLocator).click();
        printColorMessage("The user is sign out", logger, Level.DEBUG);
        return new SignOutPage(driver);
    }

    public RepositoriesPage goToRepositoriesPage() {
        assertTrue(driver.findElement(yourRepositButtonLocator).isDisplayed());
        driver.findElement(yourRepositButtonLocator).click();
        printColorMessage("The user is navigate to the Repositories page", logger, Level.DEBUG);
        return new RepositoriesPage(driver);
    }



}
