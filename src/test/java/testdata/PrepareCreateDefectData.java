package testdata;

import models.CreateDefectModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pages.services.LoginSite;
import tests.CreateProjectTest;
import utils.GenerateTestData;

public class PrepareCreateDefectData {
    private static final Logger LOGGER = LogManager.getLogger(PrepareCreateDefectData.class.getName());

    public static CreateDefectModel getValidDefectData() {
        LOGGER.info("Generate valid defect data");
        return CreateDefectModel
                .builder()
                .defectTitle(GenerateTestData.generateDefectTitle())
                .actualResult(GenerateTestData.generateActualResultDefect())
                .milestone(GenerateTestData.getMilestoneQase())
                .severity(GenerateTestData.getSeverity())
                .build();
    }
}
