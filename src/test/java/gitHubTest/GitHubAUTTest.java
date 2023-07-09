package gitHubTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GitHubAUTTest extends BaseTest{
    @Test
    public void goToIssiePageTest () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        MainPage mainPage = loginPage.loginSuccessful("o-yelkoff", "autTest123!");
        RepositoryPage repositoryPage = mainPage.goToRepositoryPage();
        Assertions.assertTrue(repositoryPage.isPageOpened());
        IssuePage issuePage = repositoryPage.goToIssuePage();
        Assertions.assertTrue(issuePage.isPageOpened());
        Thread.sleep(5000);

    }

}
