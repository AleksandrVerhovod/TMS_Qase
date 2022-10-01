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

    @Test (description = "The user creates a new project with valid values for the fields")
    public void createNewProjectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        loginSite.demoLogin();
        ProjectsListPage projectsListPage = new ProjectsListPage(getDriver());
        projectsListPage.addNewProject();
        CreateProjectPage createProjectPage = new CreateProjectPage(getDriver());
        CreateProjectModel createProjectModel = PrepareCreateProjectData.getCreateProjectWithValidData();
        createProjectPage.sendCreateRandomProjectForm(createProjectModel)
                .clickCreateProjectButton();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(getDriver());
        Assert.assertTrue(projectRepositoryPage.isImportButtonDisplayed(), "'Import' button don't displayed ");
    }

}
