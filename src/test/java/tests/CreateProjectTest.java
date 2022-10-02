package tests;

import models.CreateProjectModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateProjectPage;
import pages.CreateRequirementsPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsListPage;
import pages.services.LoginSite;
import testdata.PrepareCreateProjectData;
import testdata.PrepareCreateRequirementsData;
import testdata.PrepareRegistrationData;

public class CreateProjectTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CreateProjectTest.class.getName());
    @Test (description = "The user creates a new project with valid values for the fields")
    public void createNewProjectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
        loginSite.demoLogin();
        LOGGER.info("Demo Login done");
        ProjectsListPage projectsListPage = new ProjectsListPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectsListPage.class.getName()));
        projectsListPage.addNewProject();
        LOGGER.info("Added new project");
        CreateProjectPage createProjectPage = new CreateProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", CreateProjectPage.class.getName()));
        CreateProjectModel createProjectModel = PrepareCreateProjectData.getCreateProjectWithValidData();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareCreateProjectData.class.getName()));
        createProjectPage.sendCreateRandomProjectForm(createProjectModel)
                .clickCreateProjectButton();
        ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectRepositoryPage.class.getName()));
        LOGGER.info("Check if button is displayed");
        Assert.assertTrue(projectRepositoryPage.isImportButtonDisplayed(), "'Import' button don't displayed ");
    }

}
