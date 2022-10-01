package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectsListPage;
import testdata.PrepareLoginData;


public class LogInTest extends BaseTest {
    @Test (priority = 1, description = "The user login with valid data and select checkbox 'Remember me'")
    public void loginValidUserWithCheckboxTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        loginPage.openLoginPage()
                .clickCheckboxButton()
                .sendLoginForm(loginModel);
        ProjectsListPage projectsPage = new ProjectsListPage(getDriver());
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed());
    }

    @Test (priority = 2, description = "The user login with valid data without click checkbox 'Remember me'")
    public void loginValidUserWithoutCheckboxTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        ProjectsListPage projectsPage = new ProjectsListPage(getDriver());
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed());
    }


    @Test (priority = 1, description = "The user login with valid password and unregistered email")
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LoginModel loginModel = PrepareLoginData.getFakeEmailLogin();
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test (priority = 1, description = "The user login with invalid password and valid email")
    public void loginInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LoginModel loginModel = PrepareLoginData.getFakePasswordLogin();
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test (invocationCount = 3, threadPoolSize = 3, priority = 2,description = "The user login with empty password and email fields")
    public void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(getDriver());
        LoginModel loginModel = PrepareLoginData.getLoginWithEmptyFieldsLogin();
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        Assert.assertEquals(loginPage.isErrorMessage(),"Заполните это поле.");
    }

}
