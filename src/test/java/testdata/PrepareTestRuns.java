package testdata;

import models.RegistrationModel;
import models.TestRunsModel;
import utils.GenerateTestData;

public class PrepareTestRuns {

    public static TestRunsModel getTestRunModelValidData() {
        return TestRunsModel
                .builder()
                .description(GenerateTestData.generateDescription())
                .plan(GenerateTestData.getPlan())
                .environment(GenerateTestData.getEnvironment())
                .milestone(GenerateTestData.getIsMilestoneDemo())
                .defaultAssignee(GenerateTestData.getDefaultAssignee())
                .build();
    }
}
