package testdata;

import models.CreateProjectModel;
import models.CreateTestCaseModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateTestData;

public class PrepareCreateTestCase {
    private static final Logger LOGGER = LogManager.getLogger(PrepareCreateTestCase.class.getName());

    public static CreateTestCaseModel getCreateTestCaseValidData() {
        LOGGER.info("Generate test case valid data");
        return CreateTestCaseModel
                .builder()
                .title(GenerateTestData.generateTitle())
                .suite(GenerateTestData.getSuiteTestCase())
                .status(GenerateTestData.getStatusTestCase())
                .description(GenerateTestData.generateDescription())
                .severity(GenerateTestData.getSeverity())
                .priority(GenerateTestData.getPriorityTestCase())
                .type(GenerateTestData.getTypeTestCase())
                .layer(GenerateTestData.getLayerTestCase())
                .isFlaky(GenerateTestData.getIsFlakyTestCase())
                .milestone(GenerateTestData.getIsMilestoneDemo())
                .behavior(GenerateTestData.getBehaviorTestCase())
                .automationStatus(GenerateTestData.getAutomationStatusTestCase())
                .preCondition(GenerateTestData.generatePreConditions())
                .postConditions(GenerateTestData.generatePostConditions())
                .steps("Classic")
                .action(GenerateTestData.generateActionStepTestCase())
                .inputData(GenerateTestData.generateDataStepTestCase())
                .expectedResult(GenerateTestData.generateExpectedResultTestCase())
                .build();
    }
}
