package pages;

import constants.Urls;
import elements.DropdownsRequirements;
import io.qameta.allure.Step;
import models.CreateRequirementsModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateRequirementsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CreateRequirementsPage.class.getName());
    @FindBy(xpath = "//div[@class='requirements-page']//button//i")
    private WebElement CREATE_REQUIREMENT_BUTTON;

    @FindBy(id = "title")
    private WebElement TITLE_REQUIREMENT_INPUT;

    @FindBy(xpath = "//div[@id='descriptionGroup']//label[text()='Description']//..//input")
    private WebElement DESCRIPTION_INPUT;

    @FindBy(xpath = "//button[@id='save-case']")
    private WebElement SAVE_REQUIREMENT_BUTTON;

    private static final String REQUIREMENT_TITLE = "//div[@class='Pane vertical Pane1  ']//button//span[text()='%s']";

    public CreateRequirementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", CREATE_REQUIREMENT_BUTTON));
        return CREATE_REQUIREMENT_BUTTON.isDisplayed();
    }
    @Step("Get title created requirement Project")
    public boolean getTitleRequirements(String option) {
        String titleFinalXpath = String.format(REQUIREMENT_TITLE, option);
        try {
            LOGGER.debug(String.format("Attempt to find button: %s", titleFinalXpath));
            return driver.findElement(By.xpath(titleFinalXpath)).isDisplayed();
        } catch (NoSuchElementException e) {
            LOGGER.debug("NoSuchElementException");
            return false;
        }
    }
    @Step("Open create requirements page")
    public CreateRequirementsPage openCreateReqPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE.concat(Urls.CREATE_REQUIREMENTS)));
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.CREATE_REQUIREMENTS));
        return this;
    }
    @Step("Click 'Create requirement' button")
    public CreateRequirementsPage clickCreateReqButton() {
        LOGGER.debug(String.format("Attempt to click button: %s", CREATE_REQUIREMENT_BUTTON));
        CREATE_REQUIREMENT_BUTTON.click();
        return this;
    }

    @Step("Fill requirement form")
    public void fillNewRequirement(CreateRequirementsModel createRequirementsModel) {
        TITLE_REQUIREMENT_INPUT.sendKeys(createRequirementsModel.getTitle());
        LOGGER.debug(String.format("Input title: %s", createRequirementsModel.getTitle()));
        DESCRIPTION_INPUT.sendKeys(createRequirementsModel.getDescription());
        LOGGER.debug(String.format("Input description: %s", createRequirementsModel.getDescription()));
        new DropdownsRequirements(driver, "Parent").selectOptionDefect(createRequirementsModel.getParent());
        LOGGER.debug(String.format("Attempt to select Parent: %s", createRequirementsModel.getParent()));
        new DropdownsRequirements(driver, "Status").selectOptionDefect(createRequirementsModel.getStatus());
        LOGGER.debug(String.format("Attempt to select Status: %s", createRequirementsModel.getStatus()));
        new DropdownsRequirements(driver, "Type").selectOptionDefect(createRequirementsModel.getType());
        LOGGER.debug(String.format("Attempt to select Type: %s", createRequirementsModel.getType()));
        LOGGER.debug(String.format("Attempt to click button: %s", SAVE_REQUIREMENT_BUTTON));
        SAVE_REQUIREMENT_BUTTON.click();
    }


}
