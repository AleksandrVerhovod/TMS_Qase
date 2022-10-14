package apitests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import testdata.PrepareCreateDefectData;
import utils.GenerateTestData;

public class PrepareAPIData {

    private static final Logger LOGGER = LogManager.getLogger(PrepareCreateDefectData.class.getName());
    public static ProjectAPIModel getProjectData() {
        LOGGER.info("Generate valid defect data");
        return ProjectAPIModel
                .builder()
                .title(GenerateTestData.generateAPItitle())
                .code("APITest")
                .description(GenerateTestData.generateDescription())
                .build();
    }

    public static ProjectAPIModel getProjectCode () {
        LOGGER.info("Generate requirements project code");
        return ProjectAPIModel
                .builder()
                .code("APITEST")
                .build();
    }


}
