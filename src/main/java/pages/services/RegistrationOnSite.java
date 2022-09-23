package pages.services;

import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class RegistrationOnSite {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationOnSite.class.getName());
    private final WebDriver driver;
    public RegistrationOnSite(WebDriver driver) {
        this.driver = driver;
    }

    public void registrationForConfirm() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.debug(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.debug("Open Registration Page");
        loginPage.openLoginPage();
        LOGGER.debug("Input Login and Password for registration");
        loginPage.sendNoConfirmUserForm();
    }

    public void standartRegistration() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.debug(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.debug("Open Registration Page");
        loginPage.openLoginPage();
        LOGGER.debug("Input Login and Password for registration");
        loginPage.sendAcceptedUserForm();
    }
}
