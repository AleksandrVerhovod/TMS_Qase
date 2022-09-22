package pages;

import constants.Urls;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Find Submit button on the Registration Page: %s", CREATE_BUTTON));
        return CREATE_BUTTON.isDisplayed();
    }

    public RegistrationPage openRegistrationPage () {
        LOGGER.debug(String.format("Attempt to open URL: %s",Urls.REGISTRATION_PAGE));
        driver.get(Urls.REGISTRATION_PAGE);
        return this;
    }

    public RegistrationPage clickCheckboxAgreePrivacyPolicy () {
        LOGGER.debug(String.format("Checkbox 'Agree privacy policy' enable"));
        CHECKBOX_AGREE_PRIVACY.click();
        return this;
    }

    public RegistrationPage clickCheckboxNewsletter () {
        LOGGER.debug(String.format("Checkbox 'Newsletter' enable"));
        CHECKBOX_NEWSLETTERS.click();
        return this;
    }

    public ActivatedPage sendRegistrationByValidData (RegistrationModel registrationModel) {
        EMAIL_INPUT.sendKeys(registrationModel.getEmail());
        String password = registrationModel.getPassword();
        PASSWORD_INPUT.sendKeys(password);
        CONFIRM_PASSWORD_INPUT.sendKeys(password);
        CREATE_BUTTON.click();
        return new ActivatedPage(driver);

    }





}
