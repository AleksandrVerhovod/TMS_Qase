package pages;

import constants.Urls;
import elements.DropdownTestCase;
import elements.TextArea;
import models.CreateTestCaseModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTestCasePage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CreateTestCasePage.class.getName());
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
        LOGGER.debug(String.format("Attempt to find button: %s", SAVE_BUTTON));
        return SAVE_BUTTON.isDisplayed();
    }

    public boolean isConfirmationMessageCreatTestCaseDisplayed() {
        LOGGER.debug(String.format("Attempt to find message: %s", CONFIRMATION_MESSAGE_CREATE_TC));
        return CONFIRMATION_MESSAGE_CREATE_TC.isDisplayed();
    }

    public void fillInAccountForm(CreateTestCaseModel newTestCase) {
        TITLE_TEST_CASE.sendKeys(newTestCase.getTitle());
        LOGGER.debug(String.format("Input title: %s", newTestCase.getTitle()));
        new DropdownTestCase(driver, "Status").selectOptionsInTestCase(newTestCase.getStatus());
        LOGGER.debug(String.format("Attempt to select Status: %s", newTestCase.getStatus()));
        new TextArea(driver, "Description").inputTextArea(newTestCase.getDescription());
        LOGGER.debug(String.format("Attempt to select Description: %s", newTestCase.getDescription()));
        new DropdownTestCase(driver, "Suite").selectOptionsInTestCase(newTestCase.getSuite());
        LOGGER.debug(String.format("Attempt to select Suite: %s", newTestCase.getSuite()));
        new DropdownTestCase(driver, "Severity").selectOptionsInTestCase(newTestCase.getSeverity());
        LOGGER.debug(String.format("Attempt to select Severity: %s", newTestCase.getSeverity()));
        LOGGER.debug(String.format("Attempt to scroll to: %s", PRIORITY));
        js.executeScript("arguments[0].scrollIntoView()", PRIORITY);
        new DropdownTestCase(driver, "Priority").selectOptionsInTestCase(newTestCase.getPriority());
        LOGGER.debug(String.format("Attempt to select Priority: %s", newTestCase.getPriority()));
        LOGGER.debug(String.format("Attempt to scroll to: %s", TYPE));
        js.executeScript("arguments[0].scrollIntoView()", TYPE);
        new DropdownTestCase(driver, "Type").selectOptionsInTestCase(newTestCase.getType());
        LOGGER.debug(String.format("Attempt to select Type: %s", newTestCase.getType()));
        new DropdownTestCase(driver, "Layer").selectOptionsInTestCase(newTestCase.getLayer());
        LOGGER.debug(String.format("Attempt to select Layer: %s", newTestCase.getLayer()));
        new DropdownTestCase(driver, "Is flaky").selectOptionsInTestCase(newTestCase.getIsFlaky());
        LOGGER.debug(String.format("Attempt to select Is flaky: %s", newTestCase.getIsFlaky()));
        LOGGER.debug(String.format("Attempt to scroll to: %s", MILESTONE));
        js.executeScript("arguments[0].scrollIntoView()", MILESTONE);
        new DropdownTestCase(driver, "Milestone").selectOptionsMilestoneInTestCase(newTestCase.getMilestone());
        LOGGER.debug(String.format("Attempt to select Milestone: %s", newTestCase.getMilestone()));
        new DropdownTestCase(driver, "Behavior").selectOptionsInTestCase(newTestCase.getBehavior());
        LOGGER.debug(String.format("Attempt to select Behavior: %s", newTestCase.getBehavior()));
        new DropdownTestCase(driver, "Automation status").selectOptionsInTestCase(newTestCase.getAutomationStatus());
        LOGGER.debug(String.format("Attempt to select Automation status: %s", newTestCase.getAutomationStatus()));
        new TextArea(driver, "Pre-conditions").inputTextArea(newTestCase.getPreCondition());
        LOGGER.debug(String.format("Input Pre-conditions: %s", newTestCase.getPreCondition()));
        new TextArea(driver, "Post-conditions").inputTextArea(newTestCase.getPostConditions());
        LOGGER.debug(String.format("Input Post-conditions: %s", newTestCase.getPostConditions()));
        LOGGER.debug(String.format("Attempt to scroll to: %s", BUTTON_STEPS));
        js.executeScript("arguments[0].scrollIntoView()", BUTTON_STEPS);
        LOGGER.debug(String.format("Attempt to click button: %s", BUTTON_STEPS));
        BUTTON_STEPS.click();
        LOGGER.debug(String.format("Attempt to click button: %s", SELECT_STEPS_OPTION));
        SELECT_STEPS_OPTION.click();
        LOGGER.debug(String.format("Attempt to scroll to: %s", ADD_STEPS_BUTTON));
        js.executeScript("arguments[0].scrollIntoView()", ADD_STEPS_BUTTON);
        LOGGER.debug(String.format("Attempt to click button: %s", ADD_STEPS_BUTTON));
        ADD_STEPS_BUTTON.click();
        new TextArea(driver, "Action").inputTextArea(newTestCase.getAction());
        LOGGER.debug(String.format("Input Action: %s", newTestCase.getAction()));
        new TextArea(driver, "Input data").inputTextArea(newTestCase.getInputData());
        LOGGER.debug(String.format("Input data: %s", newTestCase.getInputData()));
        new TextArea(driver, "Expected result").inputTextArea(newTestCase.getExpectedResult());
        LOGGER.debug(String.format("Input Expected result: %s", newTestCase.getExpectedResult()));
        LOGGER.debug(String.format("Attempt to click button: %s", SAVE_BUTTON));
        SAVE_BUTTON.click();
    }

}
