package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsListPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(id = "createButton")
    private WebElement CREATE_PROJECT_BUTTON;

    @FindBy(xpath = "//a[text()='Demo Project']//ancestor::tr//button[@class='project-favorite-button']")
    private WebElement FAVORITE_PROJECT_BUTTON;

    @FindBy(xpath = "//a[@class='defect-title' and text()='Demo Project']")
    private WebElement SELECT_PROJECT;

    @FindBy(xpath = "//a[text()='DemoQAProject']//ancestor::tr//div[@class='dropdown']//a[@class='btn btn-dropdown']")
    private WebElement DROPDOWN_MENU;

    @FindBy(xpath = "//a[text()='DemoQAProject']//ancestor::tr//div[@class='dropdown']//a[text()='Delete']")
    private WebElement DROPDOWN_DELETE_BUTTON;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement DELETE_PROJECT_BUTTON;

    @FindBy(xpath = "//a[text()='DemoQAProject']")
    private WebElement NAME_DEMO_QA_PROJECT;

    public ProjectsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Find Submit button on the Projects Page: %s", CREATE_PROJECT_BUTTON));
        return CREATE_PROJECT_BUTTON.isDisplayed();
    }

    public boolean isCreateButtonDisplayed() {
        return CREATE_PROJECT_BUTTON.isDisplayed();
    }

    public ProjectsListPage activateFavoriteProject() {
        FAVORITE_PROJECT_BUTTON.click();
        return this;
    }

    public CreateProjectPage addNewProject() {
        CREATE_PROJECT_BUTTON.click();
        return new CreateProjectPage(driver);
    }

    public ProjectsListPage deleteProject() {
        DROPDOWN_MENU.click();
        DROPDOWN_DELETE_BUTTON.click();
        DELETE_PROJECT_BUTTON.click();
        return this;
    }

    public boolean isProjectNameDisplayed() {
        return NAME_DEMO_QA_PROJECT.isDisplayed();
    }


}
