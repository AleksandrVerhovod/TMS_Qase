package pages;

import constants.Urls;
import elements.DropdownTestRun;
import elements.TextArea;
import models.TestRunsModel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.Urls.QASE_LOGIN_PAGE;

public class TestRunsPage extends BasePage {

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
        return START_NEW_TR_BUTTON.isDisplayed();
    }

    public TestRunsPage openTestRunsPage() {
        driver.get(QASE_LOGIN_PAGE.concat(Urls.TEST_RUN_PAGE));
        return this;
    }

    public TestRunsPage clickStartNewTestRun() {
        START_NEW_TR_BUTTON.click();
        return this;
    }


    public TestRunsPage fillStartTestRunForm(TestRunsModel testRunsModel) {
        new TextArea(driver, "Description").inputTextArea(testRunsModel.getDescription());
        new DropdownTestRun(driver, "Plan").selectOptionTestRun(testRunsModel.getPlan());
        new DropdownTestRun(driver, "Environment").selectOptionTestRun(testRunsModel.getEnvironment());
        new DropdownTestRun(driver, "Milestone").selectOptionTestRun(testRunsModel.getMilestone());
        new DropdownTestRun(driver, "Default assignee").selectDefaultAssigneeTestRun(testRunsModel.getDefaultAssignee());
        js.executeScript("arguments[0].scrollIntoView(true)", ADD_CASES_BUTTON);
        ADD_CASES_BUTTON.click();
        DONE_TC_ADDED_BUTTON.click();
        return this;
    }

    public TestRunsPage clickStartTestRun() {
        START_RUN_BUTTON.click();
        return this;
    }


    public boolean isConfirmationMessageDispalyed() {
        return CONFIRMATION_MESSAGE_CREATE_TC.isDisplayed();
    }


}
