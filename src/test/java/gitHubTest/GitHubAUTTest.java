package gitHubTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class GitHubAUTTest extends BaseTest {
    private static Logger log = Logger.getLogger(GitHubAUTTest.class.getName());

    @Test
    public void goToIssiePageTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        MainPage mainPage = loginPage.loginSuccessful("o-yelkoff", "autTest123!");
        RepositoryPage repositoryPage = mainPage.goToRepositoryPage();
        assertTrue(repositoryPage.isPageOpened());
        IssuePage issuePage = repositoryPage.goToIssuePage();
        assertTrue(issuePage.isPageOpened());
        IssueCreatePage issueCreatePage = issuePage.goToIssueCreatePage();
        assertTrue(issueCreatePage.issueCreatePageIsOpen());
    }

    @Test
    void createNewIssueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        MainPage mainPage = loginPage.loginSuccessful("o-yelkoff", "autTest123!");
        RepositoryPage repositoryPage = mainPage.goToRepositoryPage();
        assertTrue(repositoryPage.isPageOpened());
        IssuePage issuePage = repositoryPage.goToIssuePage();
        assertTrue(issuePage.isPageOpened());
        IssueCreatePage issueCreatePage = issuePage.goToIssueCreatePage();
        String s = "GitTest " + System.currentTimeMillis();
        IssueCreatePage issueCreatePage1 = issueCreatePage.createNewIssue(s, "GitTest, my first issue create");
        assertTrue(issueCreatePage1.newIssueIsCreated());
        issueCreatePage.goBackToIssuePage();
        assertTrue(issuePage.isPageOpened());
        int issueAmount = issuePage.getIssueAmount(s);
        assertEquals(issueAmount, 1);
    }

    @Test
    void deleteIssueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        MainPage mainPage = loginPage.loginSuccessful("o-yelkoff", "autTest123!");
        RepositoryPage repositoryPage = mainPage.goToRepositoryPage();
        assertTrue(repositoryPage.isPageOpened());
        IssuePage issuePage = repositoryPage.goToIssuePage();
        assertTrue(issuePage.isPageOpened());
        IssueCreatePage issueCreatePage = issuePage.goToIssueCreatePage();
        String s = "GitTest " + System.currentTimeMillis();
        IssueCreatePage issueCreatePage1 = issueCreatePage.createNewIssue(s, "GitTest, my first issue create");
        assertTrue(issueCreatePage1.newIssueIsCreated());
        issueCreatePage.goBackToIssuePage();
        assertTrue(issuePage.isPageOpened());
        IssueDeletePage issueDeletePage = issuePage.closeIssue(s);
        assertTrue(issueDeletePage.issueDeletePageIsOpened());
        issueDeletePage.deletingIssue();
        assertTrue(issueCreatePage.issueDeletingNotification());
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataGenerator() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 257; i++) {
            s.append("a");
        }

        String blank = " ";
        String toLongString = s.toString();
        return new Object[][]{
                {blank, "There was an error creating your Issue: title can't be blank."},
                {toLongString, "Title is too long (maximum is 256 characters)"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void issueCreationValidationParametrized(String title, String expectedError) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        MainPage mainPage = loginPage.loginSuccessful("o-yelkoff", "autTest123!");
        RepositoryPage repositoryPage = mainPage.goToRepositoryPage();
        assertTrue(repositoryPage.isPageOpened());
        IssuePage issuePage = repositoryPage.goToIssuePage();
        assertTrue(issuePage.isPageOpened());
        IssueCreatePage issueCreatePage = issuePage.goToIssueCreatePage();
        IssueCreatePage issueCreatePage1 = issueCreatePage.createNewIssue(title, "comment");
        assertTrue(issueCreatePage1.titleErrorNotification());
        String actualMessage = issueCreatePage1.getErrorText();
        assertEquals(actualMessage, expectedError);
    }
}
