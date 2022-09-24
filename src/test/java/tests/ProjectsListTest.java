package tests;

import org.testng.annotations.Test;
import pages.ProjectsListPage;
import pages.services.RegistrationOnSite;

public class ProjectsListTest extends BaseTest{

    //добавление проекта
    @Test
    public void createNewProjectTest () {
        RegistrationOnSite registrationOnSite = new RegistrationOnSite(driver);
        registrationOnSite.standartLogin();
        ProjectsListPage projectsListPage = new ProjectsListPage(driver);
        projectsListPage.addNewProject();
    }

    //удаление проекта

    //избранный проект


}
