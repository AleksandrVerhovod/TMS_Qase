package pages;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectRepositoryPage extends BasePage {

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

    public boolean isImportButtonDisplayed() {
        return IMPORT_BUTTON.isDisplayed();
    }

    public ProjectRepositoryPage openProjectRepositoryPage() {
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.PROJECT_PAGE));
        return this;
    }

    public CreateTestCasePage clickAddTestCase() {
        CREATE_CASE_BUTTON.click();
        return new CreateTestCasePage(driver);
    }

    public CreateTestCasePage clickAddTestSuite() {
        CREATE_SUITE_BUTTON.click();
        return new CreateTestCasePage(driver);
    }


}
