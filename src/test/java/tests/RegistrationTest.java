package tests;

import models.LoginModel;
import models.RegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActivatedPage;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.RegistrationPage;
import testdata.PrepareLoginData;
import testdata.PrepareRegistrationData;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationValidUser () {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .clickCheckboxNewsletter();
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithValidData();
        registrationPage.sendRegistrationByValidData(registrationModel);
        ActivatedPage activatedPage = new ActivatedPage(driver);
        Assert.assertTrue(activatedPage.isCongratulationDisplayed(),"No message 'Congratulations!'");

    }
}
