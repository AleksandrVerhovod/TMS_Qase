package testdata;

import constants.Credentials;
import models.CreateProjectModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tests.CreateProjectTest;
import utils.GenerateTestData;

public class PrepareCreateProjectData {
    private static final Logger LOGGER = LogManager.getLogger(PrepareCreateProjectData.class.getName());
    public static CreateProjectModel getCreateProjectWithValidData() {
        LOGGER.info("Generate valid project data");
        return CreateProjectModel
                .builder()
                .projectName(GenerateTestData.generateProjectName())
                .projectCode(GenerateTestData.generateProjectCode())
                .descriptionProject(GenerateTestData.generateDescriptionProject())
                .build();
    }

    public static CreateProjectModel getCreateProjectWithConstantaData() {
        LOGGER.info("Generate constanta data for project");
        return CreateProjectModel
                .builder()
                .projectName(Credentials.DEMO_QA_PROJECT)
                .projectCode(GenerateTestData.generateProjectCode())
                .descriptionProject(GenerateTestData.generateDescriptionProject())
                .build();
    }
}
