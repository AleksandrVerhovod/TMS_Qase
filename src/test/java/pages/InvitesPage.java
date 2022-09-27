package pages;

import constants.Urls;
import elements.Dropdown;
import models.InventNewUserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GenerateTestData;

public class InvitesPage extends BasePage {

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
        return FILTER_BLOCK.isDisplayed();
    }


    public InvitesPage openInvitesPage() {
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.INVITES_PAGE));
        return this;
    }

    public InvitesPage clickInviteNewMember() {
        INVITE_NEW_MEMBER_BUTTON.click();
        return this;
    }

    public boolean isConfirmationMessageInvitedDisplayed () {
        return CONFIRMATION_MESSAGE.isDisplayed();
    }

    public InvitesPage sendInviteNewUserForm (InventNewUserModel inventNewUserModel) {
        EMAIL_INPUT.sendKeys(GenerateTestData.generateEmail());
        NAME_INPUT.sendKeys(GenerateTestData.generateFullName());
        ROLE_TITLE_INPUT.sendKeys(GenerateTestData.generateRoleTitle());
        new Dropdown(driver).selectRoleUser(inventNewUserModel.getRole());
        INVITE_BUTTON.click();
        return this;
    }


}
