package gitHubTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class IssueDeletePage extends BasePage {
    public By closeIssueButton = By.xpath("//button[@name = 'comment_and_close']");
    public By deleteIssueButton = By.xpath("//div[@id = 'partial-discussion-sidebar']//summary[@class = 'd-inline-block']");
    public By deletePopUpButton = By.xpath("//div[@class = 'Box-body p-3 text-center']//button[@name = 'verify_delete']");
    private final static String PAGETITLE = "Issue Delete Page";
    public IssueDeletePage(WebDriver driver) {
        super(driver,PAGETITLE);
    }
    public boolean issueDeletePageIsOpened() {
        webDriverWait.until(elementToBeClickable(driver.findElement(closeIssueButton)));
        return driver.findElement(closeIssueButton).isDisplayed();
    }
    public IssueCreatePage deletingIssue(){
        driver.findElement(deleteIssueButton).click();
        driver.findElement(deletePopUpButton).click();
        return new IssueCreatePage(driver);
    }

}
