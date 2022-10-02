package pages.services;

import models.InventNewUserModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CreateProjectPage;
import pages.LoginPage;
import pages.ProjectsListPage;
import tests.LogInTest;

public class CreateDemoProject {

    private final WebDriver driver;

    public CreateDemoProject(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger LOGGER = LogManager.getLogger(CreateDemoProject.class.getName());
    public void createProject() {
        ProjectsListPage projectsListPage = new ProjectsListPage(driver);
        LOGGER.debug(String.format("Page %s initialized", ProjectsListPage.class.getName()));
        LOGGER.debug("Add new project");
        projectsListPage.addNewProject();
        CreateProjectPage createProjectPage = new CreateProjectPage(driver);
        LOGGER.info(String.format("Prepared valid data by %s", CreateProjectPage.class.getName()));
        LOGGER.info("Input information into fields");
        createProjectPage.sendCreateConstantaProjectForm()
                .clickCreateProjectButton();
    }

}
