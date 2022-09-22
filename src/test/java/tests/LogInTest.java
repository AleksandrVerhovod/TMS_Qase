package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectsPage;
import testdata.PrepareLoginData;


public class LogInTest extends BaseTest {
    @Test
    public void loginValidUserWithCheckbox() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickCheckboxButton();
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        loginPage.sendLoginForm(loginModel);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed());
    }

    @Test
    public void loginValidUserWithoutCheckbox() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        loginPage.sendLoginForm(loginModel);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        Assert.assertTrue(projectsPage.isCreateButtonDisplayed());
    }


    @Test
    public void loginInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        LoginModel loginModel = PrepareLoginData.getFakeEmailLogin();
        loginPage.sendLoginForm(loginModel);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
    public void loginInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        LoginModel loginModel = PrepareLoginData.getFakePasswordLogin();
        loginPage.sendLoginForm(loginModel);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
    public void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        LoginModel loginModel = PrepareLoginData.getLoginWithEmptyFieldsLogin();
        loginPage.sendLoginForm(loginModel);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

}
