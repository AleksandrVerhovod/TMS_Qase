package tests;

import models.CreateTestCaseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateTestCasePage;
import pages.ProjectRepositoryPage;
import pages.services.LoginSite;
import testdata.PrepareCreateTestCase;
import utils.RetryAnalyzer;

public class CreateTestCaseTest extends BaseTest {

    @Test (retryAnalyzer = RetryAnalyzer.class, description = "The user creates a new test case with valid values for the fields")
    public void createTestCaseValidDateTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        loginSite.demoLogin();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(getDriver());
        projectRepositoryPage.openProjectRepositoryPage()
                .clickAddTestCase();
        CreateTestCasePage createTestCasePage = new CreateTestCasePage(getDriver());
        CreateTestCaseModel createTestCaseModel = PrepareCreateTestCase.getCreateTestCaseValidData();
        createTestCasePage.fillInAccountForm(createTestCaseModel);
        Assert.assertTrue(createTestCasePage.isConfirmationMessageCreatTestCaseDisplayed(), "No confirmation message created test case");

    }
}