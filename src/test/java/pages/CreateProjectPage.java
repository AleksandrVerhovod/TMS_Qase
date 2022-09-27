package pages;

import constants.Credentials;
import models.CreateProjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProjectPage extends BasePage {

    @FindBy(xpath = "//button[text()='Create project']")
    private WebElement CREATE_PROJECT_BUTTON;

    @FindBy(xpath = "//input[@id='inputTitle']")
    private WebElement INPUT_PROJECT_NAME;

    @FindBy(xpath = "//input[@id='inputCode']")
    private WebElement INPUT_PROJECT_CODE;

    @FindBy(css = "#inputDescription")
    private WebElement INPUT_PROJECT_DESCRIPTION;

    @FindBy(css = "#private-access-type")
    private WebElement BUTTON_PRIVATE_PROJECT_TYPE;

    @FindBy(css = "public-access-type")
    private WebElement BUTTON_PUBLIC_PROJECT_TYPE;

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return CREATE_PROJECT_BUTTON.isDisplayed();
    }

    public CreateProjectPage sendCreateConstantaProjectForm() {
        INPUT_PROJECT_NAME.sendKeys(Credentials.DEMO_QA_PROJECT);
        INPUT_PROJECT_CODE.clear();
        INPUT_PROJECT_CODE.sendKeys("DemoCode");
        INPUT_PROJECT_DESCRIPTION.sendKeys("Description");
        return this;
    }

    public CreateProjectPage sendCreateRandomProjectForm(CreateProjectModel newProjectModel) {
        INPUT_PROJECT_NAME.sendKeys(newProjectModel.getProjectName());
        INPUT_PROJECT_CODE.clear();
        INPUT_PROJECT_CODE.sendKeys(newProjectModel.getProjectCode());
        INPUT_PROJECT_DESCRIPTION.sendKeys(newProjectModel.getDescriptionProject());
        return this;
    }

    public CreateProjectPage clickPrivateProjectType() {
        BUTTON_PRIVATE_PROJECT_TYPE.click();
        return this;
    }

    public CreateProjectPage clickPublicProjectType() {
        BUTTON_PUBLIC_PROJECT_TYPE.click();
        return this;
    }

    public ProjectRepositoryPage clickCreateProjectButton() {
        CREATE_PROJECT_BUTTON.click();
        return new ProjectRepositoryPage(driver);
    }

}
