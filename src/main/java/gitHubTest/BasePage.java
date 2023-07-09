package gitHubTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 3);
    }
}
