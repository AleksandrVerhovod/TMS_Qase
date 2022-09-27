package pages;

import constants.Urls;
import elements.Dropdowns;
import models.CreateDefectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefectsPage extends BasePage {

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
        return CREATE_NEW_DEFECT_BUTTON.isDisplayed();
    }

    public DefectsPage openDefectsPage() {
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.DEFECTS_PAGE));
        return this;
    }

    public DefectsPage clickCreateNewDefectButton() {
        CREATE_NEW_DEFECT_BUTTON.click();
        return this;
    }

    public DefectsPage sendCreateDefectForm(CreateDefectModel createDefectModel) {
        DEFECT_TITLE_INPUT.sendKeys(createDefectModel.getDefectTitle());
        ACTUAL_RESULT_INPUT.sendKeys(createDefectModel.getActualResult());
        new Dropdowns(driver).selectMilestoneDefect(createDefectModel.getMilestone());
        new Dropdowns(driver).selectSeverityDefect(createDefectModel.getSeverity());
        return this;
    }


    public DefectsPage clickCreateDefectButton() {
        CREATE_DEFECT_BUTTON.click();
        return this;
    }

    public boolean isSuccessCreateMessageDisplayed() {
        return SUCCESS_MESSAGE.isDisplayed();
    }


    public boolean isSuccessDeleteMessageDisplayed () {
        return SUCCESS_DELETE_MESSAGE.isDisplayed();
    }

    public void deleteDefect (String option) {
        String listFinalXpath = String.format(DEFECT_DROPDOWN_MENU,option);
        driver.findElement(By.xpath(listFinalXpath)).click();
        DELETE_BUTTON.click();
        ACCEPT_DELETE_BUTTON.click();
    }


}