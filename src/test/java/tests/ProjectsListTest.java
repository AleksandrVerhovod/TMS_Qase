package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectRepositoryPage;
import pages.ProjectsListPage;
import pages.services.CreateDemoProject;
import pages.services.LoginSite;


public class ProjectsListTest extends BaseTest {

    @Test
    public void deleteProjectTest() {
        CreateDemoProject createDemoProject = new CreateDemoProject(driver);
        createDemoProject.loginForConfirm();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(driver);
        Assert.assertTrue(projectRepositoryPage.isImportButtonDisplayed(), "Demo project has not been created");
        ProjectsListPage projectsListPage = new ProjectsListPage(driver);
        projectsListPage.openProjectsListPage()
                .deleteProject();
        Assert.assertFalse(projectsListPage.isProjectNameDisplayed(), "Demo project has not been deleted");
    }

    @Test
    public void selectFavoriteProjectTest() {
        LoginSite loginSite = new LoginSite(driver);
        loginSite.demoLogin();
        ProjectsListPage projectsListPage = new ProjectsListPage(driver);
        projectsListPage.activateFavoriteProject();
        Assert.assertTrue(projectsListPage.isFavoriteButtonActiveDispalyed(), "The favorite project is not selected");
    }

    //добавление фильтра


}
