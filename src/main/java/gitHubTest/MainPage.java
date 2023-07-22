package gitHubTest;

import helpers.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.logColorPrinter.printColorMessage;
import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage{
    By imgLocator = By.xpath("//img[@class='avatar circle'][1]");
    By qaAutoLocator = By.xpath("//body//loading-context//ul//img[@alt='qa_auto']");
    private final static String PAGETITLE = "Main Page";
    public MainPage(WebDriver driver) {
        super(driver, PAGETITLE);
    }

    public WebElement getLogoOnTheMainPage() {
        return driver.findElement(imgLocator);
    }

    public ProfileForm goToProfileForm() {
        assertTrue(driver.findElement(imgLocator).isDisplayed());
        driver.findElement(imgLocator).click();
        printColorMessage("The user is on the Profile Form page", logger, Level.DEBUG);
        return new ProfileForm(driver);
    }
    public  RepositoryPage goToRepositoryPage(){
        //Assertions.assertTrue(driver.findElement(qaAutoLocator).isDisplayed());
        driver.findElement(qaAutoLocator).click();
        printColorMessage("The user is redirecting on the Repository page", logger, Level.DEBUG);
        return  new RepositoryPage(driver);
    }
}
