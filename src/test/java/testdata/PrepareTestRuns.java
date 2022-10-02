package testdata;

import models.RegistrationModel;
import models.TestRunsModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateTestData;

public class PrepareTestRuns {
    private static final Logger LOGGER = LogManager.getLogger(PrepareTestRuns.class.getName());

    public static TestRunsModel getTestRunModelValidData() {
        LOGGER.info("Generate test run valid data");
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
