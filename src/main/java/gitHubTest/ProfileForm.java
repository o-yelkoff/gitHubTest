package gitHubTest;

import helpers.Level;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.logColorPrinter.printColorMessage;

public class ProfileForm extends BasePage{
    By signOutLocator = By.xpath("//span[contains(text(), 'Sign out')]/parent::a");
    By profileLogoLocator = By.className("avatar circle");
    By yourRepositButtonLocator = By.xpath("//span[contains(text(), \"Your repositories\")]/parent::a");
    private final static String PAGETITLE = "Profile Form Page";

    public ProfileForm(WebDriver driver) {
        super(driver, PAGETITLE);
    }

    public SignOutPage signOutFromGitHub() {
        Assertions.assertTrue(driver.findElement(signOutLocator).isDisplayed());
        driver.findElement(signOutLocator).click();
        printColorMessage("The user is sign out", logger, Level.DEBUG);
        return new SignOutPage(driver);
    }

    public RepositoriesPage goToRepositoriesPage() {
        Assertions.assertTrue(driver.findElement(yourRepositButtonLocator).isDisplayed());
        driver.findElement(yourRepositButtonLocator).click();
        printColorMessage("The user is on the Repositories page", logger, Level.DEBUG);
        return new RepositoriesPage(driver);
    }



}
