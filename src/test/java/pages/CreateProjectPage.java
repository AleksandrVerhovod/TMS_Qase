package pages;

import constants.Credentials;
import models.CreateProjectModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProjectPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CreateProjectPage.class.getName());

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
        LOGGER.debug(String.format("Attempt to find button: %s", CREATE_PROJECT_BUTTON));
        return CREATE_PROJECT_BUTTON.isDisplayed();
    }

    public CreateProjectPage sendCreateConstantaProjectForm() {
        INPUT_PROJECT_NAME.sendKeys(Credentials.DEMO_QA_PROJECT);
        LOGGER.debug(String.format("Input project name: %s", Credentials.DEMO_QA_PROJECT));
        LOGGER.debug(String.format("Attempt to clear: %s", INPUT_PROJECT_CODE));
        INPUT_PROJECT_CODE.clear();
        INPUT_PROJECT_CODE.sendKeys("DemoCode");
        LOGGER.debug(String.format("Input project code: DemoCode"));
        INPUT_PROJECT_DESCRIPTION.sendKeys("Description");
        LOGGER.debug(String.format("Input project code: Description"));
        return this;
    }

    public CreateProjectPage sendCreateRandomProjectForm(CreateProjectModel newProjectModel) {
        INPUT_PROJECT_NAME.sendKeys(newProjectModel.getProjectName());
        LOGGER.debug(String.format("Input project name: %s", Credentials.DEMO_QA_PROJECT));
        LOGGER.debug(String.format("Attempt to clear: %s", INPUT_PROJECT_CODE));
        INPUT_PROJECT_CODE.clear();
        INPUT_PROJECT_CODE.sendKeys(newProjectModel.getProjectCode());
        LOGGER.debug(String.format("Input project code: %s", newProjectModel.getProjectCode()));
        INPUT_PROJECT_DESCRIPTION.sendKeys(newProjectModel.getDescriptionProject());
        LOGGER.debug(String.format("Input project description: %s", newProjectModel.getDescriptionProject()));
        return this;
    }

    public CreateProjectPage clickPrivateProjectType() {
        LOGGER.debug(String.format("Attempt to click button: %s", BUTTON_PRIVATE_PROJECT_TYPE));
        BUTTON_PRIVATE_PROJECT_TYPE.click();
        return this;
    }

    public CreateProjectPage clickPublicProjectType() {
        LOGGER.debug(String.format("Attempt to click button: %s", BUTTON_PUBLIC_PROJECT_TYPE));
        BUTTON_PUBLIC_PROJECT_TYPE.click();
        return this;
    }

    public ProjectRepositoryPage clickCreateProjectButton() {
        LOGGER.debug(String.format("Attempt to click button: %s", CREATE_PROJECT_BUTTON));
        CREATE_PROJECT_BUTTON.click();
        return new ProjectRepositoryPage(driver);
    }

}
