package tests;

import models.CreateProjectModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateProjectPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsListPage;
import pages.services.LoginSite;
import testdata.PrepareCreateProjectData;

public class CreateProjectTest extends BaseTest {

    @Test
    public void createNewProjectTest() {
        LoginSite loginSite = new LoginSite(driver);
        loginSite.demoLogin();
        ProjectsListPage projectsListPage = new ProjectsListPage(driver);
        projectsListPage.addNewProject();
        CreateProjectPage createProjectPage = new CreateProjectPage(driver);
        CreateProjectModel createProjectModel = PrepareCreateProjectData.getCreateProjectWithValidData();
        createProjectPage.sendCreateRandomProjectForm(createProjectModel)
                .clickCreateProjectButton();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(driver);
        Assert.assertTrue(projectRepositoryPage.isImportButtonDisplayed(), "'Import' button don't displayed ");
    }

}
