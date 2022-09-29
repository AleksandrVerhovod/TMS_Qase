package pages;

import constants.Credentials;
import constants.Urls;
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

    @FindBy(xpath = "")
    private WebElement POPUP_MESSAGE;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Find Submit button on the Login Page: %s", LOGIN_BUTTON));
        return LOGIN_BUTTON.isDisplayed();
    }

    public LoginPage openLoginPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s",Urls.QASE_LOGIN_PAGE));
        driver.get(Urls.QASE_LOGIN_PAGE);
        return this;
    }
    public ProjectsListPage sendNoConfirmUserForm() {
//        LOGGER.debug(String.format("Attempt to open URL: %s",Urls.QASE_LOGIN_PAGE));
        EMAIL_INPUT.sendKeys(Credentials.EMAIL_NO_CONFIRM);
        PASSWORD_INPUT.sendKeys(Credentials.PASSWORD_NO_CONFIRM);
        LOGIN_BUTTON.click();
        return new ProjectsListPage(driver);
    }

    public ProjectsListPage sendAcceptedUserForm() {
//        LOGGER.debug(String.format("Attempt to open URL: %s",Urls.QASE_LOGIN_PAGE));
        EMAIL_INPUT.sendKeys(Credentials.EMAIL_VALID);
        PASSWORD_INPUT.sendKeys(Credentials.PASSWORD_VALID);
        LOGIN_BUTTON.click();
        return new ProjectsListPage(driver);
    }

    public ProjectsListPage sendLoginForm(LoginModel loginModel) {
//        LOGGER.debug(String.format("Attempt to open URL: %s",Urls.QASE_LOGIN_PAGE));
        EMAIL_INPUT.sendKeys(loginModel.getEmail());
        PASSWORD_INPUT.sendKeys(loginModel.getPassword());
        LOGIN_BUTTON.click();
        return new ProjectsListPage(driver);
    }


      public LoginPage clickCheckboxButton() {
        LOGGER.debug("Enable checkbox 'Remember Me'");
        CHECKBOX_REMEMBER_ME.click();
        return this;
    }

        public LoginPage signUpButtonClick() {
            LOGGER.debug("SignUp button click");
            SIGN_UP_BUTTON.click();
            return this;
        }

    public LoginPage forgotYourPasswordButtonClick() {
        LOGGER.debug("ForgotYourPassword button click");
        FORGOT_YOUR_PASSWORD_BUTTON.click();
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        LOGGER.debug("Error message is displayed");
        return ERROR_MESSAGE.isDisplayed();
    }

    public String isErrorMessage() {
        LOGGER.debug("Error message is displayed");
        return EMAIL_INPUT.getAttribute("validationMessage");
    }


}
