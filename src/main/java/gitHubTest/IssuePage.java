package gitHubTest;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class IssuePage extends BasePage{
    By newIssueButton = By.xpath("//*[@id='repo-content-turbo-frame']//a[contains( @href, 'issues/new/choose')]");
    By issueList = By.xpath("//div[@class= 'js-navigation-container js-active-navigation-container']");
    By searchField = By.xpath("//input[@id = 'js-issues-search']");

    public IssuePage (WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened (){
        webDriverWait.until(elementToBeClickable(driver.findElement(newIssueButton)));
        return driver.findElement(newIssueButton).isDisplayed();
    }
    public IssueCreatePage goToIssueCreatePage() {
        webDriverWait.until(elementToBeClickable(driver.findElement(newIssueButton)));
        driver.findElement(newIssueButton).click();
        return new IssueCreatePage(driver);
    }
    public int getIssueAmount (String s) throws InterruptedException {
        driver.findElement(searchField).isDisplayed();
        driver.findElement(searchField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(searchField).sendKeys(Keys.DELETE);
        driver.findElement(searchField).sendKeys(s);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        WebElement element = driver.findElement(issueList);
        List<WebElement> elements = element.findElements(By.xpath("./*"));

        int size = elements.size();
        System.out.println("Amount of issues = " + size);
        return size;
    }
}
