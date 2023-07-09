package gitHubTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        IssueCreatePage issueCreatePage = issuePage.goToIssueCreatePage();
        Assertions.assertTrue(issueCreatePage.issueCreatePageIsOpen());

    }
    @Test void createNewIssueTest () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        MainPage mainPage = loginPage.loginSuccessful("o-yelkoff", "autTest123!");
        RepositoryPage repositoryPage = mainPage.goToRepositoryPage();
        Assertions.assertTrue(repositoryPage.isPageOpened());
        IssuePage issuePage = repositoryPage.goToIssuePage();
        Assertions.assertTrue(issuePage.isPageOpened());
        IssueCreatePage issueCreatePage = issuePage.goToIssueCreatePage();
        String s = "GitTest " + System.currentTimeMillis();
        IssueCreatePage issueCreatePage1 = issueCreatePage.createNewIssue(s, "GitTest, my first issur create" );
        Assertions.assertTrue(issueCreatePage1.newIssueIsCreated());
        issueCreatePage.goBackToIssuePage();
        Assertions.assertTrue(issuePage.isPageOpened());
        int issueAmount = issuePage.getIssueAmount(s);
        Assertions.assertTrue(1==issueAmount);
    }
    @Test void deleteIssueTest () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        MainPage mainPage = loginPage.loginSuccessful("o-yelkoff", "autTest123!");
        RepositoryPage repositoryPage = mainPage.goToRepositoryPage();
        Assertions.assertTrue(repositoryPage.isPageOpened());
        IssuePage issuePage = repositoryPage.goToIssuePage();
        Assertions.assertTrue(issuePage.isPageOpened());
        IssueCreatePage issueCreatePage = issuePage.goToIssueCreatePage();
        String s = "GitTest " + System.currentTimeMillis();
        IssueCreatePage issueCreatePage1 = issueCreatePage.createNewIssue(s, "GitTest, my first issur create" );
        Assertions.assertTrue(issueCreatePage1.newIssueIsCreated());
        issueCreatePage.goBackToIssuePage();
        Assertions.assertTrue(issuePage.isPageOpened());
        IssueDeletePage issueDeletePage = issuePage.closeIssue(s);
        Assertions.assertTrue(issueDeletePage.issueDeletePageIsOpened());
        issueDeletePage.deletingIssue();
        Assertions.assertTrue(issueCreatePage.issueDeletingNotification());
        Thread.sleep(5000);
    }

}
