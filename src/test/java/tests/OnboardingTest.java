package tests;

import models.OnboardingModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OnboardingPage;
import pages.ProjectsPage;
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
        ProjectsPage projectsPage = new ProjectsPage(driver);
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed(),"Button 'Create' isn't dispalyed");
    }
}
