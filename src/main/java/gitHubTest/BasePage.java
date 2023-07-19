package gitHubTest;

import helpers.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.logColorPrinter.printColorMessage;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Logger logger;
    private String pageTitle;

    public BasePage (WebDriver driver, String pageTitle) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 3);
        this.pageTitle = pageTitle;
        this.logger = LogManager.getLogger(this.pageTitle);
        printColorMessage("Page object of " + pageTitle +this.getClass().getName(),logger, Level.DEBUG);
    }
}
