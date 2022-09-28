package testdata;

import models.CreateRequirementsModel;
import models.CreateTestCaseModel;
import utils.GenerateTestData;

public class PrepareCreateRequirementsData {

    public static CreateRequirementsModel getCreateRequirementsValidData() {
        return CreateRequirementsModel
                .builder()
                .title(GenerateTestData.generateTitle())
                .description(GenerateTestData.generateDescription())
                .parent(GenerateTestData.getParent())
                .status(GenerateTestData.getStatusReq())
                .type(GenerateTestData.getTypeReq())
                .build();
    }

}
