package gitHubTest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryPage extends BasePage{
    By codeButton = By.xpath("//div[@class='Layout-main']//span[@class ='Button-label']");
    By issueTab = By.id("issues-tab");
    private final static String PAGETITLE = "Repository Page";
    public RepositoryPage(WebDriver driver) {
        super(driver,PAGETITLE);
    }
    public boolean isPageOpened () {
        return driver.findElement(codeButton).isDisplayed();
    }
    public IssuePage goToIssuePage (){
        Assertions.assertTrue(driver.findElement(issueTab).isDisplayed());
        driver.findElement(issueTab).click();
        return new IssuePage(driver);
    }
}
