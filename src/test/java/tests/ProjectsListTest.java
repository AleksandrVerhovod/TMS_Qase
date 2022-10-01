package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectRepositoryPage;
import pages.ProjectsListPage;
import pages.services.CreateDemoProject;
import pages.services.LoginSite;


public class ProjectsListTest extends BaseTest {

    @Test (priority = 1, description = "The user creates a new project with valid values for the fields")
    public void createProjectTest() {
        CreateDemoProject createDemoProject = new CreateDemoProject(getDriver());
        createDemoProject.loginForConfirm();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(getDriver());
        Assert.assertTrue(projectRepositoryPage.isImportButtonDisplayed(),"Demo project has not been created");
    }

    @Test (priority = 2, description = "The user creates a new project and then delete it")
    public void deleteProjectTest() {
        CreateDemoProject createDemoProject = new CreateDemoProject(getDriver());
        createDemoProject.loginForConfirm();
        ProjectsListPage projectsListPage = new ProjectsListPage(getDriver());
        projectsListPage.openProjectsListPage()
                .deleteProject();
        Assert.assertFalse(projectsListPage.isProjectNameDisplayed(), "Demo project has not been deleted");
    }

    @Test (priority = 3, description = "The user select favorite project from the list")
    public void selectFavoriteProjectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        loginSite.demoLogin();
        ProjectsListPage projectsListPage = new ProjectsListPage(getDriver());
        projectsListPage.activateFavoriteProject();
        Assert.assertTrue(projectsListPage.isFavoriteButtonActiveDispalyed(), "The favorite project is not selected");
    }

    //добавление фильтра


}
