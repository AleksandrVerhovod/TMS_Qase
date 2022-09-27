package testdata;

import models.CreateDefectModel;
import utils.GenerateTestData;

public class PrepareCreateDefectData {

    public static CreateDefectModel getValidDefectData() {
        return CreateDefectModel
                .builder()
                .defectTitle(GenerateTestData.generateDefectTitle())
                .actualResult(GenerateTestData.generateActualResultDefect())
                .milestone(GenerateTestData.getMilestone())
                .severity(GenerateTestData.getSeverity())
                .build();
    }

}
