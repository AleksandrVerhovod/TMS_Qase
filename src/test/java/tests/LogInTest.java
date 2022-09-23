package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectsPage;
import testdata.PrepareLoginData;


public class LogInTest extends BaseTest {
    @Test
    public void loginValidUserWithCheckboxTest() {
        LoginPage loginPage = new LoginPage(driver);
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        loginPage.openLoginPage()
                .clickCheckboxButton()
                .sendLoginForm(loginModel);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed());
    }

    @Test
    public void loginValidUserWithoutCheckboxTest() {
        LoginPage loginPage = new LoginPage(driver);
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed());
    }


    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        LoginModel loginModel = PrepareLoginData.getFakeEmailLogin();
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
    public void loginInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        LoginModel loginModel = PrepareLoginData.getFakePasswordLogin();
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
    public void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        LoginModel loginModel = PrepareLoginData.getLoginWithEmptyFieldsLogin();
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

}
