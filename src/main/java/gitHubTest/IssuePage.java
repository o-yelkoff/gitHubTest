package gitHubTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuePage extends BasePage{
    By newIssueButton = By.xpath("//*[@id='repo-content-turbo-frame']//a[contains( @href, 'issues/new/choose')]");
    public IssuePage (WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened (){
        return driver.findElement(newIssueButton).isDisplayed();
    }

}
