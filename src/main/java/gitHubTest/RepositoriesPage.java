package gitHubTest;

import helpers.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

import static helpers.logColorPrinter.printColorMessage;

public class RepositoriesPage extends BasePage{
    List<WebElement> repositoriesList = driver.findElements(By.xpath("//a[@itemprop=\"name codeRepository\"]"));
    private final static String PAGETITLE = "Repositories Page";
    public RepositoriesPage(WebDriver driver) {
        super(driver, PAGETITLE);
    }

    public List<String> getRepositories() {
        List<String> repositList = repositoriesList.stream().map(rep -> rep.getText()).collect(Collectors.toList());
        printColorMessage("The user get Repositories quantity", logger, Level.DEBUG);
        return repositList;
    }
}
