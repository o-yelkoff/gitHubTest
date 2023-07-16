package gitHubTest;

import helpers.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.logColorPrinter.printColorMessage;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class IssueCreatePage extends BasePage {

    private By issueTitle = By.xpath("//div[@class = 'Layout-main']//input[@name='issue[title]']");
    public By issueComment = By.xpath("//div[@class = 'Layout-main']//textarea[@id='issue_body']");
    public By submitButton = By.xpath("//div[@class = 'Layout-main']//button[@type='submit']");
    public By closeIssueButton = By.xpath("//div[@class = 'discussion-timeline-actions']//button[@name='comment_and_close']");
    public By issueTab = By.id("issues-tab");
    public By deleteNotification = By.xpath("//div[@id = 'js-flash-container']//div[@role = 'alert']");
    private final static String PAGETITLE = "Issue Create Page";

    public IssueCreatePage(WebDriver driver) {
        super(driver, PAGETITLE);
    }

    public boolean issueCreatePageIsOpen() {
        return driver.findElement(submitButton).isDisplayed();
    }

    public IssueCreatePage createNewIssue(String title, String comment) {
        driver.findElement(issueTitle).sendKeys(title);
        driver.findElement(issueComment).sendKeys(comment);
        driver.findElement(submitButton).click();
        printColorMessage("New issue is successfully  created", logger, Level.DEBUG);
        return new IssueCreatePage(driver);
    }

    public boolean newIssueIsCreated() {
        return driver.findElement(closeIssueButton).isDisplayed();
    }

    public IssuePage goBackToIssuePage() {
        webDriverWait.until(elementToBeClickable(driver.findElement(issueTab)));
        driver.findElement(issueTab).click();
        printColorMessage("User is on the Issue page", logger, Level.DEBUG);
        return new IssuePage(driver);
    }

    public boolean issueDeletingNotification() {
        webDriverWait.until(elementToBeClickable(driver.findElement(deleteNotification)));
        return driver.findElement(deleteNotification).isDisplayed();
    }
}

