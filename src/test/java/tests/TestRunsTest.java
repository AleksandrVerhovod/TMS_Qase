package tests;

import io.qameta.allure.Description;
import models.TestRunsModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TestRunsPage;
import pages.services.LoginSite;
import testdata.PrepareTestRuns;

public class TestRunsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(TestRunsTest.class.getName());

    @Test
    @Description("The user creates a new test run with valid values for the fields")
    public void createTestRunValidDateTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginSite.demoLogin();
        LOGGER.info("Log in to the site");
        TestRunsPage testRunsPage = new TestRunsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", TestRunsPage.class.getName()));
        TestRunsModel testRunsModel = PrepareTestRuns.getTestRunModelValidData();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareTestRuns.class.getName()));
        testRunsPage.openTestRunsPage()
                .clickStartNewTestRun()
                .fillStartTestRunForm(testRunsModel)
                .clickStartTestRun();
        LOGGER.info("Check if message is displayed");
        Assert.assertTrue(testRunsPage.isConfirmationMessageDispalyed(), "No confirmation message created test run");
    }
}
