package tests;

import io.qameta.allure.Description;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectsListPage;
import testdata.PrepareLoginData;
import testdata.PrepareOnboardingData;
import testdata.PrepareRegistrationData;


public class LogInTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LogInTest.class.getName());
    @Test(priority = 1)
    @Description("The user login with valid data and select checkbox 'Remember me'")
    public void loginValidUserWithCheckboxTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .clickCheckboxButton()
                .sendLoginForm(loginModel);
        ProjectsListPage projectsPage = new ProjectsListPage(getDriver());
        LOGGER.info(String.format("Prepared valid data by %s", ProjectsListPage.class.getName()));
        LOGGER.info("Check if button 'Create' is displayed");
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed());
    }

    @Test(priority = 2)
    @Description("The user login with valid data without click checkbox 'Remember me'")
    public void loginValidUserWithoutCheckboxTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        ProjectsListPage projectsPage = new ProjectsListPage(getDriver());
        LOGGER.info(String.format("Prepared valid data by %s", ProjectsListPage.class.getName()));
        LOGGER.info("Check if button 'Create' is displayed");
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed());
    }


    @Test(priority = 1)
    @Description("The user login with valid password and unregistered email")
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginModel loginModel = PrepareLoginData.getFakeEmailLogin();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        LOGGER.info("Check if message is displayed");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(priority = 1)
    @Description("The user login with invalid password and valid email")
    public void loginInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginModel loginModel = PrepareLoginData.getFakePasswordLogin();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        LOGGER.info("Check if message is displayed");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test(invocationCount = 1, threadPoolSize = 1, priority = 2)
    @Description("The user login with empty password and email fields")
    public void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginModel loginModel = PrepareLoginData.getLoginWithEmptyFieldsLogin();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        LOGGER.info("Check if message is displayed");
        Assert.assertEquals(loginPage.isErrorMessage(), "Заполните это поле.");
    }

}
