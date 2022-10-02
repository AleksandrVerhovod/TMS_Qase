package pages;

import constants.Urls;
import elements.Dropdowns;
import models.CreateDefectModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GenerateTestData;

public class DefectsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(DefectsPage.class.getName());
    @FindBy(xpath = "//input[@id='title']")
    private WebElement DEFECT_TITLE_INPUT;

    @FindBy(xpath = "//div[@class='ProseMirror toastui-editor-contents']")
    private WebElement ACTUAL_RESULT_INPUT;

    @FindBy(xpath = "//a[text()='Create new defect']")
    private WebElement CREATE_NEW_DEFECT_BUTTON;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement CREATE_DEFECT_BUTTON;

    @FindBy(xpath = "//span[text()='Defect was created successfully!']")
    private WebElement SUCCESS_MESSAGE;

    @FindBy(xpath = "//a[@class='text-danger']//..")
    private WebElement DELETE_BUTTON;

    @FindBy(xpath = "//button//span[text()='Delete']")
    private WebElement ACCEPT_DELETE_BUTTON;

    @FindBy(xpath = "//span[contains (text(),'successfully deleted')]")
    private WebElement SUCCESS_DELETE_MESSAGE;



    private static final String DEFECT_DROPDOWN_MENU = "//a[@class='defect-title' and text()='%s']//ancestor::tr//div[@class='dropdown']//a[contains(@class, 'dropdown')]";

    public DefectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", CREATE_NEW_DEFECT_BUTTON));
        return CREATE_NEW_DEFECT_BUTTON.isDisplayed();
    }

    public DefectsPage openDefectsPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE.concat(Urls.DEFECTS_PAGE)));
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.DEFECTS_PAGE));
        return this;
    }

    public DefectsPage clickCreateNewDefectButton() {
        LOGGER.debug(String.format("Attempt to click button: %s", CREATE_NEW_DEFECT_BUTTON));
        CREATE_NEW_DEFECT_BUTTON.click();
        return this;
    }

    public DefectsPage sendCreateDefectForm(CreateDefectModel createDefectModel) {
        DEFECT_TITLE_INPUT.sendKeys(createDefectModel.getDefectTitle());
        LOGGER.debug(String.format("Input defect title: %s", createDefectModel.getDefectTitle()));
        ACTUAL_RESULT_INPUT.sendKeys(createDefectModel.getActualResult());
        LOGGER.debug(String.format("Input actual result: %s", createDefectModel.getActualResult()));
        new Dropdowns(driver,"Milestone").selectOptionDefect(createDefectModel.getMilestone());
        LOGGER.debug(String.format("Attempt to select Milestone: %s", createDefectModel.getMilestone()));
        new Dropdowns(driver,"Severity").selectOptionDefect(createDefectModel.getSeverity());
        LOGGER.debug(String.format("Attempt to select Severity: %s", createDefectModel.getSeverity()));
        return this;
    }


    public DefectsPage clickCreateDefectButton() {
        LOGGER.debug(String.format("Attempt to click button: %s", CREATE_DEFECT_BUTTON));
        CREATE_DEFECT_BUTTON.click();
        return this;
    }

    public boolean isSuccessCreateMessageDisplayed() {
        LOGGER.debug(String.format("Attempt to find message: %s", SUCCESS_MESSAGE));
        return SUCCESS_MESSAGE.isDisplayed();
    }


    public boolean isSuccessDeleteMessageDisplayed () {
        LOGGER.debug(String.format("Attempt to find message: %s", SUCCESS_DELETE_MESSAGE));
        return SUCCESS_DELETE_MESSAGE.isDisplayed();
    }

    public void deleteDefect (String option) {
        String listFinalXpath = String.format(DEFECT_DROPDOWN_MENU,option);
        driver.findElement(By.xpath(listFinalXpath)).click();
        LOGGER.debug(String.format("Attempt to find message: %s", DELETE_BUTTON));
        DELETE_BUTTON.click();
        LOGGER.debug(String.format("Attempt to find message: %s", ACCEPT_DELETE_BUTTON));
        ACCEPT_DELETE_BUTTON.click();
    }


}