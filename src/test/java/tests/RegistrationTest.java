package tests;

import io.qameta.allure.Description;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActivatedPage;
import pages.LoginPage;
import pages.RegistrationPage;
import testdata.PrepareRegistrationData;
import utils.RetryAnalyzer;

public class RegistrationTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationTest.class.getName());

    @Test (retryAnalyzer = RetryAnalyzer.class, priority = 1,description = "The user registers with valid data without receiving the newsletter")
    public void registrationValidUserTest () {
        RegistrationPage registrationPage = new RegistrationPage(getDriver()); LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",RegistrationPage.class.getName()));
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithValidData();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareRegistrationData.class.getName()));
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .clickCheckboxNewsletter()
                .sendRegistrationForm(registrationModel);
        ActivatedPage activatedPage = new ActivatedPage(getDriver());
        LOGGER.info(String.format("Open %s page",ActivatedPage.class.getName()));
        LOGGER.info("Check if emails are equals");
        Assert.assertEquals(activatedPage.isEmailDisplayed(),registrationModel.getEmail());
    }

    @Test (priority = 2)
    @Description("The user registers with fields filled in with valid data except email")
    public void registrationWithoutEmailTest () {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        LOGGER.info(String.format("Open %s page",RegistrationPage.class.getName()));
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithoutEmail();
        LOGGER.info(String.format("Prepared data without email by %s", PrepareRegistrationData.class.getName()));
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        LOGGER.info("Check if error message is displayed");
        Assert.assertEquals(registrationPage.errorMessageEmailInput(),"Заполните это поле.");
    }
    @Test (priority = 2)
    @Description ("The user registers with fields filled in with valid data except confirm password")
    public void registrationWithoutConfirmPasswordTest () {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        LOGGER.info(String.format("Open %s page",RegistrationPage.class.getName()));
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationDataWithoutConfirmPassword();
        LOGGER.info(String.format("Prepared data without confirm password by %s", PrepareRegistrationData.class.getName()));
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        LOGGER.info("Check if error message is displayed");
        Assert.assertEquals(registrationPage.errorMessageConfirmPassInput(),"Заполните это поле.");
    }

    @Test (priority = 2)
    @Description("The user registers with fields filled with valid data, but with mismatched values into password and confirm password")
    public void registrationWithNoEqualsPasswordAndConfirmPasswordTest () {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        LOGGER.info(String.format("Open %s page",RegistrationPage.class.getName()));
        RegistrationModel registrationModel = PrepareRegistrationData.getRegistrationWithNoEqualsPassAndConfirmPass();
        LOGGER.info(String.format("Prepared data no equals password and confirm password by %s", PrepareRegistrationData.class.getName()));
        registrationPage.openRegistrationPage()
                .clickCheckboxAgreePrivacyPolicy()
                .sendRegistrationForm(registrationModel);
        LOGGER.info("Check if error message is displayed");
        Assert.assertTrue(registrationPage.isMessageNotMatchConfirmPassDisplayed(),"No message 'The password confirmation does not match.'");
    }
}
