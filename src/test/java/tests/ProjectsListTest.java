package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsListPage;
import pages.services.CreateDemoProject;
import pages.services.LoginSite;
import testdata.PrepareRegistrationData;


public class ProjectsListTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(ProjectsListTest.class.getName());

    @Test (priority = 1, description = "The user creates a new project with valid values for the fields")
    public void createProjectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginPage.class.getName()));
        loginSite.demoLogin();
        LOGGER.info("Log in to the site");
        CreateDemoProject createDemoProject = new CreateDemoProject(getDriver());
        LOGGER.info(String.format("Page %s initialized", CreateDemoProject.class.getName()));
        createDemoProject.createProject();
        LOGGER.info("Create project");
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectRepositoryPage.class.getName()));
        LOGGER.info("Check if button is displayed");
        Assert.assertTrue(projectRepositoryPage.isImportButtonDisplayed(),"Demo project has not been created");
    }

    @Test (priority = 2, description = "The user creates a new project and then delete it")
    public void deleteProjectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginPage.class.getName()));
        loginSite.demoLogin();
        LOGGER.info("Log in to the site");
        CreateDemoProject createDemoProject = new CreateDemoProject(getDriver());
        LOGGER.info(String.format("Page %s initialized", CreateDemoProject.class.getName()));
        createDemoProject.createProject();
        LOGGER.info("Create project");
        ProjectsListPage projectsListPage = new ProjectsListPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectsListPage.class.getName()));
        LOGGER.info(String.format("Open %s page and delete project",ProjectsListPage.class.getName()));
        projectsListPage.openProjectsListPage()
                .deleteProject();
        LOGGER.info("Project deleted");
        LOGGER.info("Check if confirm message is displayed");
        Assert.assertFalse(projectsListPage.isProjectNameDisplayed(), "Demo project has not been deleted");
    }

    @Test (priority = 3, description = "The user select favorite project from the list")
    public void selectFavoriteProjectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page",LoginPage.class.getName()));
        loginSite.demoLogin();
        LOGGER.info("Log in to the site");
        ProjectsListPage projectsListPage = new ProjectsListPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectsListPage.class.getName()));
        projectsListPage.activateFavoriteProject();
        LOGGER.info("Favorite project activated");
        LOGGER.info("Check if accepted favorite button is displayed");
        Assert.assertTrue(projectsListPage.isFavoriteButtonActiveDispalyed(), "The favorite project is not selected");
    }

}
