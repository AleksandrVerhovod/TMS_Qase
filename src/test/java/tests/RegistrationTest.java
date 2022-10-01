package tests;

import models.RegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActivatedPage;
import pages.RegistrationPage;
import testdata.PrepareRegistrationData;
import utils.RetryAnalyzer;

public class RegistrationTest extends BaseTest {

    @Test (retryAnalyzer = RetryAnalyzer.class, priority = 1,description = "The user registers with valid data without receiving the newsletter")
    public void registrationValidUserTest () {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithValidData();
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .clickCheckboxNewsletter()
                .sendRegistrationForm(registrationModel);
        ActivatedPage activatedPage = new ActivatedPage(getDriver());
        Assert.assertEquals(activatedPage.isEmailDisplayed(),registrationModel.getEmail());
    }

    @Test (priority = 2, description = "The user registers with fields filled in with valid data except email")
    public void registrationWithoutEmailTest () {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithoutEmail();
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        Assert.assertEquals(registrationPage.errorMessageEmailInput(),"Заполните это поле.");
    }
    @Test (priority = 2, description = "The user registers with fields filled in with valid data except confirm password")
    public void registrationWithoutConfirmPasswordTest () {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationDataWithoutConfirmPassword();
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        Assert.assertEquals(registrationPage.errorMessageConfirmPassInput(),"Заполните это поле.");
    }

    @Test (priority = 2, description = "The user registers with fields filled with valid data, but with mismatched values into password and confirm password")
    public void registrationWithNoEqualsPasswordAndConfirmPasswordTest () {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithNoEqualsPassAndConfirmPass();
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        Assert.assertTrue(registrationPage.isMessageNotMatchConfirmPassDisplayed(),"No message 'The password confirmation does not match.'");
    }

}
