package pages;

import constants.Urls;
import elements.DropdownTestRun;
import elements.TextArea;
import io.qameta.allure.Step;
import models.TestRunsModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.CreateProjectTest;

import static constants.Urls.QASE_LOGIN_PAGE;
import static constants.Urls.TEST_RUN_PAGE;

public class TestRunsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(TestRunsPage.class.getName());

    @FindBy(xpath = "//a[@id='start-new-test-run-button']")
    private WebElement START_NEW_TR_BUTTON;

    @FindBy(xpath = "//button[@id='save-run-button']")
    private WebElement START_RUN_BUTTON;


    @FindBy(xpath = "//span[text()='Run was created successfully!']")
    private WebElement CONFIRMATION_MESSAGE_CREATE_TC;

    @FindBy(xpath = "//button[@id='edit-run-add-cases-button']//i")
    private WebElement ADD_CASES_BUTTON;

    @FindBy(id = "select-cases-done-button")
    private WebElement DONE_TC_ADDED_BUTTON;

    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public TestRunsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", START_NEW_TR_BUTTON));
        return START_NEW_TR_BUTTON.isDisplayed();
    }
    @Step("Open test runs page")
    public TestRunsPage openTestRunsPage() {
        LOGGER.debug("Attempt to open URL: " + QASE_LOGIN_PAGE + TEST_RUN_PAGE);
        driver.get(QASE_LOGIN_PAGE.concat(Urls.TEST_RUN_PAGE));
        return this;
    }
    @Step("Click start new test run")
    public TestRunsPage clickStartNewTestRun() {
        LOGGER.debug(String.format("Attempt to find click button %s", START_NEW_TR_BUTTON));
        START_NEW_TR_BUTTON.click();
        return this;
    }

    @Step("Fill test run form by valid random data")
    public TestRunsPage fillStartTestRunForm(TestRunsModel testRunsModel) {
        LOGGER.debug("Attempt to fill test run's form");
        new TextArea(driver, "Description").inputTextArea(testRunsModel.getDescription());
        LOGGER.debug(String.format("Attempt to send description: %s", testRunsModel.getDescription()));
        new DropdownTestRun(driver, "Plan").selectOptionTestRun(testRunsModel.getPlan());
        LOGGER.debug(String.format("Attempt to select Plan: %s", testRunsModel.getPlan()));
        new DropdownTestRun(driver, "Environment").selectOptionTestRun(testRunsModel.getEnvironment());
        LOGGER.debug(String.format("Attempt to select Environment: %s", testRunsModel.getEnvironment()));
        new DropdownTestRun(driver, "Milestone").selectOptionTestRun(testRunsModel.getMilestone());
        LOGGER.debug(String.format("Attempt to select Milestone: %s", testRunsModel.getMilestone()));
        new DropdownTestRun(driver, "Default assignee").selectDefaultAssigneeTestRun(testRunsModel.getDefaultAssignee());
        LOGGER.debug(String.format("Attempt to select Default assignee: %s", testRunsModel.getDefaultAssignee()));
        js.executeScript("arguments[0].scrollIntoView()", ADD_CASES_BUTTON);
        LOGGER.debug(String.format("Attempt to find scroll to the button: %s", ADD_CASES_BUTTON));
        ADD_CASES_BUTTON.click();
        LOGGER.debug(String.format("Attempt to find click button: %s", ADD_CASES_BUTTON));
        DONE_TC_ADDED_BUTTON.click();
        LOGGER.debug(String.format("Attempt to click button: %s", DONE_TC_ADDED_BUTTON));
        return this;
    }
    @Step("Click 'StartTestRun' button")
    public TestRunsPage clickStartTestRun() {
        LOGGER.debug(String.format("Attempt to click button: %s", START_RUN_BUTTON));
        START_RUN_BUTTON.click();
        return this;
    }

    @Step("Check if confirmation message is displayed")
    public boolean isConfirmationMessageDispalyed() {
        LOGGER.debug(String.format("Attempt to find message: %s", CONFIRMATION_MESSAGE_CREATE_TC));
        return CONFIRMATION_MESSAGE_CREATE_TC.isDisplayed();
    }


}
