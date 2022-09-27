package pages;

import constants.Urls;
import elements.DropdownTestCase;
import elements.TextArea;
import models.CreateTestCaseModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTestCasePage extends BasePage {

    @FindBy(id = "title")
    private WebElement TITLE_TEST_CASE;

    @FindBy(id = "save-case")
    private WebElement SAVE_BUTTON;

    @FindBy (xpath = "//span[text()='Test case was created successfully!']")
    private WebElement CONFIRMATION_MESSAGE_CREATE_TC;


    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isPageOpened() {
        return SAVE_BUTTON.isDisplayed();
    }
    public CreateTestCasePage openCreateTestCasePage() {
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.CREATE_TEST_CASE));
        return this;
    }

    public boolean isConfirmationMessageCreatTestCaseDisplayed () {
        return CONFIRMATION_MESSAGE_CREATE_TC.isDisplayed();
    }
    public void fillInAccountForm(CreateTestCaseModel newTestCase) {
        TITLE_TEST_CASE.sendKeys(newTestCase.getTitle());
        new DropdownTestCase(driver, "Status").selectOptionsInTestCase(newTestCase.getStatus());
        new TextArea(driver, "Description").inputTextArea(newTestCase.getDescription());
        new DropdownTestCase(driver,"Severity").selectOptionsInTestCase(newTestCase.getSeverity());
        new DropdownTestCase(driver, "Priority").selectOptionsInTestCase(newTestCase.getPriority());
        new DropdownTestCase(driver,"Type").selectOptionsInTestCase(newTestCase.getType());
        new DropdownTestCase(driver,"Layer").selectOptionsInTestCase(newTestCase.getLayer());
        new DropdownTestCase(driver,"Is flaky").selectOptionsInTestCase(newTestCase.getIsFlaky());
        new DropdownTestCase(driver,"Behavior").selectOptionsInTestCase(newTestCase.getBehavior());
        new DropdownTestCase(driver,"Automation status").selectOptionsInTestCase(newTestCase.getAutomationStatus());
        new TextArea(driver,"Pre-conditions").inputTextArea(newTestCase.getPreCondition());
        new TextArea(driver,"Post-conditions").inputTextArea(newTestCase.getPostConditions());
        SAVE_BUTTON.click();
    }

}
