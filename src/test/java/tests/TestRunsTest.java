package tests;

import models.TestRunsModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestRunsPage;
import pages.services.LoginSite;
import testdata.PrepareTestRuns;

public class TestRunsTest extends BaseTest {

    @Test (description = "The user creates a new test run with valid values for the fields")
    public void createTestRunValidDateTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        loginSite.demoLogin();
        TestRunsPage testRunsPage = new TestRunsPage(getDriver());
        TestRunsModel testRunsModel = PrepareTestRuns.getTestRunModelValidData();
        testRunsPage.openTestRunsPage()
                .clickStartNewTestRun()
                .fillStartTestRunForm(testRunsModel)
                .clickStartTestRun();
        Assert.assertTrue(testRunsPage.isConfirmationMessageDispalyed(),"No confirmation message created test run");

    }
}
