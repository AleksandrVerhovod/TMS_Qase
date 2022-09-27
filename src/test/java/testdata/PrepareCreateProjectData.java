package testdata;

import constants.Credentials;
import models.CreateProjectModel;
import utils.GenerateTestData;

public class PrepareCreateProjectData {

    public static CreateProjectModel getCreateProjectWithValidData() {
        return CreateProjectModel
                .builder()
                .projectName(GenerateTestData.generateProjectName())
                .projectCode(GenerateTestData.generateProjectCode())
                .descriptionProject(GenerateTestData.generateDescriptionProject())
                .build();
    }

    public static CreateProjectModel getCreateProjectWithConstantaData() {
        return CreateProjectModel
                .builder()
                .projectName(Credentials.DEMO_QA_PROJECT)
                .projectCode(GenerateTestData.generateProjectCode())
                .descriptionProject(GenerateTestData.generateDescriptionProject())
                .build();
    }
}
