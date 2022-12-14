package pages.services;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import tests.LogInTest;

public class LoginSite {

    private static final Logger LOGGER = LogManager.getLogger(LoginSite.class.getName());
    private final WebDriver driver;

    public LoginSite(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login by no confirm user")
    public void loginForConfirm() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.debug(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.debug("Open Login Page");
        loginPage.openLoginPage();
        LOGGER.debug("Input Login and Password for registration");
        loginPage.sendNoConfirmUserForm();
    }

    @Step("Login by demo user")
    public void demoLogin() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.debug(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.debug("Open Login Page");
        loginPage.openLoginPage();
        LOGGER.debug("Input Login and Password for registration");
        loginPage.sendAcceptedUserForm();
    }
}
