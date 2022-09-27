package pages.services;

import org.openqa.selenium.WebDriver;
import pages.CreateProjectPage;
import pages.ProjectsListPage;

public class CreateDemoProject {

    private final WebDriver driver;

    public CreateDemoProject(WebDriver driver) {
        this.driver = driver;
    }

    public void loginForConfirm() {
        LoginSite registrationOnSite = new LoginSite(driver);
        registrationOnSite.demoLogin();
        ProjectsListPage projectsListPage = new ProjectsListPage(driver);
        projectsListPage.addNewProject();
        CreateProjectPage createProjectPage = new CreateProjectPage(driver);
        createProjectPage.sendCreateConstantaProjectForm()
                .clickCreateProjectButton();
    }

}
