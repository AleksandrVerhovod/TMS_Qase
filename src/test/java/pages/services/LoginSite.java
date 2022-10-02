package pages.services;

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

    public void loginForConfirm() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.debug(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.debug("Open Login Page");
        loginPage.openLoginPage();
        LOGGER.debug("Input Login and Password for registration");
        loginPage.sendNoConfirmUserForm();
    }

    public void demoLogin() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.debug(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.debug("Open Login Page");
        loginPage.openLoginPage();
        LOGGER.debug("Input Login and Password for registration");
        loginPage.sendAcceptedUserForm();
    }
}
