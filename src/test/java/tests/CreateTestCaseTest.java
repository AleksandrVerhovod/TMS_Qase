package tests;

import io.qameta.allure.Description;
import models.CreateTestCaseModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateTestCasePage;
import pages.ProjectRepositoryPage;
import pages.services.LoginSite;
import testdata.PrepareCreateTestCase;
import utils.RetryAnalyzer;

public class CreateTestCaseTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CreateTestCaseTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The user creates a new test case with valid values for the fields")
    public void createTestCaseValidDateTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
        loginSite.demoLogin();
        LOGGER.info("Demo Login done");
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectRepositoryPage.class.getName()));

        projectRepositoryPage.openProjectRepositoryPage()
                .clickAddTestCase();
        CreateTestCasePage createTestCasePage = new CreateTestCasePage(getDriver());
        CreateTestCaseModel createTestCaseModel = PrepareCreateTestCase.getCreateTestCaseValidData();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareCreateTestCase.class.getName()));
        createTestCasePage.fillInCreateTestCaseForm(createTestCaseModel);
        LOGGER.info("Check if confirmation message is displayed");
        Assert.assertTrue(createTestCasePage.isConfirmationMessageCreatTestCaseDisplayed(), "No confirmation message created test case");
    }
}