package tests;

import models.RegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActivatedPage;
import pages.RegistrationPage;
import testdata.PrepareRegistrationData;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationValidUserTest () {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithValidData();
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .clickCheckboxNewsletter()
                .sendRegistrationForm(registrationModel);
        ActivatedPage activatedPage = new ActivatedPage(driver);
        Assert.assertTrue(activatedPage.isReceivedButtonDisplayed(),"No button 'I didn't receive any email'");
    }

    @Test
    public void registrationWithoutEmailTest () {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithoutEmail();
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        Assert.assertEquals(registrationPage.errorMessageEmailInput(),"Заполните это поле.");
    }
    @Test
    public void registrationWithoutConfirmPasswordTest () {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationDataWithoutConfirmPassword();
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        Assert.assertEquals(registrationPage.errorMessageConfirmPassInput(),"Заполните это поле.");
    }

    @Test
    public void registrationWithNoEqualsPasswordAndConfirmPasswordTest () {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithNoEqualsPassAndConfirmPass();
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        Assert.assertTrue(registrationPage.isMessageNotMatchConfirmPassDisplayed(),"No message 'The password confirmation does not match.'");
    }

}
