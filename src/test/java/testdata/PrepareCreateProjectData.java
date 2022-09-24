package testdata;

import constants.Credentials;
import models.CreateProjectModel;
import models.RegistrationModel;
import utils.FakeMessageGenerator;

public class PrepareCreateProjectData {

    public static CreateProjectModel getCreateProjectWithValidData() {
        return CreateProjectModel
                .builder()
                .projectName(FakeMessageGenerator.generateProjectName())
                .projectCode(FakeMessageGenerator.generateProjectCode())
                .descriptionProject(FakeMessageGenerator.generateDescriptionProject())
                .build();
    }

    public static CreateProjectModel getCreateProjectWithConstantaData() {
        return CreateProjectModel
                .builder()
                .projectName(Credentials.DEMO_QA_PROJECT)
                .projectCode(FakeMessageGenerator.generateProjectCode())
                .descriptionProject(FakeMessageGenerator.generateDescriptionProject())
                .build();
    }
}
