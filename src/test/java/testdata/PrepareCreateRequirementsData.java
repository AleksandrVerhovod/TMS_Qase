package testdata;

import models.CreateRequirementsModel;
import models.CreateTestCaseModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateTestData;

public class PrepareCreateRequirementsData {
    private static final Logger LOGGER = LogManager.getLogger(PrepareCreateRequirementsData.class.getName());

    public static CreateRequirementsModel getCreateRequirementsValidData() {
        LOGGER.info("Generate requirements valid data");
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
