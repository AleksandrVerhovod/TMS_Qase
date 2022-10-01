package tests;

import models.OnboardingModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OnboardingPage;
import pages.ProjectsListPage;
import pages.services.LoginSite;
import testdata.PrepareOnboardingData;

public class OnboardingTest extends BaseTest {

    @Test (description = "User to complete the registration, the user enters the correct data in the fields")
    public void inputValidAboutYouOnboardingDataTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        loginSite.loginForConfirm();
        OnboardingPage onboardingPage = new OnboardingPage(getDriver());
        OnboardingModel onboardingModel = PrepareOnboardingData.getOnboardingWithValidData();
        onboardingPage.openOnboardingPage()
                .sendOnboardingValidData(onboardingModel);
        ProjectsListPage projectsPage = new ProjectsListPage(getDriver());
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed(),"Button 'Create' isn't dispalyed");
    }
}
