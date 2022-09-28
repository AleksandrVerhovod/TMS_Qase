package tests;

import models.CreateTestCaseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateTestCasePage;
import pages.ProjectRepositoryPage;
import pages.services.LoginSite;
import testdata.PrepareCreateTestCase;

public class CreateTestCaseTest extends BaseTest {

    @Test
    public void createTestSuiteValidDateTest() {
        LoginSite loginSite = new LoginSite(driver);
        loginSite.demoLogin();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(driver);
        projectRepositoryPage.openProjectRepositoryPage()
                .clickAddTestCase();
        CreateTestCasePage createTestCasePage = new CreateTestCasePage(driver);
        CreateTestCaseModel createTestCaseModel = PrepareCreateTestCase.getCreateTestCaseValidData();
        createTestCasePage.fillInAccountForm(createTestCaseModel);
        Assert.assertTrue(createTestCasePage.isConfirmationMessageCreatTestCaseDisplayed(), "No confirmation message created test case");

    }
}