package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(id = "inputEmail")
    private WebElement EMAIL_INPUT;

    @FindBy(id = "inputPassword")
    private WebElement PASSWORD_INPUT;

    @FindBy(className = "custom-control-indicator")
    private WebElement CHECKBOX_REMEMBER_ME;

    @FindBy(id = "btnLogin")
    private WebElement LOGIN_BUTTON;

    @FindBy(xpath = "//div[@class='col text-end']//a")
    private WebElement SIGN_UP_BUTTON;

    @FindBy(xpath = "//div[@class='col text-start']//small[text()='Forgot Your Password?']")
    private WebElement FORGOT_YOUR_PASSWORD_BUTTON;

    @FindBy(xpath = "//div[@class='form-control-feedback']")
    private WebElement ERROR_MESSAGE;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", LOGIN_BUTTON));
        return LOGIN_BUTTON.isDisplayed();
    }

    @Step("Open login page")
    public LoginPage openLoginPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE));
        driver.get(Urls.QASE_LOGIN_PAGE);
        return this;
    }

    @Step("Fill without confirm user form")
    public ProjectsListPage sendNoConfirmUserForm() {
        EMAIL_INPUT.sendKeys(Credentials.EMAIL_NO_CONFIRM);
        LOGGER.debug(String.format("Input email: %s", Credentials.EMAIL_NO_CONFIRM));
        PASSWORD_INPUT.sendKeys(Credentials.PASSWORD_NO_CONFIRM);
        LOGGER.debug(String.format("Input password: %s", Credentials.PASSWORD_NO_CONFIRM));
        LOGGER.debug(String.format("Attempt to click button: %s", LOGIN_BUTTON));
        LOGIN_BUTTON.click();
        return new ProjectsListPage(driver);
    }

    @Step("Fill accepted user form")
    public ProjectsListPage sendAcceptedUserForm() {
        EMAIL_INPUT.sendKeys(Credentials.EMAIL_VALID);
        LOGGER.debug(String.format("Input email: %s", Credentials.EMAIL_VALID));
        PASSWORD_INPUT.sendKeys(Credentials.PASSWORD_VALID);
        LOGGER.debug(String.format("Input password: %s", Credentials.PASSWORD_VALID));
        LOGGER.debug(String.format("Attempt to click button: %s", LOGIN_BUTTON));
        LOGIN_BUTTON.click();
        return new ProjectsListPage(driver);
    }

    @Step("Fill user form by valid random data")
    public ProjectsListPage sendLoginForm(LoginModel loginModel) {
        EMAIL_INPUT.sendKeys(loginModel.getEmail());
        LOGGER.debug(String.format("Input email: %s", loginModel.getEmail()));
        PASSWORD_INPUT.sendKeys(loginModel.getPassword());
        LOGGER.debug(String.format("Input password: %s", loginModel.getPassword()));
        LOGGER.debug(String.format("Attempt to click button: %s", LOGIN_BUTTON));
        LOGIN_BUTTON.click();
        return new ProjectsListPage(driver);
    }

    @Step("Click checkbox 'Remember me'")
    public LoginPage clickCheckboxButton() {
        LOGGER.debug(String.format("Attempt to click checkbox: %s", CHECKBOX_REMEMBER_ME));
        CHECKBOX_REMEMBER_ME.click();
        return this;
    }

    @Step("Click link 'Sign Up'")
    public LoginPage signUpButtonClick() {
        LOGGER.debug(String.format("Attempt to button: %s", SIGN_UP_BUTTON));
        SIGN_UP_BUTTON.click();
        return this;
    }

    @Step("Click link 'Forgot your password'")
    public LoginPage forgotYourPasswordButtonClick() {
        LOGGER.debug(String.format("Attempt to button: %s", FORGOT_YOUR_PASSWORD_BUTTON));
        FORGOT_YOUR_PASSWORD_BUTTON.click();
        return this;
    }

    @Step("Check if Error message is displayed")
    public boolean isErrorMessageDisplayed() {
        LOGGER.debug(String.format("Attempt to find message: %s", ERROR_MESSAGE));
        return ERROR_MESSAGE.isDisplayed();
    }

    @Step("Get text by error message")
    public String isErrorMessage() {
        LOGGER.debug(String.format("Attempt to get attribute of: %s", EMAIL_INPUT));
        return EMAIL_INPUT.getAttribute("validationMessage");
    }
}
