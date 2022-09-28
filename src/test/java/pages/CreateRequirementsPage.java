package pages;

import constants.Urls;
import elements.DropdownsRequirements;
import models.CreateRequirementsModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateRequirementsPage extends BasePage{
    @FindBy (xpath = "//div[@class='requirements-page']//button//i")
    private WebElement CREATE_REQUIREMENT_BUTTON;

    @FindBy (id = "title")
    private WebElement TITLE_REQUIREMENT_INPUT;

    @FindBy (xpath = "//div[@id='descriptionGroup']//label[text()='Description']//..//p")
    private WebElement DESCRIPTION_INPUT;

    @FindBy (id = "#edit-run-add-cases-button")
    private WebElement ADD_CASES_BUTTON;

    @FindBy (xpath = "//button[@id='save-case']")
    private WebElement SAVE_REQUIREMENT_BUTTON;



    public CreateRequirementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return CREATE_REQUIREMENT_BUTTON.isDisplayed();
    }

    public CreateRequirementsPage openCreateReqPage () {
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.CREATE_REQUIREMENTS));
        return this;
    }

    public CreateRequirementsPage clickCreateReqButton () {
        CREATE_REQUIREMENT_BUTTON.click();
        return this;
    }

    public CreateRequirementsPage clickSaveReqButton () {
        SAVE_REQUIREMENT_BUTTON.click();
        return this;
    }

    public void fillNewRequirement (CreateRequirementsModel createRequirementsModel) {
        TITLE_REQUIREMENT_INPUT.sendKeys(createRequirementsModel.getTitle());
        DESCRIPTION_INPUT.sendKeys(createRequirementsModel.getDescription());
        new DropdownsRequirements(driver, "Parent").selectOptionDefect(createRequirementsModel.getParent());
        new DropdownsRequirements(driver, "Status").selectOptionDefect(createRequirementsModel.getStatus());
        new DropdownsRequirements(driver,"Type").selectOptionDefect(createRequirementsModel.getType());
        SAVE_REQUIREMENT_BUTTON.click();
    }
}
