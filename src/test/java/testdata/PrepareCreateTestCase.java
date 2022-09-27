package testdata;

import models.CreateProjectModel;
import models.CreateTestCaseModel;
import utils.GenerateTestData;

public class PrepareCreateTestCase {

    public static CreateTestCaseModel getCreateTestCaseValidData() {
        return CreateTestCaseModel
                .builder()
                .title(GenerateTestData.generateTitle())
                .status(GenerateTestData.getStatusTestCase())
                .description(GenerateTestData.generateDescription())
                .severity(GenerateTestData.getSeverity())
                .priority(GenerateTestData.getPriorityTestCase())
                .type(GenerateTestData.getTypeTestCase())
                .layer(GenerateTestData.getLayerTestCase())
                .isFlaky(GenerateTestData.getIsFlakyTestCase())
                .behavior(GenerateTestData.getBehaviorTestCase())
                .automationStatus(GenerateTestData.getAutomationStatusTestCase())
                .preCondition(GenerateTestData.generatePreConditions())
                .postConditions(GenerateTestData.generatePostConditions())
                .build();
    }
}
