package tests;

import models.OnboardingModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OnboardingPage;
import pages.ProjectsListPage;
import pages.services.LoginSite;
import testdata.PrepareOnboardingData;
import testdata.PrepareRegistrationData;

public class OnboardingTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(OnboardingTest.class.getName());
    @Test (description = "User to complete the registration, the user enters the correct data in the fields")
    public void inputValidAboutYouOnboardingDataTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginSite.class.getName()));
        loginSite.loginForConfirm();
        LOGGER.info("Log in fo confirm to the site");
        OnboardingPage onboardingPage = new OnboardingPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", OnboardingPage.class.getName()));
        OnboardingModel onboardingModel = PrepareOnboardingData.getOnboardingWithValidData();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareOnboardingData.class.getName()));
        onboardingPage.openOnboardingPage()
                .sendOnboardingValidData(onboardingModel);
        ProjectsListPage projectsPage = new ProjectsListPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectsListPage.class.getName()));
        LOGGER.info("Check if button 'Create' is displayed");
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed(),"Button 'Create' isn't dispalyed");
    }
}
