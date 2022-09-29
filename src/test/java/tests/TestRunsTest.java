package tests;

import models.TestRunsModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestRunsPage;
import pages.services.LoginSite;
import testdata.PrepareTestRuns;

public class TestRunsTest extends BaseTest {

    @Test
    public void createTestRunValidDateTest() {
        LoginSite loginSite = new LoginSite(driver);
        loginSite.demoLogin();
        TestRunsPage testRunsPage = new TestRunsPage(driver);
        TestRunsModel testRunsModel = PrepareTestRuns.getTestRunModelValidData();
        testRunsPage.openTestRunsPage()
                .clickStartNewTestRun()
                .fillStartTestRunForm(testRunsModel)
                .clickStartTestRun();
        Assert.assertTrue(testRunsPage.isConfirmationMessageDispalyed(),"No confirmation message created test run");

    }
}
