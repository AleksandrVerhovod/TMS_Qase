package pages;

import constants.Urls;
import elements.DropdownsRequirements;
import models.CreateRequirementsModel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateRequirementsPage extends BasePage {
    @FindBy(xpath = "//div[@class='requirements-page']//button//i")
    private WebElement CREATE_REQUIREMENT_BUTTON;

    @FindBy(id = "title")
    private WebElement TITLE_REQUIREMENT_INPUT;

    @FindBy(xpath = "//div[@id='descriptionGroup']//label[text()='Description']//..//p")
    private WebElement DESCRIPTION_INPUT;

    @FindBy(xpath = "//button[@id='save-case']")
    private WebElement SAVE_REQUIREMENT_BUTTON;

    private static final String REQUIREMENT_TITLE = "//div[@class='Pane vertical Pane1  ']//button//span[text()='%s']";

    public CreateRequirementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return CREATE_REQUIREMENT_BUTTON.isDisplayed();
    }

    public boolean getTitleRequirements(String option) {
        String titleFinalXpath = String.format(REQUIREMENT_TITLE, option);
        try {
            return driver.findElement(By.xpath(titleFinalXpath)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public CreateRequirementsPage openCreateReqPage() {
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.CREATE_REQUIREMENTS));
        return this;
    }

    public CreateRequirementsPage clickCreateReqButton() {
        CREATE_REQUIREMENT_BUTTON.click();
        return this;
    }


    public void fillNewRequirement(CreateRequirementsModel createRequirementsModel) {
        TITLE_REQUIREMENT_INPUT.sendKeys(createRequirementsModel.getTitle());
        DESCRIPTION_INPUT.sendKeys(createRequirementsModel.getDescription());
        new DropdownsRequirements(driver, "Parent").selectOptionDefect(createRequirementsModel.getParent());
        new DropdownsRequirements(driver, "Status").selectOptionDefect(createRequirementsModel.getStatus());
        new DropdownsRequirements(driver, "Type").selectOptionDefect(createRequirementsModel.getType());
        SAVE_REQUIREMENT_BUTTON.click();
    }


}
