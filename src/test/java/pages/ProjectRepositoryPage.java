package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectRepositoryPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ProjectRepositoryPage.class.getName());

    @FindBy(xpath = "//a[@id='create-case-button']")
    private WebElement CREATE_CASE_BUTTON;

    @FindBy(xpath = "//a[@id='create-suite-button']")
    private WebElement CREATE_SUITE_BUTTON;
    @FindBy(xpath = "//span[text()='Import']//..")
    private WebElement IMPORT_BUTTON;


    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return CREATE_CASE_BUTTON.isDisplayed();
    }

    @Step("Check 'Import' button is displayed")
    public boolean isImportButtonDisplayed() {
        return IMPORT_BUTTON.isDisplayed();
    }

    @Step("Open project repository page")
    public ProjectRepositoryPage openProjectRepositoryPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE.concat(Urls.PROJECT_PAGE)));
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.PROJECT_PAGE));
        return this;
    }
    @Step("Click '+ test case' button")
    public CreateTestCasePage clickAddTestCase() {
        LOGGER.debug(String.format("Attempt to click button: %s", CREATE_CASE_BUTTON));
        CREATE_CASE_BUTTON.click();
        return new CreateTestCasePage(driver);
    }
    @Step("Click '+ test suite' button")
    public CreateTestCasePage clickAddTestSuite() {
        LOGGER.debug(String.format("Attempt to click button: %s", CREATE_SUITE_BUTTON));
        CREATE_SUITE_BUTTON.click();
        return new CreateTestCasePage(driver);
    }


}
