package gitHubTest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        Assertions.assertTrue(driver.findElement(imgLocator).isDisplayed());
        driver.findElement(imgLocator).click();
        return new ProfileForm(driver);
    }
    public  RepositoryPage goToRepositoryPage(){
        //Assertions.assertTrue(driver.findElement(qaAutoLocator).isDisplayed());
        driver.findElement(qaAutoLocator).click();
        return  new RepositoryPage(driver);
    }
}
