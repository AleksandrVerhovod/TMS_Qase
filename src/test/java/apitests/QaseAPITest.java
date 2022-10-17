package apitests;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class QaseAPITest {
    private static final Logger LOGGER = LogManager.getLogger(QaseAPITest.class.getName());
    private String projectCode;

    @Test(priority = 1)
    @Description("Create a project test")
    public void createProjectTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        LOGGER.warn("Prepare data for body request");
        ProjectAPIModel projectAPI = PrepareAPIData.getProjectData();
        LOGGER.info("Sending a POST request to create a project");
        projectCode = String.valueOf(given()
                .body(projectAPI)
                .when()
                .header("token", Credentials.TOKEN)
                .post(Urls.POST_ADD_PROJECT)
                .then()
                .body("status", equalTo(true)));
    }

    @Test(priority = 2)
    @Description("Delete project test")
    public void deleteProjectTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        ProjectAPIModel projectAPIModel = PrepareAPIData.getProjectCode();
        LOGGER.info("Sending a DELETE request to delete a project");
        projectCode = String.valueOf(given()
                .body(projectAPIModel)
                .when()
                .header("token", Credentials.TOKEN)
                .delete(String.format(Urls.DELETE_API_PROJECT, "APITEST"))
                .then()
                .body("status", equalTo(true)));
    }

    @Test(priority = 2)
    @Description("Test for finding an error when requesting an incorrect address")
    public void getAllProjectsNegativeTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecError404());
        LOGGER.info("Sending a GET request to get a list of projects");
        given()
                .when()
                .get(Urls.GET_ALL_PROJECTSWrong)
                .then()
                .log().body();
    }
}
