package pages;

import constants.Urls;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());


    @FindBy(id = "inputEmail")
    private WebElement EMAIL_INPUT;

    @FindBy(id = "inputPassword")
    private WebElement PASSWORD_INPUT;

    @FindBy(id = "inputPasswordConfirm")
    private WebElement CONFIRM_PASSWORD_INPUT;

    @FindBy(xpath = "(//span[@class='custom-control-indicator'])[1]")
    private WebElement CHECKBOX_AGREE_PRIVACY;

    @FindBy(xpath = "(//span[@class='custom-control-indicator'])[2]")
    private WebElement CHECKBOX_NEWSLETTERS;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement CREATE_BUTTON;

    @FindBy(xpath = "//div[contains(text(),'confirmation does not match')]")
    private WebElement NOT_MATCH_CONFIRMATION_MESSAGE;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Find Submit button on the Registration Page: %s", CREATE_BUTTON));
        return CREATE_BUTTON.isDisplayed();
    }

    public RegistrationPage openRegistrationPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE.concat(Urls.SIGNUP_PAGE)));
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.SIGNUP_PAGE));
        return this;
    }

    public RegistrationPage clickCheckboxAgreePrivacyPolicy() {
        LOGGER.debug(String.format("Checkbox 'Agree privacy policy' enable"));
        CHECKBOX_AGREE_PRIVACY.click();
        return this;
    }

    public RegistrationPage clickCheckboxNewsletter() {
        LOGGER.debug(String.format("Checkbox 'Newsletter' enable"));
        CHECKBOX_NEWSLETTERS.click();
        return this;
    }

    public ActivatedPage sendRegistrationData(RegistrationModel registrationModel) {
        EMAIL_INPUT.sendKeys(registrationModel.getEmail());
        PASSWORD_INPUT.sendKeys(registrationModel.getPassword());
        CONFIRM_PASSWORD_INPUT.sendKeys(registrationModel.getConfirmPassword());
        CREATE_BUTTON.click();
        return new ActivatedPage(driver);
    }

    public String errorMessageEmailInput() {
        LOGGER.debug(String.format("Alert message 'Заполниет это поле' is displayed"));
        String attribute = EMAIL_INPUT.getAttribute("validationMessage");
        return attribute;
    }

    public String errorMessageConfirmPassInput() {
        LOGGER.debug(String.format("Alert message 'Заполниет это поле' is displayed"));
        String attribute = CONFIRM_PASSWORD_INPUT.getAttribute("validationMessage");
        return attribute;
    }

    public boolean isMessageNotMatchConfirmPassDisplayed() {
        LOGGER.debug(String.format("Message is displayed on the Registration Page: %s", NOT_MATCH_CONFIRMATION_MESSAGE));
        return NOT_MATCH_CONFIRMATION_MESSAGE.isDisplayed();
    }


}