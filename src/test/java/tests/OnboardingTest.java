package tests;

import models.OnboardingModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OnboardingPage;
import pages.ProjectsListPage;
import pages.services.RegistrationOnSite;
import testdata.PrepareOnboardingData;

public class OnboardingTest extends BaseTest {

    @Test
    public void inputValidAboutYouOnboardingDataTest() {
        RegistrationOnSite loginService = new RegistrationOnSite(driver);
        loginService.registrationForConfirm();
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        OnboardingModel onboardingModel = PrepareOnboardingData.getOnboardingWithValidData();
        onboardingPage.openOnboardingPage()
                .sendOnboardingValidData(onboardingModel);
        ProjectsListPage projectsPage = new ProjectsListPage(driver);
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed(),"Button 'Create' isn't dispalyed");
    }
}
