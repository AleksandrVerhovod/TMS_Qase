package pages;

import constants.Credentials;
import constants.Urls;
import elements.Dropdowns;
import io.qameta.allure.Step;
import models.InventNewUserModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GenerateTestData;

public class InvitesPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(InvitesPage.class.getName());

    @FindBy(xpath = "//input[@name='title']")
    private WebElement FILTER_BLOCK;

    @FindBy(xpath = "//a[@class='btn btn-primary me-2']")
    private WebElement INVITE_NEW_MEMBER_BUTTON;

    @FindBy (css = "#email")
    private WebElement EMAIL_INPUT;

    @FindBy (css = "#name")
    private  WebElement NAME_INPUT;

    @FindBy (css = "#role_title")
    private  WebElement ROLE_TITLE_INPUT;

    @FindBy (xpath = "//button[text()='Invite']")
    private WebElement INVITE_BUTTON;

    @FindBy (xpath = "//span[contains(text(),'successfully invited')]")
    private WebElement CONFIRMATION_MESSAGE;


    public InvitesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find filter block: %s", FILTER_BLOCK));
        return FILTER_BLOCK.isDisplayed();
    }

    @Step("Open invites page")
    public InvitesPage openInvitesPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE.concat(Urls.INVITES_PAGE)));
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.INVITES_PAGE));
        return this;
    }
    @Step("Click 'Invite new member' button")
    public InvitesPage clickInviteNewMember() {
        LOGGER.debug(String.format("Attempt to click button: %s", INVITE_NEW_MEMBER_BUTTON));
        INVITE_NEW_MEMBER_BUTTON.click();
        return this;
    }
    @Step("Confirmation message about added invited user is displayed")
    public boolean isConfirmationMessageInvitedDisplayed () {
        LOGGER.debug(String.format("Attempt to find message: %s", CONFIRMATION_MESSAGE));
        return CONFIRMATION_MESSAGE.isDisplayed();
    }
    @Step("Fill invent new user form")
    public InvitesPage sendInviteNewUserForm (InventNewUserModel inventNewUserModel) {
        EMAIL_INPUT.sendKeys(GenerateTestData.generateEmail());
        LOGGER.debug(String.format("Input email: %s", GenerateTestData.generateEmail()));
        NAME_INPUT.sendKeys(GenerateTestData.generateFullName());
        LOGGER.debug(String.format("Input Name: %s", GenerateTestData.generateFullName()));
        ROLE_TITLE_INPUT.sendKeys(GenerateTestData.generateRoleTitle());
        LOGGER.debug(String.format("Input Role: %s", GenerateTestData.generateRoleTitle()));
        new Dropdowns(driver,"Role").selectOptionDefect(inventNewUserModel.getRole());
        LOGGER.debug(String.format("Attempt to select Role: %s", inventNewUserModel.getRole()));
        LOGGER.debug(String.format("Attempt to click button: %s", INVITE_BUTTON));
        INVITE_BUTTON.click();
        return this;
    }


}
