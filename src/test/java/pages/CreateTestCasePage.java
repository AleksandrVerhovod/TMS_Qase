package pages;

import constants.Urls;
import elements.DropdownTestCase;
import elements.TextArea;
import models.CreateTestCaseModel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTestCasePage extends BasePage {

    @FindBy(id = "title")
    private WebElement TITLE_TEST_CASE;
    @FindBy (xpath = "//label[text()='Priority']//..//button[@type='button']")
    private WebElement PRIORITY;

    @FindBy (xpath = "//label[text()='Type']//..//button[@type='button']")
    private WebElement TYPE;

    @FindBy(xpath = "//div[contains(@class,'row')]//label[text()='Milestone']//..//span[@aria-live='polite']//..")
    private WebElement MILESTONE;



    @FindBy(id = "save-case")
    private WebElement SAVE_BUTTON;

    @FindBy(xpath = "//span[text()='Test case was created successfully!']")
    private WebElement CONFIRMATION_MESSAGE_CREATE_TC;

    @FindBy(xpath = "//a[@id='add-step']//i")
    private WebElement ADD_STEPS_BUTTON;

    @FindBy(xpath = "//div[@class='select-block']//..//button[@type='button']//div")
    private WebElement BUTTON_STEPS;
    @FindBy(xpath = "//div[text()='Classic']")
    private WebElement SELECT_STEPS_OPTION;
    private JavascriptExecutor js = (JavascriptExecutor) driver;


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

    public boolean isConfirmationMessageCreatTestCaseDisplayed() {
        return CONFIRMATION_MESSAGE_CREATE_TC.isDisplayed();
    }

    public void fillInAccountForm(CreateTestCaseModel newTestCase) {
        TITLE_TEST_CASE.sendKeys(newTestCase.getTitle());
        new DropdownTestCase(driver, "Status").selectOptionsInTestCase(newTestCase.getStatus());
        new TextArea(driver, "Description").inputTextArea(newTestCase.getDescription());
        new DropdownTestCase(driver, "Suite").selectOptionsInTestCase(newTestCase.getSuite());
        new DropdownTestCase(driver, "Severity").selectOptionsInTestCase(newTestCase.getSeverity());
        js.executeScript("arguments[0].scrollIntoView()", PRIORITY);
        new DropdownTestCase(driver, "Priority").selectOptionsInTestCase(newTestCase.getPriority());
        js.executeScript("arguments[0].scrollIntoView()", TYPE);
        new DropdownTestCase(driver, "Type").selectOptionsInTestCase(newTestCase.getType());
        new DropdownTestCase(driver, "Layer").selectOptionsInTestCase(newTestCase.getLayer());
        new DropdownTestCase(driver, "Is flaky").selectOptionsInTestCase(newTestCase.getIsFlaky());
        js.executeScript("arguments[0].scrollIntoView()", MILESTONE);
        new DropdownTestCase(driver, "Milestone").selectOptionsMilestoneInTestCase(newTestCase.getMilestone());
        new DropdownTestCase(driver, "Behavior").selectOptionsInTestCase(newTestCase.getBehavior());
        new DropdownTestCase(driver, "Automation status").selectOptionsInTestCase(newTestCase.getAutomationStatus());
        new TextArea(driver, "Pre-conditions").inputTextArea(newTestCase.getPreCondition());
        new TextArea(driver, "Post-conditions").inputTextArea(newTestCase.getPostConditions());
        js.executeScript("arguments[0].scrollIntoView()", BUTTON_STEPS);
        BUTTON_STEPS.click();
        SELECT_STEPS_OPTION.click();
        js.executeScript("arguments[0].scrollIntoView()", ADD_STEPS_BUTTON);
        ADD_STEPS_BUTTON.click();
        new TextArea(driver, "Action").inputTextArea(newTestCase.getAction());
        new TextArea(driver, "Input data").inputTextArea(newTestCase.getInputData());
        new TextArea(driver, "Expected result").inputTextArea(newTestCase.getExpectedResult());
        SAVE_BUTTON.click();
    }

}
