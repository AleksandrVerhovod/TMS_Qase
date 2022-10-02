package pages;

import constants.Urls;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsListPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ProjectsListPage.class.getName());

    @FindBy(id = "createButton")
    private WebElement CREATE_PROJECT_BUTTON;

    @FindBy(xpath = "//a[text()='Demo Project']//ancestor::tr//button[@class='project-favorite-button']//i")
    private WebElement FAVORITE_PROJECT_BUTTON_NO_ACTIVE;

    @FindBy(xpath = "//a[text()='Demo Project']//ancestor::tr//button[@class='project-favorite-button active']//i")
    private WebElement FAVORITE_PROJECT_BUTTON_ACTIVE;

    @FindBy(xpath = "//a[@class='defect-title' and text()='Demo Project']")
    private WebElement SELECT_PROJECT;

    @FindBy(xpath = "//a[text()='DemoQAProject']//ancestor::tr//div[@class='dropdown']//a[@class='btn btn-dropdown']")
    private WebElement DROPDOWN_MENU;

    @FindBy(xpath = "//a[text()='DemoQAProject']//ancestor::tr//div[@class='dropdown']//a[text()='Delete']")
    private WebElement DROPDOWN_DELETE_BUTTON;

    @FindBy(xpath = "//button[@type='submit']//i")
    private WebElement DELETE_PROJECT_BUTTON;

    @FindBy(xpath = "//a[text()='DemoQAProject']")
    private WebElement NAME_DEMO_QA_PROJECT;

    public ProjectsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", CREATE_PROJECT_BUTTON));
        return CREATE_PROJECT_BUTTON.isDisplayed();
    }

    public boolean isCreateButtonDisplayed() {
        LOGGER.debug(String.format("Attempt to find button: %s", CREATE_PROJECT_BUTTON));
        return CREATE_PROJECT_BUTTON.isDisplayed();
    }

    public ProjectsListPage openProjectsListPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE.concat(Urls.PROJECTS_LIST_PAGE)));
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.PROJECTS_LIST_PAGE));
        return this;
    }

    public ProjectsListPage activateFavoriteProject() {
        LOGGER.debug(String.format("Attempt to click button: %s", FAVORITE_PROJECT_BUTTON_NO_ACTIVE));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", FAVORITE_PROJECT_BUTTON_NO_ACTIVE);
         return this;
    }

    public ProjectsListPage deActivateFavoriteProject() {
        LOGGER.debug(String.format("Attempt to click button: %s", FAVORITE_PROJECT_BUTTON_ACTIVE));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", FAVORITE_PROJECT_BUTTON_ACTIVE);
        return this;
    }

    public boolean isFavoriteButtonActiveDispalyed() {
        LOGGER.debug(String.format("Attempt to find favorite button: %s", FAVORITE_PROJECT_BUTTON_ACTIVE));
        return FAVORITE_PROJECT_BUTTON_ACTIVE.isDisplayed();
    }

    public boolean isFavoriteButtonDeactiveDispalyed() {
        LOGGER.debug(String.format("Attempt to find favorite button: %s", FAVORITE_PROJECT_BUTTON_NO_ACTIVE));
        return FAVORITE_PROJECT_BUTTON_NO_ACTIVE.isDisplayed();
    }

    public CreateProjectPage addNewProject() {
        LOGGER.debug(String.format("Attempt to click button: %s", CREATE_PROJECT_BUTTON));
        CREATE_PROJECT_BUTTON.click();
        return new CreateProjectPage(driver);
    }

    public ProjectsListPage deleteProject() {
        LOGGER.debug(String.format("Attempt to click button: %s", DROPDOWN_MENU));
        DROPDOWN_MENU.click();
        LOGGER.debug(String.format("Attempt to click button: %s", DROPDOWN_DELETE_BUTTON));
        DROPDOWN_DELETE_BUTTON.click();
        LOGGER.debug(String.format("Attempt to click button: %s", DELETE_PROJECT_BUTTON));
        DELETE_PROJECT_BUTTON.click();
        return this;
    }

    public boolean isProjectNameDisplayed() {
        LOGGER.debug(String.format("Check if name project is displayed: %s", NAME_DEMO_QA_PROJECT));
        try {
            return NAME_DEMO_QA_PROJECT.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
